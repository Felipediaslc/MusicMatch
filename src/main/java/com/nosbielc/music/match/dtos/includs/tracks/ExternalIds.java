package com.nosbielc.music.match.dtos.includs.tracks;

import java.io.Serializable;
import java.util.StringJoiner;

public class ExternalIds implements Serializable {

    private String isrc;

    public ExternalIds() {
    }

    public ExternalIds(String isrc) {
        this.isrc = isrc;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExternalIds.class.getSimpleName() + "[", "]")
                .add("isrc='" + isrc + "'")
                .toString();
    }
}
