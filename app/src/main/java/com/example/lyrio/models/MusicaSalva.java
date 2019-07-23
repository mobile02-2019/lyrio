package com.example.lyrio.models;

import java.io.Serializable;

public class MusicaSalva implements Serializable {
    private String nomeMusicaSalva;
    private String imagemMusicaSalva;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNomeMusicaSalva() {
        return nomeMusicaSalva;
    }

    public void setNomeMusicaSalva(String nomeMusicaSalva) {
        this.nomeMusicaSalva = nomeMusicaSalva;
    }

    public String getImagemMusicaSalva() {
        return imagemMusicaSalva;
    }

    public void setImagemMusicaSalva(String imagemMusicaSalva) {
        this.imagemMusicaSalva = imagemMusicaSalva;
    }
}
