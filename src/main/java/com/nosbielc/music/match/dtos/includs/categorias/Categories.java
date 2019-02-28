package com.nosbielc.music.match.dtos.includs.categorias;

import com.nosbielc.music.match.dtos.includs.Generic;

import java.io.Serializable;
import java.util.List;

public class Categories extends Generic implements Serializable {

    public Categories(String href, String limit, String next, String offset, String previous, String total, List<Items> items) {
        super(href, limit, next, offset, previous, total, items);
    }
}
