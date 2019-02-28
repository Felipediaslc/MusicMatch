package com.nosbielc.music.match.dtos.includs.playlist;

import com.nosbielc.music.match.dtos.includs.Generic;
import com.nosbielc.music.match.dtos.includs.categorias.Items;

import java.io.Serializable;
import java.util.List;

public class PlayList extends Generic implements Serializable {

    public PlayList(String href, String limit, String next, String offset, String previous, String total, List<Items> items) {
        super(href, limit, next, offset, previous, total, items);
    }
}
