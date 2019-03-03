package com.nosbielc.music.match.repositories;

import com.nosbielc.music.match.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByChave(String chave);
}
