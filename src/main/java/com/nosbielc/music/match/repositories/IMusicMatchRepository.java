package com.nosbielc.music.match.repositories;

import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.entities.MusicMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMusicMatchRepository extends JpaRepository<MusicMatch, Long> {

    MusicMatch findByTemperatura(String temperatura);

    List<MusicMatch> findAllByCategoriaOrderByTemperatura(Categoria categoria);
}
