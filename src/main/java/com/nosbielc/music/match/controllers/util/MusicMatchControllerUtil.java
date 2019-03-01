package com.nosbielc.music.match.controllers.util;

import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.utils.Base64;

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

    protected String base64Encode(byte[] bytes) {
        return Base64.encode(bytes);
    }

}
