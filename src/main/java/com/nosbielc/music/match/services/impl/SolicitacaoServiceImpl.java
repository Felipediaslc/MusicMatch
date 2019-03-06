package com.nosbielc.music.match.services.impl;

import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.repositories.ISolicitacaoRepository;
import com.nosbielc.music.match.services.ISolicitacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoServiceImpl implements ISolicitacaoService {

    private static final Logger log = LoggerFactory.getLogger(SolicitacaoServiceImpl.class);

    @Autowired
    private ISolicitacaoRepository solicitacaoRepository;

    @Override
    public Page<Solicitacao> findAllPageable(PageRequest pageRequest) {
        return this.solicitacaoRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Solicitacao> findById(Long id) {
        return this.solicitacaoRepository.findById(id);
    }

    @Override
    public Solicitacao persist(Solicitacao solicitacao) {
        return this.solicitacaoRepository.save(solicitacao);
    }

    @Override
    public void remove(Solicitacao solicitacao) {
        this.solicitacaoRepository.delete(solicitacao);
    }

    @Override
    public Optional<List<Solicitacao>> findAll() {
        return Optional.ofNullable(this.solicitacaoRepository.findAll());
    }

    @Override
    public void update(Solicitacao solicitacao) {
        this.solicitacaoRepository.save(solicitacao);
    }
}
