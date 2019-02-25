package com.nosbielc.music.match.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nosbielc.music.match.dtos.includs.Coord;
import com.nosbielc.music.match.dtos.includs.Principal;

public class OpenWeatherDto {

    @JsonAlias("main")
    private Principal principal;
    private Coord coord;
    private String base;
    private String dt;
    private String id;
    private String name;
    private String cod;

    public OpenWeatherDto() {
    }

    public OpenWeatherDto(Principal principal, Coord coord, String base, String dt, String id, String name, String cod) {
        this.principal = principal;
        this.coord = coord;
        this.base = base;
        this.dt = dt;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
