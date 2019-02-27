package com.nosbielc.music.match.controllers.util;

import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.entities.Solicitacao;

import java.util.Optional;

public class MusicMatchControllerUtil {

    protected SolicitacaoDto toSolicitacaoDto(Solicitacao solicitacao) {
        SolicitacaoDto solicitacaoDto = new SolicitacaoDto();
        solicitacaoDto.setCidade(solicitacao.getCidade());
        solicitacaoDto.setLat(solicitacao.getLat());
        solicitacaoDto.setLon(solicitacao.getLon());
        solicitacaoDto.setId(Optional.ofNullable(solicitacao.getId()));
        return solicitacaoDto;
    }

}
