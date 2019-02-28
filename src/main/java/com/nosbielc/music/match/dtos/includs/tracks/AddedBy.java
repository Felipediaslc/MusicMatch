package com.nosbielc.music.match.dtos.includs.tracks;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.playlist.ExternalUrls;

import java.io.Serializable;
import java.util.StringJoiner;

public class AddedBy implements Serializable {

    @JsonAlias("external_urls")
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private String type;
    private String uri;

    public AddedBy(ExternalUrls externalUrls, String href, String id, String type, String uri) {
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddedBy.class.getSimpleName() + "[", "]")
                .add("externalUrls=" + externalUrls)
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("type='" + type + "'")
                .add("uri='" + uri + "'")
                .toString();
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
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
}
