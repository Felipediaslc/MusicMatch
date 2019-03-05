package com.nosbielc.music.match.dtos.includs.tracks;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.playlist.ExternalUrls;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class Album implements Serializable {

    @JsonAlias("album_type")
    private String albumType;

    @JsonAlias("artists")
    private List<Artists> artists;

    @JsonAlias("available_markets")
    private List<String> availableMarkets;

    @JsonAlias("external_urls")
    private ExternalUrls externalUrls;

    private String href;
    private String id;
    private String name;
    @JsonAlias("release_date")
    private String releaseDate;
    @JsonAlias("release_date_precision")
    private String releaseDatePrecision;
    @JsonAlias("total_tracks")
    private String totalTracks;
    private String type;
    private String uri;

    public Album() {
    }

    public Album(String albumType, List<Artists> artists, List<String> availableMarkets, ExternalUrls externalUrls, String href, String id, String name, String releaseDate, String releaseDatePrecision, String totalTracks, String type, String uri) {
        this.albumType = albumType;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.totalTracks = totalTracks;
        this.type = type;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Album.class.getSimpleName() + "[", "]")
                .add("albumType='" + albumType + "'")
                .add("artists=" + artists)
                .add("availableMarkets=" + availableMarkets)
                .add("externalUrls=" + externalUrls)
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("releaseDate='" + releaseDate + "'")
                .add("releaseDatePrecision='" + releaseDatePrecision + "'")
                .add("totalTracks='" + totalTracks + "'")
                .add("type='" + type + "'")
                .add("uri='" + uri + "'")
                .toString();
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public void setReleaseDatePrecision(String releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
    }

    public String getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(String totalTracks) {
        this.totalTracks = totalTracks;
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
