package com.nosbielc.music.match.dtos;

import java.io.Serializable;
import java.util.Optional;
import java.util.StringJoiner;

public class SolicitacaoDto implements Serializable {

    private Optional<Long> id = Optional.empty();
    private String cidade;
    private String lat;
    private String lon;

    public SolicitacaoDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SolicitacaoDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cidade='" + cidade + "'")
                .add("lat='" + lat + "'")
                .add("lon='" + lon + "'")
                .toString();
    }

    public SolicitacaoDto(Optional<Long> id, String cidade, String lat, String lon) {
        this.id = id;
        this.cidade = cidade;
        this.lat = lat;
        this.lon = lon;
    }

    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
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
}
