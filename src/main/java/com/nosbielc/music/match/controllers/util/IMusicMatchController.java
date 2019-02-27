package com.nosbielc.music.match.controllers.util;

import com.nosbielc.music.match.dtos.MusicMatchByCityDto;
import com.nosbielc.music.match.dtos.MusicMatchCoordinatesDto;
import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.response.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    ResponseEntity<Response<Page<SolicitacaoDto>>> listar(@RequestParam(value = "pag", defaultValue = "0") Integer pag,
                                                                 @RequestParam(value = "ord", defaultValue = "id") String ord,
                                                                 @RequestParam(value = "dir", defaultValue = "DESC") String dir);

    @GetMapping("/city")
    @ApiOperation(value = "Lista as faixas baseado em configuração de temperatura/categoria musical", nickname = "ListFaixas",
            notes = "Lista as faixas baseado em configuração de temperatura/categoria musical.")
    @ApiParam()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = SolicitacaoDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    ResponseEntity<Response<String>> musicMatchCity(@RequestParam @Valid MusicMatchByCityDto musicMatchByCityDto);

    @GetMapping("/coordinates")
    @ApiOperation(value = "Lista as faixas baseado em configuração de temperatura/categoria musical", nickname = "ListFaixas",
            notes = "Lista as faixas baseado em configuração de temperatura/categoria musical.")
    @ApiParam()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = SolicitacaoDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    ResponseEntity<Response<String>> musicMatchCoordinates(@RequestParam @Valid MusicMatchCoordinatesDto musicMatchCoordinatesDto);


}
