//package com.nosbielc.music.match.config;
//
//import com.nosbielc.music.match.client.IOpenWeatherMapClient;
//import com.nosbielc.music.match.client.ISpotifyOauth;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//
///**
// * @author Cleibson Gomes (https://github.com/Nosbielc) on 28/02/2019
// * @version 1.0
// * @project music-match
// */
//
//@Configuration
//@ComponentScan(basePackages = {"com.nosbielc.music.match.client"}, excludeFilters={
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value= IOpenWeatherMapClient.class),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value= ISpotifyOauth.class)
//})
//public class FeignClientConfiguration {
//
//    @Value("${spotify.clientId}")
//    private String userName;
//
//    @Value("${spotify.clientSecret}")
//    private String password;
//
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor(userName, password);
//    }
//}