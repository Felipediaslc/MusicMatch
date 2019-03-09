package com.nosbielc.music.match.repositories;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.enums.SolicitacaoStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolicitacaoRepositoryTest {

    @Autowired
    private ISolicitacaoRepository solicitacaoRepository;

    private static final Long CHAVE_SOLICITACAO = 1L;

    @Before
    public void setUp() {
        this.solicitacaoRepository.saveAll(createSolicitacoes());
    }

    @After
    public final void tearDown() {
        this.solicitacaoRepository.deleteAll();
    }

    @Test
    public void testBuscarPorId() {
        Page<Solicitacao> solicitacaoDB =
                this.solicitacaoRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id")));

        Assert.assertTrue(solicitacaoDB.getTotalElements() > 0);

        Solicitacao solicitacaoPage = solicitacaoDB.getContent().get(0);

        Assert.assertNotNull(solicitacaoPage);

        Optional<Solicitacao> solicitacao = this.solicitacaoRepository.findById(solicitacaoPage.getId());

        Assert.assertTrue(solicitacao.isPresent());
    }

    @Test
    public void testBuscarTodos(){
        Assert.assertTrue(this.solicitacaoRepository.count() == createSolicitacoes().size());
    }

    @Test
    public void testBuscarPorStatusRequerido() {

        long contadorMock = createSolicitacoes().stream().filter( f -> f.getSolicitacaoStatus().equals(SolicitacaoStatus.REQUERIDO)).count();
        long contadorDb = this.solicitacaoRepository.findAllBySolicitacaoStatusOrderByIdAsc(SolicitacaoStatus.REQUERIDO).get().stream().count();

        Assert.assertTrue(contadorDb == contadorMock);
    }

    @Test
    public void testBuscarPorStatusProcessamentComcluido() {

        long contadorMock = createSolicitacoes().stream().filter( f -> f.getSolicitacaoStatus().equals(SolicitacaoStatus.PROCESSAMENTO_CONCLUIDO)).count();
        long contadorDb = this.solicitacaoRepository.findAllBySolicitacaoStatusOrderByIdAsc(SolicitacaoStatus.PROCESSAMENTO_CONCLUIDO).get().stream().count();

        Assert.assertTrue(contadorDb == contadorMock);
    }

    @Test
    public void testBuscarPorStatusEmProcessamento() {

        long contadorMock = createSolicitacoes().stream().filter( f -> f.getSolicitacaoStatus().equals(SolicitacaoStatus.PROCESSANDO)).count();
        long contadorDb = this.solicitacaoRepository.findAllBySolicitacaoStatusOrderByIdAsc(SolicitacaoStatus.PROCESSANDO).get().stream().count();

        Assert.assertTrue(contadorDb == contadorMock);
    }

    @Test
    public void testBuscarPorStatusPendente() {

        long contadorMock = createSolicitacoes().stream().filter( f -> f.getSolicitacaoStatus().equals(SolicitacaoStatus.PENDENTE)).count();
        long contadorDb = this.solicitacaoRepository.findAllBySolicitacaoStatusOrderByIdAsc(SolicitacaoStatus.PENDENTE).get().stream().count();

        Assert.assertTrue(contadorDb == contadorMock);
    }

    List<Solicitacao> createSolicitacoes() {
        return Arrays.asList(
                Solicitacao.create("Recife", "0", "0", SolicitacaoStatus.REQUERIDO),
                Solicitacao.create("São Paulo", "0", "0", SolicitacaoStatus.PROCESSAMENTO_CONCLUIDO),
                Solicitacao.create("Toronto", "0", "0", SolicitacaoStatus.PROCESSAMENTO_CONCLUIDO),
                Solicitacao.create("Palmares", "0", "0", SolicitacaoStatus.ERRO_PROCESSAMENTO),
                Solicitacao.create("Tóquio", "0", "0", SolicitacaoStatus.PENDENTE),
                Solicitacao.create("Xangai", "0", "0", SolicitacaoStatus.PROCESSANDO),
                Solicitacao.create(" ", "02", "-60", SolicitacaoStatus.PENDENTE),
                Solicitacao.create(" ", "-10", "-48", SolicitacaoStatus.REQUERIDO),
                Solicitacao.create(" ", "-08", "-36", SolicitacaoStatus.PROCESSAMENTO_CONCLUIDO),
                Solicitacao.create(" ", "-09", "-67", SolicitacaoStatus.REQUERIDO),
                Solicitacao.create(" ", "-08", "-34", SolicitacaoStatus.PROCESSANDO)
        );
    }

}
