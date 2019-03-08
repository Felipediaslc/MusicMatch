package com.nosbielc.music.match.controllers.repositories;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.repositories.ICategoriaRepository;
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
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoriaRepositoryTest {

    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    private static final String CHAVE_CATEGORIA = "categoriaTeste";

    @Before
    public void setUp() {
        this.iCategoriaRepository.save(Categoria.create(CHAVE_CATEGORIA, "Categoria usada para tests"));
        this.iCategoriaRepository.saveAll(createCategorias());
    }

    @After
    public final void tearDown() {
        this.iCategoriaRepository.deleteAll();
    }

    @Test
    public void testBuscarTodosPorId() {
        int totalcategorias = createCategorias().size() + 1;
        for (int i = 1; i <= totalcategorias; i++) {
            Optional<Categoria> categoriaOptional = this.iCategoriaRepository.findById((long) i);
            Assert.assertTrue(categoriaOptional.isPresent());
        }
    }

    // TODO esse teste pode ser deletado depois
    @Test
    public void testVerificaTotalRegistros() {
        Assert.assertTrue((createCategorias().size() + 1 ) == this.iCategoriaRepository.count());
    }

    @Test
    public void testBuscarPorChave() {
        Categoria categoria = this.iCategoriaRepository.findByChave(CHAVE_CATEGORIA);

        Assert.assertEquals(CHAVE_CATEGORIA, categoria.getChave());
    }

    List<Categoria> createCategorias() {
        return Arrays.asList(
                Categoria.create( "chave1", "Nome da categoria"),
                Categoria.create("chave2", "Nome da categoria"),
                Categoria.create("chave3", "Nome da categoria"),
                Categoria.create("chave4", "Nome da categoria")
        );
    }

}
