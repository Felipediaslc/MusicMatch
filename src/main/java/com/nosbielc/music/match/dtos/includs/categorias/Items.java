package com.nosbielc.music.match.dtos.includs.categorias;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.playlist.ExternalUrls;
import com.nosbielc.music.match.dtos.includs.playlist.Images;
import com.nosbielc.music.match.dtos.includs.playlist.Owner;
import com.nosbielc.music.match.dtos.includs.playlist.Tracks;
import com.nosbielc.music.match.dtos.includs.tracks.AddedBy;
import com.nosbielc.music.match.dtos.includs.tracks.Track;
import com.nosbielc.music.match.dtos.includs.tracks.VideoThumbnail;

import java.util.List;
import java.util.StringJoiner;

public class Items {

    /**
     * campos usados para categorias
     */
    private String href;
    private String id;
    private String name;
    @JsonAlias("icons")
    private List<Icons> icons;

    /**
     *  campos usados para PlayList
     */
    private Boolean collaborative;
    @JsonAlias("primary_color")
    private String primaryColor;
    @JsonAlias("public")
    private String publico;
    @JsonAlias("snapshot_id")
    private String snapshoId;
    private String type;
    private String uri;

    @JsonAlias("external_urls")
    private ExternalUrls externalUrls;

    @JsonAlias("images")
    private List<Images> images;

    private Owner owner;

    private Tracks tracks;

    /**
     * camps usados para os tracks
     */
    @JsonAlias("is_local")
    private Boolean isLocal;

    @JsonAlias("added_by")
    private AddedBy addedBy;

    @JsonAlias("video_thumbnail")
    private VideoThumbnail videoThumbnail;

    @JsonAlias("track")
    private Track track;

    public Items(String href, String id, String name, List<Icons> icons, Boolean collaborative, String primaryColor, String publico, String snapshoId, String type, String uri, ExternalUrls externalUrls, List<Images> images, Owner owner, Tracks tracks, Boolean isLocal, AddedBy addedBy, VideoThumbnail videoThumbnail, Track track) {
        this.href = href;
        this.id = id;
        this.name = name;
        this.icons = icons;
        this.collaborative = collaborative;
        this.primaryColor = primaryColor;
        this.publico = publico;
        this.snapshoId = snapshoId;
        this.type = type;
        this.uri = uri;
        this.externalUrls = externalUrls;
        this.images = images;
        this.owner = owner;
        this.tracks = tracks;
        this.isLocal = isLocal;
        this.addedBy = addedBy;
        this.videoThumbnail = videoThumbnail;
        this.track = track;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Items.class.getSimpleName() + "[", "]")
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("icons=" + icons)
                .add("collaborative=" + collaborative)
                .add("primaryColor='" + primaryColor + "'")
                .add("publico='" + publico + "'")
                .add("snapshoId='" + snapshoId + "'")
                .add("type='" + type + "'")
                .add("uri='" + uri + "'")
                .add("externalUrls=" + externalUrls)
                .add("images=" + images)
                .add("owner=" + owner)
                .add("tracks=" + tracks)
                .add("isLocal=" + isLocal)
                .add("addedBy=" + addedBy)
                .add("videoThumbnail=" + videoThumbnail)
                .add("track=" + track)
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

    public List<Icons> getIcons() {
        return icons;
    }

    public void setIcons(List<Icons> icons) {
        this.icons = icons;
    }

    public Boolean getCollaborative() {
        return collaborative;
    }

    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    public String getSnapshoId() {
        return snapshoId;
    }

    public void setSnapshoId(String snapshoId) {
        this.snapshoId = snapshoId;
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

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
    }

    public AddedBy getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(AddedBy addedBy) {
        this.addedBy = addedBy;
    }

    public VideoThumbnail getVideoThumbnail() {
        return videoThumbnail;
    }

    public void setVideoThumbnail(VideoThumbnail videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
