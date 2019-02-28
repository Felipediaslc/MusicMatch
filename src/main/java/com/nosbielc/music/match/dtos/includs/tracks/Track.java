package com.nosbielc.music.match.dtos.includs.tracks;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.playlist.ExternalUrls;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class Track implements Serializable {

    @JsonAlias("disc_number")
    private String discNumber;

    @JsonAlias("duration_ms")
    private String durationMs;

    private String espisode;
    private String explicit;
    private String href;
    private String id;

    @JsonAlias("is_local")
    private String isLocal;

    private String name;
    private String popularity;
    @JsonAlias("preview_url")
    private String previewUrl;
    private String track;
    @JsonAlias("track_number")
    private String trackNumber;
    private String type;
    private String uri;

    private List<Artists> artists;

    @JsonAlias("available_markets")
    private List<String> availableMarkets;

    @JsonAlias("external_urls")
    private ExternalUrls externalUrls;

    @JsonAlias("external_ids")
    private ExternalIds externalIds;

    private Album album;

    public Track(String discNumber, String durationMs, String espisode, String explicit, String href, String id, String isLocal, String name, String popularity, String previewUrl, String track, String trackNumber, String type, String uri, List<Artists> artists, List<String> availableMarkets, ExternalUrls externalUrls, ExternalIds externalIds, Album album) {
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
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.externalUrls = externalUrls;
        this.externalIds = externalIds;
        this.album = album;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Track.class.getSimpleName() + "[", "]")
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
                .add("artists=" + artists)
                .add("availableMarkets=" + availableMarkets)
                .add("externalUrls=" + externalUrls)
                .add("externalIds=" + externalIds)
                .add("album=" + album)
                .toString();
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

    public List<Artists> getArtists() {
        return artists;
    }

    public void setArtists(List<Artists> artists) {
        this.artists = artists;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    public ExternalIds getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
