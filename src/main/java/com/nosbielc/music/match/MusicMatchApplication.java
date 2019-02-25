package com.nosbielc.music.match;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MusicMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicMatchApplication.class, args);
    }

}
