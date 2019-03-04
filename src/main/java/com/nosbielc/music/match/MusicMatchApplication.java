package com.nosbielc.music.match;

import com.nosbielc.music.match.scheduler.SchedulerCargaCategoria;
import com.nosbielc.music.match.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
//@EnableScheduling
public class MusicMatchApplication {

    @Autowired
    SchedulerCargaCategoria schedulerCargaCategoria;

    public static void main(String[] args) {
        SpringApplication.run(MusicMatchApplication.class, args);
    }

    @PostConstruct
    void onStartup() {
        TimeZone.setDefault(TimeZone.getTimeZone(Constants.TIME_ZONE));
        //schedulerCargaCategoria.runSchecullerCargaCategorias();
    }

}
