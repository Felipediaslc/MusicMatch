package com.nosbielc.music.match.dtos.includs.playlist;

import java.io.Serializable;
import java.util.StringJoiner;

public class Images implements Serializable {

    private String height;
    private String url;
    private String width;

    public Images() {
    }

    public Images(String height, String url, String width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Images.class.getSimpleName() + "[", "]")
                .add("height='" + height + "'")
                .add("url='" + url + "'")
                .add("width='" + width + "'")
                .toString();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
