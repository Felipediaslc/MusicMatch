package com.nosbielc.music.match.client;

import com.nosbielc.music.match.dtos.SpotifyCategoriasDto;
import com.nosbielc.music.match.dtos.SpotifyPlayListDto;
import com.nosbielc.music.match.dtos.SpotifyTracksDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Service
@FeignClient(name = "spotify", url = "https://api.spotify.com")
public interface ISpotifyClient {

    @RequestMapping(method = GET, value = "/v1/browse/categories",
            produces = "application/json", consumes = "application/json")
    ResponseEntity<SpotifyCategoriasDto> getCategorias(@RequestHeader(value = "Authorization") String token,
                                                       @RequestParam(value = "offset") String offset,
                                                       @RequestParam(value = "limit") String limit);

    @RequestMapping(method = GET, value = "/v1/browse/categories/{categoria}/playlists?country=BR&limit=50",
            produces = "application/json", consumes = "application/json")
    ResponseEntity<SpotifyPlayListDto> getPlayListByCategoria(@RequestHeader(value = "Authorization") String token,
                                                              @PathVariable("categoria") String categoria);

    @RequestMapping(method = GET, value = "/v1/playlists/{idPlayList}/tracks?limit=100",
            produces = "application/json", consumes = "application/json")
    ResponseEntity<SpotifyTracksDto> getTracksByPlayList(@RequestHeader(value = "Authorization") String token,
                                                        @PathVariable("idPlayList") String idPlayList);

}
