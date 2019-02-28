package com.nosbielc.music.match.dtos.includs.playlist;

import java.io.Serializable;
import java.util.StringJoiner;

public class Tracks implements Serializable {

    private String href;
    private String total;

    public Tracks(String href, String total) {
        this.href = href;
        this.total = total;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tracks.class.getSimpleName() + "[", "]")
                .add("href='" + href + "'")
                .add("total='" + total + "'")
                .toString();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
