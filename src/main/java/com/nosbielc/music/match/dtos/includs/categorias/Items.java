package com.nosbielc.music.match.dtos.includs.categorias;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;
import java.util.StringJoiner;

public class Items {

    private String href;
    private String id;
    private String name;
    @JsonAlias("icons")
    private List<Icons> icons;

    public Items() {
    }

    public Items(String href, String id, String name, List<Icons> icons) {
        this.href = href;
        this.id = id;
        this.name = name;
        this.icons = icons;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Items.class.getSimpleName() + "[", "]")
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("icons=" + icons)
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
}
