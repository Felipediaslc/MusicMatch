package com.nosbielc.music.match.dtos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.StringJoiner;

public class MusicMatchCoordinatesDto implements Serializable {

    @NotNull(message = "lat não pode ser null.")
    private Double lat;
    @NotNull(message = "lat não pode ser null.")
    private Double lon;

    @Override
    public String toString() {
        return new StringJoiner(", ", MusicMatchCoordinatesDto.class.getSimpleName() + "[", "]")
                .add("lat=" + lat)
                .add("lon=" + lon)
                .toString();
    }

    public MusicMatchCoordinatesDto(@NotNull(message = "lat não pode ser null.") Double lat, @NotNull(message = "lat não pode ser null.") Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
