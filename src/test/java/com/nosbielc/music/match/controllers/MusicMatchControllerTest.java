package com.nosbielc.music.match.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosbielc.music.match.components.NegocioMusicMatch;
import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.enums.SolicitacaoStatus;
import com.nosbielc.music.match.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MusicMatchControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NegocioMusicMatch negocioMusicMatch;

    private static final String URL_BASE = "/api/v1/match";
    private static final String NOME_CIDADE = "Recife";
    private static final Long ID_SOLICITACAO = 1L;

    @Test
    public void testBuscarSolicticao() throws Exception {
        Page<SolicitacaoDto> pages = new PageImpl<>(
                new ArrayList<SolicitacaoDto>() {{
                    add(toSolicitacaoDto());
                }});
        Response<Page<SolicitacaoDto>> response = new Response<>();
        response.setData(pages);

        BDDMockito.given(
                this.negocioMusicMatch.listarSolicitacoes(
                        Mockito.anyInt(), Mockito.anyString(), Mockito.anyString()))
                .willReturn(response);

        mvc.perform(MockMvcRequestBuilders.get(URL_BASE)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.content[0].id").value(ID_SOLICITACAO))
                .andExpect(jsonPath("$.data.content[0].cidade").value(NOME_CIDADE))
                .andExpect(jsonPath("$.data.content[0].lat").value(0))
                .andExpect(jsonPath("$.data.content[0].lon").value(0))
                .andExpect(jsonPath("$.warns").isEmpty());
    }

    @Test
    public void testBuscarSemDados() throws Exception {
        Page<SolicitacaoDto> pages = new PageImpl<>(new ArrayList<>());
        Response<Page<SolicitacaoDto>> response = new Response<>();
        response.setData(pages);

        BDDMockito.given(
                this.negocioMusicMatch.listarSolicitacoes(
                        Mockito.anyInt(), Mockito.anyString(), Mockito.anyString()))
                .willReturn(response);

        mvc.perform(MockMvcRequestBuilders.get(URL_BASE)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.content").isEmpty())
                .andExpect(jsonPath("$.warns").isEmpty());
    }

    private String getJsonRequestBuscarSolicticaoRecife() throws JsonProcessingException {
        SolicitacaoDto solicitacaoDto = new SolicitacaoDto();
        solicitacaoDto.setCidade(NOME_CIDADE);
        solicitacaoDto.setId(Optional.of(ID_SOLICITACAO));
        solicitacaoDto.setLat("0");
        solicitacaoDto.setLon("0");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(solicitacaoDto);
    }

    private Solicitacao getDataSolicitacao() {
        Solicitacao solicitacaoRecife =  new Solicitacao(NOME_CIDADE, SolicitacaoStatus.REQUERIDO);
        solicitacaoRecife.setId(ID_SOLICITACAO);
        return solicitacaoRecife;
    }

    private String getJsonRequestBody(HashMap<String, Object> jsonBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(jsonBody);
    }

    private SolicitacaoDto toSolicitacaoDto() {
        Solicitacao solicitacaoRecife =  getDataSolicitacao();
        SolicitacaoDto solicitacaoDto = new SolicitacaoDto(Optional.ofNullable(solicitacaoRecife.getId()),
                solicitacaoRecife.getCidade(),
                solicitacaoRecife.getLat(),
                solicitacaoRecife.getLon());
        return solicitacaoDto;
    }

}
