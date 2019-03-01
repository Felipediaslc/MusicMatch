package com.nosbielc.music.match.dtos;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) on 28/02/2019
 * @version 1.0
 * @project music-match
 */

public class SpotifyOauthDto implements Serializable {

    private String access_token;
    private String token_type;
    private String expires_in;
    private String scope;

    public SpotifyOauthDto(String access_token, String token_type, String expires_in, String scope) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SpotifyOauthDto.class.getSimpleName() + "[", "]")
                .add("access_token='" + access_token + "'")
                .add("token_type='" + token_type + "'")
                .add("expires_in='" + expires_in + "'")
                .add("scope='" + scope + "'")
                .toString();
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
