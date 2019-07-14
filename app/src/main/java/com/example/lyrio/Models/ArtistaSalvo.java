package com.example.lyrio.Models;

import java.io.Serializable;

public class ArtistaSalvo implements Serializable {
    private String nomeArtistaSalvo;
    private String imagemArtistaSalvo;

    public String getNomeArtistaSalvo() {
        return nomeArtistaSalvo;
    }

    public void setNomeArtistaSalvo(String nomeArtistaSalvo) {
        this.nomeArtistaSalvo = nomeArtistaSalvo;
    }

    public String getImagemArtistaSalvo() {
        return imagemArtistaSalvo;
    }

    public void setImagemArtistaSalvo(String imagemArtistaSalvo) {
        this.imagemArtistaSalvo = imagemArtistaSalvo;
    }
}
