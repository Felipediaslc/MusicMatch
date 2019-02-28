package com.nosbielc.music.match.dtos.includs.categorias;

import java.io.Serializable;
import java.util.StringJoiner;

public class Icons implements Serializable {

    private String height;
    private String width;
    private String url;

    public Icons() {
    }

    public Icons(String height, String width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Icons.class.getSimpleName() + "[", "]")
                .add("height='" + height + "'")
                .add("width='" + width + "'")
                .add("url='" + url + "'")
                .toString();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
