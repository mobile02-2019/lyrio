package com.example.lyrio.models;


import com.example.lyrio.api.base_vagalume.ApiArtista;

import java.io.Serializable;

public class Musica  implements Serializable {

    private String name;
    private String id;
    private String desc;
    private String url;
    private String albumPic;
    private int lang;
    private String text;
    private String trans;
    private ApiArtista artista;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public ApiArtista getArtista() {
        return artista;
    }

    public void setArtista(ApiArtista artista) {
        this.artista = artista;
    }

    public Musica(){

    }

    public Musica(String id, String desc, String url) {
        this.id = id;
        this.desc = desc;
        this.url = url;
    }

    public String getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(String albumPic) {
        this.albumPic = albumPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
