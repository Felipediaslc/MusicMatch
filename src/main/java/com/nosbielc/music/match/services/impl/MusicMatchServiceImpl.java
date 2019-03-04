package com.nosbielc.music.match.services.impl;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.entities.MusicMatch;
import com.nosbielc.music.match.repositories.IMusicMatchRepository;
import com.nosbielc.music.match.services.IMusicMatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicMatchServiceImpl implements IMusicMatchService {

    private static final Logger log = LoggerFactory.getLogger(MusicMatchServiceImpl.class);

    @Autowired
    IMusicMatchRepository musicMatchRepository;

    @Override
    public Page<MusicMatch> findAllPageable(PageRequest pageRequest) {
        return this.musicMatchRepository.findAll(pageRequest);
    }

    @Override
    public Optional<MusicMatch> findById(Long id) {
        return this.musicMatchRepository.findById(id);
    }

    @Override
    public MusicMatch persist(MusicMatch musicMatch) {
        return this.musicMatchRepository.save(musicMatch);
    }

    @Override
    public void remove(MusicMatch musicMatch) {
        this.musicMatchRepository.delete(musicMatch);
    }

    @Override
    public Optional<List<MusicMatch>> findAll() {
        return Optional.ofNullable(this.musicMatchRepository.findAll());
    }

    @Override
    public MusicMatch findByTemperatura(String temperatura) {
        return this.musicMatchRepository.findByTemperatura(temperatura);
    }

    @Override
    public List<MusicMatch> findAllByCategoriaOrderByTemperatura(Categoria categoria) {
        return this.musicMatchRepository.findAllByCategoriaOrderByTemperatura(categoria);
    }
}
