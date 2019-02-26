package com.nosbielc.music.match.client;

import com.nosbielc.music.match.dtos.OpenWeatherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Service
@FeignClient(name = "openweathermap", url = "http://api.openweathermap.org")
public interface OpenWeatherMapClient {

    @RequestMapping(method = GET, value = "/data/2.5/weather")
    ResponseEntity<OpenWeatherDto> getByCityName(@RequestParam(value = "q") String q, @RequestParam(value = "appid") String appid);

    @RequestMapping(method = GET, value = "/data/2.5/weather")
    ResponseEntity<OpenWeatherDto> getByGeographicCoordinates(@RequestParam(value = "lat") Double lat,
                                              @RequestParam(value = "lon") Double lon,
                                              @RequestParam(value = "appid") String appid);

}
