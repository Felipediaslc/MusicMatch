package com.nosbielc.music.match.components;

import com.nosbielc.music.match.client.IOpenWeatherMapClient;
import com.nosbielc.music.match.client.ISpotifyClient;
import com.nosbielc.music.match.client.ISpotifyOauth;
import com.nosbielc.music.match.dtos.*;
import com.nosbielc.music.match.dtos.includs.tracks.Track;
import com.nosbielc.music.match.entities.MusicMatch;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.enums.SolicitacaoStatus;
import com.nosbielc.music.match.repositories.IMusicMatchRepository;
import com.nosbielc.music.match.response.Response;
import com.nosbielc.music.match.services.ISolicitacaoService;
import com.nosbielc.music.match.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NegocioMusicMatch implements INegocioMusicMatch {

    private static final Logger log = LoggerFactory.getLogger(NegocioMusicMatch.class);

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

    @Autowired
    private ISolicitacaoService solicitacaoService;

    @Override
    public Optional<OpenWeatherDto> buscarTemperaturaDaCidade(String cidade) {
        if (cidade != null) {
            return Optional.of(this.IOpenWeatherMapClient.getByCityName(cidade, appId).getBody());
        }
        return Optional.empty();
    }

    @Override
    public Optional<OpenWeatherDto> buscarTemperaturaDaCidadePorCoordenadas(Double lat,
            Double lon){
            return Optional.of(
                    this.IOpenWeatherMapClient.getByGeographicCoordinates(lat, lon, appId).getBody());
    }

    @Override
    public Optional<MusicMatch> buscarMusicMatchPorTemperatura(Integer temperatura) {
        return Optional.of(this.musicMatchRepository.findByTemperatura(String.valueOf(temperatura)));
    }

    @Override
    public Optional<SpotifyOauthDto> pegaTokenSpotify() {
        return Optional.of(this.spotifyOauth.getToken(Utils.geraBaseAtenticacao(
                userName, password)).getBody());
    }

    @Override
    public Optional<SpotifyPlayListDto> pegaPlayListDaCategoria(String token, String categoria) {
        return Optional.of(
                this.sportifyClient.getPlayListByCategoria(token, categoria).getBody());
    }

    @Override
    public Optional<SpotifyTracksDto> pegaMusicasDaPlayList(String token, String idPlayList, String limit) {
        return Optional.of(
                this.sportifyClient.getTracksByPlayList(token,
                        idPlayList).getBody());
    }

    @Override
    public List<TrackDto> spotifyTracksDtoToListTrackDto(SpotifyTracksDto spotifyTracksDto) {
        List<TrackDto> trackDtos = new ArrayList<>();

        spotifyTracksDto.getItems().stream()
                .filter(pred -> pred.getTrack() != null
                        && pred.getTrack().getPreviewUrl() != null)
                .forEach(items -> {

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
        Solicitacao solicitacao = new Solicitacao();

        if (cidade != null && !cidade.equals("")) {
            openWeatherDto = this.buscarTemperaturaDaCidade(cidade);
            solicitacao = this.solicitacaoService
                    .persist(new Solicitacao(cidade, SolicitacaoStatus.REQUERIDO));

        } else if (lat != null || lon != null && cidade.equals("")) {
            openWeatherDto = this.buscarTemperaturaDaCidadePorCoordenadas(lat, lon);
            solicitacao = this.solicitacaoService.persist(new Solicitacao(
                            String.valueOf(lat),
                            String.valueOf(lon), SolicitacaoStatus.REQUERIDO));
        }

        if (openWeatherDto.isPresent()) {

            int temperaturaCapturada = (int) Math.round(openWeatherDto.get().getPrincipal().getTemp()) - 273;

            log.info(String.format("Temperatura Capturada: %s", temperaturaCapturada));

            Optional<MusicMatch> musicMatch =
                    this.buscarMusicMatchPorTemperatura(
                            temperaturaCapturada);

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
                            response.addWarns("Serviço do Spotity com problemas (Tracks).");
                        }

                    } else {
                        response.addWarns("Serviço do Spotity com problemas (PlayList).");
                    }

                } else {
                    response.addWarns("Serviço do Spotity com problemas (Oauth).");
                }

            } else {
                response.addWarns("Range do MusicMatch não cadastrado.");
            }

        } else {
            response.addWarns("Houve um erro ao pegar temperatura do local solicitado.");
        }

        if (response.getWarns().size() > 0) {
            solicitacao.setSolicitacaoStatus(SolicitacaoStatus.ERRO_PROCESSAMENTO);
            this.solicitacaoService.persist(solicitacao);
        } else {
            solicitacao.setSolicitacaoStatus(SolicitacaoStatus.PROCESSAMENTO_CONCLUIDO);
            this.solicitacaoService.persist(solicitacao);
        }

        return response;
    }

    @Override
    public SolicitacaoDto parseSolicitacaoDto(Solicitacao solicitacao) {
        SolicitacaoDto solicitacaoDto = new SolicitacaoDto();
        solicitacaoDto.setCidade(solicitacao.getCidade());
        solicitacaoDto.setLat(solicitacao.getLat());
        solicitacaoDto.setLon(solicitacao.getLon());
        solicitacaoDto.setId(Optional.ofNullable(solicitacao.getId()));
        return solicitacaoDto;
    }

    @Override
    public Response<Page<SolicitacaoDto>> listarSolicitacoes(Integer pag, String ord, String dir) {
        Response<Page<SolicitacaoDto>> response = new Response<>();
        PageRequest pageRequest = PageRequest.of(pag, this.paginacao, Sort.Direction.valueOf(dir), ord);
        Page<Solicitacao> solicitacoes = this.solicitacaoService.findAllPageable(pageRequest);
        Page<SolicitacaoDto> solicitacoesDtos = solicitacoes.map(
                solicit -> parseSolicitacaoDto(solicit)
        );

        response.setData(solicitacoesDtos);

        return response;
    }

}
