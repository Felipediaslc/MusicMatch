package com.nosbielc.music.match.controllers;

import com.nosbielc.music.match.components.NegocioMusicMatch;
import com.nosbielc.music.match.controllers.util.IMusicMatchController;
import com.nosbielc.music.match.controllers.util.MusicMatchControllerUtil;
import com.nosbielc.music.match.dtos.SolicitacaoDto;
import com.nosbielc.music.match.dtos.TrackDto;
import com.nosbielc.music.match.exceptions.ListarException;
import com.nosbielc.music.match.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/match")
@CrossOrigin(origins = "*")
public class MusicMatchController extends MusicMatchControllerUtil implements IMusicMatchController {

    private static final Logger log = LoggerFactory.getLogger(MusicMatchController.class);

    @Autowired
    private NegocioMusicMatch negocioMusicMatch;

    @Override
    public ResponseEntity<Response<Page<SolicitacaoDto>>> listar(
            @RequestParam(value = "pag", defaultValue = "0") Integer pag,
            @RequestParam(value = "ord", defaultValue = "id") String ord,
            @RequestParam(value = "dir", defaultValue = "ASC") String dir) throws ListarException {
        return ResponseEntity.ok(this.negocioMusicMatch.listarSolicitacoes(pag, ord, dir));
    }

    @Override
    public ResponseEntity<Response<List<TrackDto>>> musicMatchCity(
            @RequestParam(value = "cidade") String cidade) {
        return ResponseEntity.ok(this.negocioMusicMatch.executaMusicMatch(cidade, 0.00, 0.00));
    }

    @Override
    public ResponseEntity<Response<List<TrackDto>>> musicMatchCoordinates(@RequestParam(value = "lat") Double lat,
                                                                          @RequestParam(value = "lon") Double lon) {
        return ResponseEntity.ok(this.negocioMusicMatch.executaMusicMatch("", lat, lon));
    }

    @GetMapping("/123456")
    public ResponseEntity<Object> teste() throws ListarException {
        throw new ListarException();
    }

}
