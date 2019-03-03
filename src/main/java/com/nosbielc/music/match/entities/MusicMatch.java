package com.nosbielc.music.match.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

@Entity
@Table(name = "music_match")
public class MusicMatch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Categoria categoria;

    @Column(name = "temperatura", nullable = false, unique = true)
    private String temperatura;

    @Column(name = "is_ativo", nullable = false)
    private Boolean ativo;

    public MusicMatch(Categoria categoria, String temperatura, Boolean ativo) {
        this.categoria = categoria;
        this.temperatura = temperatura;
        this.ativo = ativo;
    }

    public MusicMatch() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MusicMatch.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoria=" + categoria)
                .add("temperatura='" + temperatura + "'")
                .add("ativo=" + ativo)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
