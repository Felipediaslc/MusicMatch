package com.nosbielc.music.match.dtos.includs.tracks;

import java.io.Serializable;
import java.util.StringJoiner;

public class VideoThumbnail implements Serializable {

    private String url;

    public VideoThumbnail() {
    }

    public VideoThumbnail(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VideoThumbnail.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .toString();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
