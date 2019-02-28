package com.nosbielc.music.match.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.categorias.Categories;

import java.io.Serializable;
import java.util.StringJoiner;

public class SpotifyCategoriasDto implements Serializable {

    @JsonAlias("categories")
    private Categories categories;

    public SpotifyCategoriasDto() {
    }

    public SpotifyCategoriasDto(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SpotifyCategoriasDto.class.getSimpleName() + "[", "]")
                .add("categories=" + categories)
                .toString();
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
