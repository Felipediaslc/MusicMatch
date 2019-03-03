package com.nosbielc.music.match.services;

import com.nosbielc.music.match.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    Page<Categoria> findAllPageable(PageRequest pageRequest);

    Optional<Categoria> findById(Long id);

    Categoria persist(Categoria categoria);

    void remove(Categoria categoria);

    Optional<List<Categoria>> findAll();

    Categoria findByChave(String chave);

}
