package com.nosbielc.music.match.components;

import org.springframework.stereotype.Component;

@Component
public class NegocioMusicMatch {

    /**
     * Se a temperatura (celcius) estiver acima de 30 graus, sugerir faixas para festa
     * Caso a temperatura esteja entre 15 e 30 graus, sugerir faixas de música pop
     * Se estiver um pouco frio (entre 10 e 14 graus), sugira faixas de música rock
     * Caso contrário, se estiver frio lá fora, sugere faixas de música clássica
     */
    public String aplicaRegraFaixasPorTemperetura(Double temperatura) {

        if (temperatura > 30) {

        }

        return "";
    }

}
