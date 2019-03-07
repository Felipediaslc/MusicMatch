package com.nosbielc.music.match.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosbielc.music.match.components.NegocioMusicMatch;
import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.enums.SolicitacaoStatus;
import com.nosbielc.music.match.services.ISolicitacaoService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    private ISolicitacaoService solicitacaoService;

    @MockBean
    private NegocioMusicMatch negocioMusicMatch;

    private static final String URL_BASE = "/api/v1/match";
    private static final String NOME_CIDADE = "Recife";
    private static final Long ID_SOLICITACAO = 1L;

    @AfterClass
    public static void initBasic() {}

    @Test
    public void testBasic() {
        Assert.assertTrue(Boolean.TRUE);
    }

    public void testBuscarSolicticaoRecife() throws Exception {

        ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>(){{
            add(getDataSolicitacao());
        }};
        Page<Solicitacao> pages = new PageImpl<>(solicitacoes);
        //BDDMockito.given(this.solicitacaoService.findAllPageable(Mockito.any(PageRequest.class)))
        //        .willReturn(pages);

        Mockito.when(this.solicitacaoService.findAllPageable(Mockito.any(PageRequest.class)))
                .thenReturn(pages);

        mvc.perform(MockMvcRequestBuilders.get(URL_BASE)
                .accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.content[0].id").value(ID_SOLICITACAO))
                .andExpect(jsonPath("$.data.content[0].cidade").value(NOME_CIDADE))
                .andExpect(jsonPath("$.data.content[0].lat").value(0))
                .andExpect(jsonPath("$.data.content[0].lon").value(0))
                .andExpect(jsonPath("$.errors").isEmpty());
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

}
