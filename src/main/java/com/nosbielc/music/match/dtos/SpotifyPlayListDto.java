package com.nosbielc.music.match.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.playlist.PlayList;

import java.io.Serializable;
import java.util.StringJoiner;

public class SpotifyPlayListDto implements Serializable {

    @JsonAlias("playlists")
    private PlayList playLists;

    public SpotifyPlayListDto(PlayList playLists) {
        this.playLists = playLists;
    }

    public PlayList getPlayLists() {
        return playLists;
    }

    public void setPlayLists(PlayList playLists) {
        this.playLists = playLists;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SpotifyPlayListDto.class.getSimpleName() + "[", "]")
                .add("playLists=" + playLists)
                .toString();
    }
}
