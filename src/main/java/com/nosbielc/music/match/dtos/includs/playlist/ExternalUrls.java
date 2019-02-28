package com.nosbielc.music.match.dtos.includs.playlist;

import java.io.Serializable;
import java.util.StringJoiner;

public class ExternalUrls implements Serializable {

    private String spotify;

    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExternalUrls.class.getSimpleName() + "[", "]")
                .add("spotify='" + spotify + "'")
                .toString();
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
