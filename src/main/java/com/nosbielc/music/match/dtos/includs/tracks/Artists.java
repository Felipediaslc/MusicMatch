package com.nosbielc.music.match.dtos.includs.tracks;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.playlist.ExternalUrls;

import java.io.Serializable;
import java.util.StringJoiner;

public class Artists implements Serializable {

    private String uri;
    private String type;
    @JsonAlias("external_urls")
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private String name;


    public Artists(String href, String id, String name, String type, String uri, ExternalUrls externalUrls) {
        this.href = href;
        this.id = id;
        this.name = name;
        this.type = type;
        this.uri = uri;
        this.externalUrls = externalUrls;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Artists.class.getSimpleName() + "[", "]")
                .add("uri='" + uri + "'")
                .add("type='" + type + "'")
                .add("externalUrls=" + externalUrls)
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .toString();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }
}
