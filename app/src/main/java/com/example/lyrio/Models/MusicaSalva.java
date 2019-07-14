package com.example.lyrio.Models;

import java.io.Serializable;

public class MusicaSalva implements Serializable {
    private String nomeMusicaSalva;
    private String imagemMusicaSalva;

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
