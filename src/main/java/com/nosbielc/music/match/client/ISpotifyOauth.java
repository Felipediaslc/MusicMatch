package com.nosbielc.music.match.client;

import com.nosbielc.music.match.dtos.SpotifyCategoriasDto;
import com.nosbielc.music.match.dtos.SpotifyOauthDto;
import com.nosbielc.music.match.dtos.SpotifyPlayListDto;
import com.nosbielc.music.match.dtos.SpotifyTracksDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Service
@FeignClient(name = "oauth", url = "https://accounts.spotify.com")
public interface ISpotifyOauth {

    @RequestMapping(method = POST, value = "/api/token?grant_type=client_credentials",
            produces = "application/json", consumes = "application/x-www-form-urlencoded")
    ResponseEntity<SpotifyOauthDto> getToken(@RequestHeader(value = "Authorization") String token);

}
