package com.nosbielc.music.match.dtos;

import java.io.Serializable;
import java.util.StringJoiner;

public class TrackDto implements Serializable {

    private String discNumber;

    private String durationMs;

    private String espisode;
    private String explicit;
    private String href;
    private String id;

    private String isLocal;

    private String name;
    private String popularity;
    private String previewUrl;
    private String track;
    private String trackNumber;
    private String type;
    private String uri;

    @Override
    public String toString() {
        return new StringJoiner(", ", TrackDto.class.getSimpleName() + "[", "]")
                .add("discNumber='" + discNumber + "'")
                .add("durationMs='" + durationMs + "'")
                .add("espisode='" + espisode + "'")
                .add("explicit='" + explicit + "'")
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("isLocal='" + isLocal + "'")
                .add("name='" + name + "'")
                .add("popularity='" + popularity + "'")
                .add("previewUrl='" + previewUrl + "'")
                .add("track='" + track + "'")
                .add("trackNumber='" + trackNumber + "'")
                .add("type='" + type + "'")
                .add("uri='" + uri + "'")
                .toString();
    }

    public TrackDto(String discNumber, String durationMs, String espisode, String explicit, String href,
                    String id, String isLocal, String name, String popularity, String previewUrl,
                    String track, String trackNumber, String type, String uri) {
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.espisode = espisode;
        this.explicit = explicit;
        this.href = href;
        this.id = id;
        this.isLocal = isLocal;
        this.name = name;
        this.popularity = popularity;
        this.previewUrl = previewUrl;
        this.track = track;
        this.trackNumber = trackNumber;
        this.type = type;
        this.uri = uri;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(String durationMs) {
        this.durationMs = durationMs;
    }

    public String getEspisode() {
        return espisode;
    }

    public void setEspisode(String espisode) {
        this.espisode = espisode;
    }

    public String getExplicit() {
        return explicit;
    }

    public void setExplicit(String explicit) {
        this.explicit = explicit;
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

    public String getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(String isLocal) {
        this.isLocal = isLocal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
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
