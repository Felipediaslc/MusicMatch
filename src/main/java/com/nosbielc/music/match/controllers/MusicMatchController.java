package com.nosbielc.music.match.controllers;

import com.nosbielc.music.match.client.IOpenWeatherMapClient;
import com.nosbielc.music.match.client.ISpotifyClient;
import com.nosbielc.music.match.controllers.util.IMusicMatchController;
import com.nosbielc.music.match.controllers.util.MusicMatchControllerUtil;
import com.nosbielc.music.match.dtos.OpenWeatherDto;
import com.nosbielc.music.match.dtos.SolicitacaoDto;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/musicMatch")
@CrossOrigin(origins = "*")
public class MusicMatchController extends MusicMatchControllerUtil implements IMusicMatchController {

    private static final Logger log = LoggerFactory.getLogger(MusicMatchController.class);

    @Autowired
    private ISolicitacaoService solicitacaoService;

    @Autowired
    private IOpenWeatherMapClient IOpenWeatherMapClient;

    @Autowired
    private ISpotifyClient sportifyClient;

    @Value("${paginacao.qtd_por_pagina}")
    private int paginacao;

    @Value("${openweathermap.key}")
    private String appId;

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
    public ResponseEntity<Response<String>> musicMatchCity(
            @RequestParam(value = "cidade") String cidade) {
        Response<String> response = new Response<>();

        // TODO celsius = kelvin - 273.0;

        OpenWeatherDto resultPorCidade = this.IOpenWeatherMapClient.getByCityName(cidade, appId).getBody();

        String teste = this.sportifyClient.getCategorias(
                "Bearer BQB0siKl5FV55hP2mEy2YB6HAoUC7adsVswEBdqGmBPQqIwj8Axu5y2tPT7OrN1LQXP425K-x8kqA3cGCeQ",
                "0", "50").getBody();

        response.setData(String.format("A temperatura informada pelo servico foi: %s",
                (resultPorCidade.getPrincipal().getTemp() - 273.0)));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<String>> musicMatchCoordinates(@RequestParam(value = "lat") Double lat,
                                                                  @RequestParam(value = "lon") Double lon) {
        Response<String> response = new Response<>();

        OpenWeatherDto resultPorCidade =
                this.IOpenWeatherMapClient.getByGeographicCoordinates(lat,
                        lon, appId).getBody();

        response.setData(String.format("A temperatura informada pelo servico foi: %s",
                (resultPorCidade.getPrincipal().getTemp() - 273.0)));

        return ResponseEntity.ok(response);
    }

    @Deprecated
    public ResponseEntity<String> init(@RequestParam MultiValueMap<ParametroSolicitacaoEnum, String> params) {

        System.out.println(params);

        return ResponseEntity.ok("");
    }

}
