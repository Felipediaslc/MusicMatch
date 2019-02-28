package com.nosbielc.music.match.dtos.includs.playlist;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;
import java.util.StringJoiner;

public class Owner implements Serializable {

    @JsonAlias("display_name")
    private String displayName;
    private String href;
    private String id;
    private String type;
    private String uri;

    @JsonAlias("external_urls")
    private ExternalUrls externalUrls;

    public Owner(String displayName, String href, String id, String type, String uri, ExternalUrls externalUrls) {
        this.displayName = displayName;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
        this.externalUrls = externalUrls;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Owner.class.getSimpleName() + "[", "]")
                .add("displayName='" + displayName + "'")
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("type='" + type + "'")
                .add("uri='" + uri + "'")
                .add("externalUrls=" + externalUrls)
                .toString();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }
}
