package com.nosbielc.music.match.dtos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.StringJoiner;

public class MusicMatchByCityDto implements Serializable {

    @NotNull(message = "cidade não pode ser null.")
    private String cidade;

    public MusicMatchByCityDto(@NotNull(message = "cidade não pode ser null.") String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MusicMatchByCityDto.class.getSimpleName() + "[", "]")
                .add("cidade='" + cidade + "'")
                .toString();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
