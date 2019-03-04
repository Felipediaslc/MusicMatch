package com.nosbielc.music.match.controllers.util;

import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.dtos.TrackDto;
import com.nosbielc.music.match.response.Response;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IMusicMatchController {

    @GetMapping("/show")
    @ApiOperation(value = "Lista as Solicitações registradas na base", nickname = "ListSolicitacoes",
            notes = "Lista as Solicitações registradas na base.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = SolicitacaoDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    ResponseEntity<Response<Page<SolicitacaoDto>>> listar(
            @RequestParam(value = "pag", defaultValue = "0") Integer pag,
            @RequestParam(value = "ord", defaultValue = "id") String ord,
            @RequestParam(value = "dir", defaultValue = "DESC") String dir);

    @GetMapping("/city")
    @ApiOperation(value = "Lista as faixas baseado em configuração de temperatura/categoria musical",
            nickname = "ListFaixas",
            notes = "Lista as faixas baseado em configuração de temperatura/categoria musical.")
    @ApiParam()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = TrackDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cidade", value = "Cidade a ser pesquisada como base", required = true,
                    dataType = "string", paramType = "query")})
    ResponseEntity<Response<List<TrackDto>>> musicMatchCity(
            @ApiParam(value = "Cidade a ser pesquisada como base", required = true)
            @RequestParam(value = "cidade") String cidade);

    @GetMapping("/coordinates")
    @ApiOperation(value = "Lista as faixas baseado em configuração de temperatura/categoria musical",
            nickname = "ListFaixas",
            notes = "Lista as faixas baseado em configuração de temperatura/categoria musical.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = TrackDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lat", value = "Latitude do local.", required = true,
                    dataType = "double", paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "Longitude do local.", required = true,
                    dataType = "double", paramType = "query")})
    ResponseEntity<Response<List<TrackDto>>> musicMatchCoordinates(
            @ApiParam(value = "Latitude do local.", required = true) @RequestParam(value = "lat") Double lat,
            @ApiParam(value = "Longitude do local.", required = true) @RequestParam(value = "lon") Double lon);


}
