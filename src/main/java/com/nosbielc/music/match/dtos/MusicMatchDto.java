package com.nosbielc.music.match.dtos;

import java.io.Serializable;
import java.util.StringJoiner;

public class MusicMatchDto implements Serializable {

    private String cidade;
    private String lat;
    private String lon;

    @Override
    public String toString() {
        return new StringJoiner(", ", MusicMatchDto.class.getSimpleName() + "[", "]")
                .add("cidade='" + cidade + "'")
                .add("lat='" + lat + "'")
                .add("lon='" + lon + "'")
                .toString();
    }

    public MusicMatchDto() {
    }

    public MusicMatchDto(String cidade, String lat, String lon) {
        this.cidade = cidade;
        this.lat = lat;
        this.lon = lon;
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
