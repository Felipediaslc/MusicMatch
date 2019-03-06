package com.nosbielc.music.match.entities;

import com.nosbielc.music.match.enums.SolicitacaoStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

@Entity
@Table(name = "solicitacao")
public class Solicitacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @Enumerated(EnumType.ORDINAL)
    private SolicitacaoStatus solicitacaoStatus;

    public Solicitacao() {
    }

    public Solicitacao(String cidade, SolicitacaoStatus solicitacaoStatus) {
        this.cidade = cidade;
        this.lat = "0";
        this.lon = "0";
        this.solicitacaoStatus = solicitacaoStatus;
    }

    public Solicitacao(String cidade, String lat, String lon, SolicitacaoStatus solicitacaoStatus) {
        this.cidade = cidade;
        this.lat = lat;
        this.lon = lon;
        this.solicitacaoStatus = solicitacaoStatus;
    }

    public Solicitacao(String lat, String lon, SolicitacaoStatus solicitacaoStatus) {
        this.cidade = " ";
        this.lat = lat;
        this.lon = lon;
        this.solicitacaoStatus = solicitacaoStatus;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Solicitacao.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cidade='" + cidade + "'")
                .add("lat='" + lat + "'")
                .add("lon='" + lon + "'")
                .add("solicitacaoStatus=" + solicitacaoStatus)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public SolicitacaoStatus getSolicitacaoStatus() {
        return solicitacaoStatus;
    }

    public void setSolicitacaoStatus(SolicitacaoStatus solicitacaoStatus) {
        this.solicitacaoStatus = solicitacaoStatus;
    }
}
