package com.nosbielc.music.match.client;

import com.nosbielc.music.match.dtos.OpenWeatherDto;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("http://api.openweathermap.org/data/2.5/weather")
public interface OpenWeatherMapClient {

    @GetMapping("")
    Object getByCityName(@Param(value = "q") String q, @Param(value = "appid") String appid);

//    @GetMapping
//    OpenWeatherDto getByGeographicCoordinates(@PathParam(value = "lat") String lat,
//                                              @PathParam(value = "lon") String lon,
//                                              @PathParam(value = "appid") String appid);

}
