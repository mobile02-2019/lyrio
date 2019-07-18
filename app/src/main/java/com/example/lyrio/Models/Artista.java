package com.example.lyrio.Models;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Artista {

    private String artista;
    private CircleImageView imagemArtista;
    private List<Musica> listaDeMusicas;
    private List<Album> listaDeAlbuns;

    public List<Musica> getListaDeMusicas() {
        return listaDeMusicas;
    }

    public void setListaDeMusicas(List<Musica> listaDeMusicas) {
        this.listaDeMusicas = listaDeMusicas;
    }

    public List<Album> getListaDeAlbuns() {
        return listaDeAlbuns;
    }

    public void setListaDeAlbuns(List<Album> listaDeAlbuns) {
        this.listaDeAlbuns = listaDeAlbuns;
    }



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
