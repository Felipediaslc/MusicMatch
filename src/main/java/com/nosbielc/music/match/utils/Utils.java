package com.nosbielc.music.match.utils;

import com.nosbielc.music.match.dtos.SpotifyOauthDto;

import static feign.Util.ISO_8859_1;

public abstract class Utils {

    public static String geraBaseAtenticacao(String userName, String password) {
        return "Basic " + base64Encode((userName + ":" + password).getBytes(ISO_8859_1));
    }

    protected static  String base64Encode(byte[] bytes) {
        return Base64.encode(bytes);
    }

    public static Double convertKelvinToCelsius(Double tempKelvin) {
        return tempKelvin - 273.0;
    }

    public static String geraBearerAtenticacao(SpotifyOauthDto spotifyOauthDto) {
        return String.format("Bearer %s", spotifyOauthDto.getAccess_token());
    }

}
