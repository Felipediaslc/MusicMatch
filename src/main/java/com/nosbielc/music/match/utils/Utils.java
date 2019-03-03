package com.nosbielc.music.match.utils;

import static feign.Util.ISO_8859_1;

public abstract class Utils {

    public static String geraBaseAtenticacao(String userName, String password) {
        return "Basic " + base64Encode((userName + ":" + password).getBytes(ISO_8859_1));
    }

    protected static  String base64Encode(byte[] bytes) {
        return Base64.encode(bytes);
    }

}
