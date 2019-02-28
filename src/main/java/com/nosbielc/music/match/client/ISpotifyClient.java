package com.nosbielc.music.match.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Service
@FeignClient(name = "spotify", url = "https://api.spotify.com")
public interface ISpotifyClient {

    @RequestMapping(method = GET, value = "/v1/browse/categories",
            produces = "application/json", consumes = "application/json")
    ResponseEntity<String> getCategorias(@RequestHeader(value = "Authorization") String token,
                                               @RequestParam(value = "offset") String offset,
                                               @RequestParam(value = "limit") String limit);

    @RequestMapping(method = GET, value = "/v1/browse/categories/{categoria}/playlists",
            produces = "application/json", consumes = "application/json")
    ResponseEntity<String> getPlayListByCategoria(@RequestHeader(value = "Authorization") String token,
                                               @PathParam(value = "categoria") String categoria,
                                               @RequestParam(value = "country") String country,
                                               @RequestParam(value = "limit") String limit);

    @RequestMapping(method = GET, value = "/v1/playlists/{idPlayList}/tracks",
            produces = "application/json", consumes = "application/json")
    ResponseEntity<String> getTrackByPlayList(@RequestHeader(value = "Authorization") String token,
                                                  @PathParam(value = "idPlayList") String idPlayList,
                                                  @RequestParam(value = "country") String country,
                                                  @RequestParam(value = "limit") String limit);

}
