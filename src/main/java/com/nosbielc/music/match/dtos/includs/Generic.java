package com.nosbielc.music.match.dtos.includs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.categorias.Items;

import java.util.List;
import java.util.StringJoiner;

public class Generic {

    private String href;
    private String limit;
    private String next;
    private String offset;
    private String previous;
    private String total;
    @JsonAlias("items")
    private List<Items> items;

    public Generic(String href, String limit, String next, String offset, String previous, String total,
                   List<Items> items) {
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
        this.items = items;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Generic.class.getSimpleName() + "[", "]")
                .add("href='" + href + "'")
                .add("limit='" + limit + "'")
                .add("next='" + next + "'")
                .add("offset='" + offset + "'")
                .add("previous='" + previous + "'")
                .add("total='" + total + "'")
                .add("items=" + items)
                .toString();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
