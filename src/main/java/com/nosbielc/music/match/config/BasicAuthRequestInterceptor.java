//package com.nosbielc.music.match.config;
//
///**
// * @author Cleibson Gomes (https://github.com/Nosbielc) on 28/02/2019
// * @version 1.0
// * @project music-match
// */
//
//import java.nio.charset.Charset;
//
//import com.nosbielc.music.match.utils.Base64;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//
//import static feign.Util.ISO_8859_1;
//import static feign.Util.checkNotNull;
//
//
//public class BasicAuthRequestInterceptor implements RequestInterceptor {
//
//    private final String headerValue;
////    private final SpotifyOauthDto processValue;
//
////    @Autowired
////    private ISpotifyOauth spotifyOauth;
//
//    public BasicAuthRequestInterceptor(String username, String password) {
//        this(username, password, ISO_8859_1);
//    }
//
//    public BasicAuthRequestInterceptor(String username, String password, Charset charset) {
//        checkNotNull(username, "username");
//        checkNotNull(password, "password");
//
////        this.processValue = spotifyOauth.getToken("Basic " + base64Encode((username + ":" + password).getBytes(charset))).getBody();
//        this.headerValue = "Basic " + base64Encode((username + ":" + password).getBytes(charset));
////        this.headerValue = "Bearer " + processValue.getAccess_token();
//    }
//
//    private static String base64Encode(byte[] bytes) {
//        return Base64.encode(bytes);
//    }
//
//    @Override
//    public void apply(RequestTemplate template) {
//        template.header("Authorization", headerValue);
//    }
//}
