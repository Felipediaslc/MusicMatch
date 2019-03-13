package com.nosbielc.music.match.repositories;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.entities.MusicMatch;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MusicMatchRepositoryTest {

    @Autowired
    IMusicMatchRepository musicMatchRepository;

    @Autowired
    ICategoriaRepository categoriaRepository;

    private static final Long CHAVE_SOLICITACAO = 1L;
    private List<Categoria> categorias;

    @Before
    public void setUp() {
        categorias = this.categoriaRepository.saveAll(mockCategorias());
        this.musicMatchRepository.saveAll(criaMusicMatchs(categorias));
    }

    @After
    public final void tearDown() {
        this.musicMatchRepository.deleteAll();
    }

    @Test
    public void testBuscarTodos(){
        Assert.assertTrue(this.musicMatchRepository.count() == criaMusicMatchs( categorias).size());
    }

    List<Categoria> mockCategorias() {
        return Arrays.asList(
                Categoria.create( "muito_frio", "Muito Frio"),
                Categoria.create("morno", "Legal ( Cool )"),
                Categoria.create( "virando_torresmo", "Estais a virar um torresmo")
        );
    }

    List<MusicMatch> criaMusicMatchs(List<Categoria> categorias) {
        return Arrays.asList(
                MusicMatch.create(categorias.get(0), "-20", Boolean.TRUE),
                MusicMatch.create(categorias.get(0), "-10", Boolean.TRUE),
                MusicMatch.create(categorias.get(0), "0", Boolean.TRUE),
                MusicMatch.create(categorias.get(0), "10", Boolean.TRUE),
                MusicMatch.create(categorias.get(0), "20", Boolean.TRUE),
                MusicMatch.create(categorias.get(1), "30", Boolean.TRUE),
                MusicMatch.create(categorias.get(1), "40", Boolean.TRUE),
                MusicMatch.create(categorias.get(2), "50", Boolean.TRUE),
                MusicMatch.create(categorias.get(2), "60", Boolean.TRUE),
                MusicMatch.create(categorias.get(2), "70", Boolean.TRUE),
                MusicMatch.create(categorias.get(2), "80", Boolean.TRUE)
        );
    }

}
