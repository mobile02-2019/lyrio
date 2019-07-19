package com.example.lyrio.model;

import de.hdodenhof.circleimageview.CircleImageView;

public class Artista {

    private String artista;
    private CircleImageView imagemArtista;

    public Artista(String artista, CircleImageView imagemArtista) {
        this.artista = artista;
        this.imagemArtista = imagemArtista;
    }

    public Artista() {

    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public CircleImageView getImagemArtista() {
        return imagemArtista;
    }

    public void setImagemArtista(CircleImageView imagemArtista) {
        this.imagemArtista = imagemArtista;
    }
}
