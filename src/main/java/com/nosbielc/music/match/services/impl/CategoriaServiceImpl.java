package com.nosbielc.music.match.services.impl;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.repositories.ICategoriaRepository;
import com.nosbielc.music.match.services.ICategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public Page<Categoria> findAllPageable(PageRequest pageRequest) {
        return this.categoriaRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return this.categoriaRepository.findById(id);
    }

    @Override
    public Categoria persist(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public void remove(Categoria categoria) {
        this.categoriaRepository.delete(categoria);
    }

    @Override
    public Optional<List<Categoria>> findAll() {
        return Optional.ofNullable(this.categoriaRepository.findAll());
    }

    @Override
    public Categoria findByChave(String chave) {
        return this.categoriaRepository.findByChave(chave);
    }
}
