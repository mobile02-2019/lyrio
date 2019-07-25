package com.example.lyrio.api.BaseVagalume;

import com.example.lyrio.models.Musica;

import java.io.Serializable;
import java.util.List;

public class ApiArtista implements Serializable{

    private String name;
    private String id;
    private String desc;
    private String url;
    private String pic_small;
    private String pic_medium;
    private int qtdMusicas;
    private ApiItem toplyrics;
    private ApiItem lyrics;
    private List<Musica> musicasSalvas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Musica> getMusicasSalvas() {
        return musicasSalvas;
    }

    public void setMusicasSalvas(List<Musica> musicasSalvas) {
        this.musicasSalvas = musicasSalvas;
    }

    public ApiItem getToplyrics() {
        return toplyrics;
    }

    public void setToplyrics(ApiItem toplyrics) {
        this.toplyrics = toplyrics;
    }

    public int getQtdMusicas() {
        return qtdMusicas;
    }

    public void setQtdMusicas(int qtdMusicas) {
        this.qtdMusicas = qtdMusicas;
    }

    public ApiItem getLyrics() {
        return lyrics;
    }

    public void setLyrics(ApiItem lyrics) {
        this.lyrics = lyrics;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic_small() {
        return pic_small;
    }

    public void setPic_small(String pic_small) {
        this.pic_small = pic_small;
    }

    public String getPic_medium() {
        return pic_medium;
    }

    public void setPic_medium(String pic_medium) {
        this.pic_medium = pic_medium;
    }
}
