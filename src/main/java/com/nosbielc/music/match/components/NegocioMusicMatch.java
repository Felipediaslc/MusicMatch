package com.nosbielc.music.match.components;

import com.nosbielc.music.match.client.IOpenWeatherMapClient;
import com.nosbielc.music.match.client.ISpotifyClient;
import com.nosbielc.music.match.client.ISpotifyOauth;
import com.nosbielc.music.match.dtos.*;
import com.nosbielc.music.match.dtos.includs.tracks.Track;
import com.nosbielc.music.match.entities.MusicMatch;
import com.nosbielc.music.match.repositories.IMusicMatchRepository;
import com.nosbielc.music.match.response.Response;
import com.nosbielc.music.match.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NegocioMusicMatch implements INegocioMusicMatch {

    @Value("${paginacao.qtd_por_pagina}")
    private int paginacao;

    @Value("${openweathermap.key}")
    private String appId;

    @Value("${spotify.clientId}")
    private String userName;

    @Value("${spotify.clientSecret}")
    private String password;

    @Autowired
    private IOpenWeatherMapClient IOpenWeatherMapClient;

    @Autowired
    private ISpotifyOauth spotifyOauth;

    @Autowired
    private ISpotifyClient sportifyClient;

    @Autowired
    IMusicMatchRepository musicMatchRepository;

    @Override
    public Optional<OpenWeatherDto> buscarTemperaturaDaCidade(String cidade) {
        if (cidade != null) {
            return Optional.ofNullable(this.IOpenWeatherMapClient.getByCityName(cidade, appId).getBody());
        }
        return Optional.empty();
    }

    @Override
    public Optional<OpenWeatherDto> buscarTemperaturaDaCidadePorCoordenadas(Double lat,
            Double lon){
            return Optional.ofNullable(
                    this.IOpenWeatherMapClient.getByGeographicCoordinates(lat, lon, appId).getBody());
    }

    @Override
    public Optional<MusicMatch> buscarMusicMatchPorTemperatura(Integer temperatura) {
        return Optional.ofNullable(this.musicMatchRepository.findByTemperatura(String.valueOf(temperatura)));
    }

    @Override
    public Optional<SpotifyOauthDto> pegaTokenSpotify() {
        return Optional.ofNullable(this.spotifyOauth.getToken(Utils.geraBaseAtenticacao(
                userName, password)).getBody());
    }

    @Override
    public Optional<SpotifyPlayListDto> pegaPlayListDaCategoria(String token, String categoria) {
        return Optional.ofNullable(
                this.sportifyClient.getPlayListByCategoria(token, categoria).getBody());
    }

    @Override
    public Optional<SpotifyTracksDto> pegaMusicasDaPlayList(String token, String idPlayList, String limit) {
        return Optional.ofNullable(
                this.sportifyClient.getTracksByPlayList(token,
                        idPlayList).getBody());
    }

    @Override
    public List<TrackDto> spotifyTracksDtoToListTrackDto(SpotifyTracksDto spotifyTracksDto) {
        List<TrackDto> trackDtos = new ArrayList<>();

        spotifyTracksDto.getItems().stream().forEach(items -> {

            Track track = items.getTrack();
            trackDtos.add(new TrackDto(track.getDiscNumber(),
                    track.getDurationMs(),
                    track.getEspisode(),
                    track.getExplicit(),
                    track.getHref(),
                    track.getId(),
                    track.getIsLocal(),
                    track.getName(),
                    track.getPopularity(),
                    track.getPreviewUrl(),
                    track.getTrack(),
                    track.getTrackNumber(),
                    track.getType(),
                    track.getUri()));
        });

        return trackDtos;
    }

    @Override
    public Response<List<TrackDto>> executaMusicMatch(String cidade, Double lat, Double lon) {
        Response<List<TrackDto>> response = new Response<>();
        Optional<OpenWeatherDto> openWeatherDto = Optional.empty();

        if (cidade != null && cidade != "") {
            openWeatherDto = this.buscarTemperaturaDaCidade(cidade);

        } else if (lat > 0 || lon > 0 && cidade == "") {
            openWeatherDto = this.buscarTemperaturaDaCidadePorCoordenadas(lat, lon);
        }

        if (openWeatherDto.isPresent()) {

            Optional<MusicMatch> musicMatch =
                    this.buscarMusicMatchPorTemperatura(
                            (int) Math.round(openWeatherDto.get().getPrincipal().getTemp()) - 273);

            if (musicMatch.isPresent()) {

                Optional<SpotifyOauthDto> spotifyOauthDto = this.pegaTokenSpotify();

                if (spotifyOauthDto.isPresent()) {

                    String token = Utils.geraBearerAtenticacao(spotifyOauthDto.get());

                    Optional<SpotifyPlayListDto> spotifyPlayListDto =
                            this.pegaPlayListDaCategoria(token, musicMatch.get().getCategoria().getChave());

                    if (spotifyPlayListDto.isPresent()) {

                        Optional<SpotifyTracksDto> spotifyTracksDto =
                                this.pegaMusicasDaPlayList( token,
                                        spotifyPlayListDto.get().getPlayLists().getItems().get(0).getId(), "100");

                        if (spotifyTracksDto.isPresent()) {
                            response.setData(this.spotifyTracksDtoToListTrackDto(spotifyTracksDto.get()));
                        } else {
                            response.addError("Serviço do Spotity com problemas (Tracks).");
                        }

                    } else {
                        response.addError("Serviço do Spotity com problemas (PlayList).");
                    }

                } else {
                    response.addError("Serviço do Spotity com problemas (Oauth).");
                }

            } else {
                response.addError("range do MusicMatch não cadastrado.");
            }

        } else {
            response.addError("Houve um erro ao pegar temperatura do local solicitado.");
        }

        return response;
    }

    public void teste() {
         SpotifyOauthDto spotifyOauthDto =
                this.spotifyOauth.getToken(
                         Utils.geraBaseAtenticacao(
                                userName, password)).getBody();
         String token = Utils.geraBearerAtenticacao(spotifyOauthDto);

        ResponseEntity retorno =
                sportifyClient.getTeste(token, "");
    }


}
