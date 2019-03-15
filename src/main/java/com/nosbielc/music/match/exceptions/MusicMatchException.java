package com.nosbielc.music.match.exceptions;

import java.util.StringJoiner;

public class MusicMatchException extends Exception {

    private String str;

    public MusicMatchException(Throwable cause, String str) {
        super(str, cause);
        this.str = str;
    }

    public MusicMatchException(String str) {
        super(str);
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MusicMatchException.class.getSimpleName() + "[", "]")
                .add("str='" + str + "'")
                .toString();
    }
}
