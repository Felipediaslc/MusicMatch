package com.nosbielc.music.match.services;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.entities.MusicMatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IMusicMatchService {

    Page<MusicMatch> findAllPageable(PageRequest pageRequest);

    Optional<MusicMatch> findById(Long id);

    MusicMatch persist(MusicMatch musicMatch);

    void remove(MusicMatch musicMatch);

    Optional<List<MusicMatch>> findAll();

    MusicMatch findByTemperatura(String temperatura);

    List<MusicMatch> findAllByCategoriaOrderByTemperatura(Categoria categoria);

}
