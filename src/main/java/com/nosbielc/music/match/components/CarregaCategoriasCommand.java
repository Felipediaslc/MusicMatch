package com.nosbielc.music.match.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) on 16/03/2019
 * @version 1.0
 * @project music-match
 */
@Component
@Order(1)
public class CarregaCategoriasCommand implements CommandLineRunner {


    private static final Logger log = LoggerFactory.getLogger(CarregaCategoriasCommand.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("Iniciando CommandLineRunner");
    }
}
