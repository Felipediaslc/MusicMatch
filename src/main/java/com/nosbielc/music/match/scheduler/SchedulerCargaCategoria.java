package com.nosbielc.music.match.scheduler;

import com.nosbielc.music.match.client.ISpotifyClient;
import com.nosbielc.music.match.client.ISpotifyOauth;
import com.nosbielc.music.match.dtos.SpotifyCategoriasDto;
import com.nosbielc.music.match.dtos.SpotifyOauthDto;
import com.nosbielc.music.match.entities.Categoria;
import com.nosbielc.music.match.services.ICategoriaService;
import com.nosbielc.music.match.utils.Constants;
import com.nosbielc.music.match.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerCargaCategoria {

    private static final Logger log = LoggerFactory.getLogger(SchedulerCargaCategoria.class);

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private ISpotifyOauth spotifyOauth;

    @Autowired
    private ISpotifyClient spotifyClient;

    @Value("${spotify.clientId}")
    private String userName;

    @Value("${spotify.clientSecret}")
    private String password;

    @Scheduled(cron = "0 0 23 * * *", zone = Constants.TIME_ZONE)
    public void runSchecullerCargaCategorias() {
        try {

            log.info("Iniciando o runSchecullerCargaCategorias");

            SpotifyOauthDto spotifyOauthDto =
                    this.spotifyOauth.getToken(
                            Utils.geraBaseAtenticacao(
                                    userName, password)).getBody();
            if (spotifyOauthDto != null) {

                String token = String.format("Bearer %s", spotifyOauthDto.getAccess_token());

                log.info(String.format("Token resgatado com sucesso ! -> %s", token));

                SpotifyCategoriasDto spotifyCategoriasDto = this.spotifyClient.getCategorias(
                        token,
                        "0", "50").getBody();

                log.info(String.format("Categiroias Encontradas -> %s",
                        spotifyCategoriasDto.getCategories().getItems().size()));

                spotifyCategoriasDto.getCategories().getItems().stream().forEach(
                        item -> {
                            try {
                                categoriaService.persist(
                                        new Categoria(item.getId(),
                                                item.getName()));
                                log.info(String.format("Sucesso ao incluir ( %s ).", item));
                            } catch (Exception e) {
                                log.error(String.format("Erro ao incluir ( %s ).", item));
                            }
                        }
                );

            }
        } catch (Exception ex) {
            log.error(String.format("Carga não realizada -> %s", ex.getMessage()));
        }

    }

}
