package com.nosbielc.music.match.controllers;

import com.nosbielc.music.match.client.IOpenWeatherMapClient;
import com.nosbielc.music.match.client.ISpotifyClient;
import com.nosbielc.music.match.client.ISpotifyOauth;
import com.nosbielc.music.match.components.NegocioMusicMatch;
import com.nosbielc.music.match.controllers.util.IMusicMatchController;
import com.nosbielc.music.match.controllers.util.MusicMatchControllerUtil;
import com.nosbielc.music.match.dtos.*;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.enums.ParametroSolicitacaoEnum;
import com.nosbielc.music.match.response.Response;
import com.nosbielc.music.match.services.ISolicitacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static feign.Util.ISO_8859_1;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/musicMatch")
@CrossOrigin(origins = "*")
public class MusicMatchController extends MusicMatchControllerUtil implements IMusicMatchController {

    private static final Logger log = LoggerFactory.getLogger(MusicMatchController.class);

    @Autowired
    private ISolicitacaoService solicitacaoService;

    @Autowired
    private NegocioMusicMatch negocioMusicMatch;

    @Value("${paginacao.qtd_por_pagina}")
    private int paginacao;

    @Override
    public ResponseEntity<Response<Page<SolicitacaoDto>>> listar(
            @RequestParam(value = "pag", defaultValue = "0") Integer pag,
            @RequestParam(value = "ord", defaultValue = "id") String ord,
            @RequestParam(value = "dir", defaultValue = "DESC") String dir) {

        Response<Page<SolicitacaoDto>> response = new Response<>();
        PageRequest pageRequest = PageRequest.of(pag, this.paginacao, Sort.Direction.valueOf(dir), ord);
        Page<Solicitacao> solicitacoes = this.solicitacaoService.findAllPageable(pageRequest);
        Page<SolicitacaoDto> solicitacoesDtos = solicitacoes.map(
                solicit -> toSolicitacaoDto(solicit)
        );

        response.setData(solicitacoesDtos);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<List<TrackDto>>> musicMatchCity(
            @RequestParam(value = "cidade") String cidade) {
        Response<List<TrackDto>> response = new Response<>();
        return ResponseEntity.ok(this.negocioMusicMatch.executaMusicMatch(cidade, 0.00, 0.00));
    }

    @Override
    public ResponseEntity<Response<List<TrackDto>>> musicMatchCoordinates(@RequestParam(value = "lat") Double lat,
                                                                  @RequestParam(value = "lon") Double lon) {
        return ResponseEntity.ok(this.negocioMusicMatch.executaMusicMatch("", lat, lon));
    }

    @Deprecated
    public ResponseEntity<String> init(@RequestParam MultiValueMap<ParametroSolicitacaoEnum, String> params) {

        System.out.println(params);

        return ResponseEntity.ok("");
    }

}
