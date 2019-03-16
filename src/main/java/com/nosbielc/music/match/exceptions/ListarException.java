package com.nosbielc.music.match.exceptions;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) on 15/03/2019
 * @version 1.0
 * @project music-match
 */

public class ListarException extends MusicMatchException {

    private static final String str = "Erro Listar Solicitações";

    public ListarException() {
        super(str);
    }
}
