package com.nosbielc.music.match.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chave", nullable = false, unique = true)
    private String chave;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<MusicMatch> musicMatches = new ArrayList<MusicMatch>();

    public Categoria() {
    }

    public Categoria(String chave, String nome) {
        this.chave = chave;
        this.nome = nome;
    }

    public static Categoria create(String chave, String nome) {
        return new Categoria(chave, nome);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Categoria.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("chave='" + chave + "'")
                .add("nome='" + nome + "'")
                .add("musicMatches=" + musicMatches)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<MusicMatch> getMusicMatches() {
        return musicMatches;
    }

    public void setMusicMatches(List<MusicMatch> musicMatches) {
        this.musicMatches = musicMatches;
    }
}
