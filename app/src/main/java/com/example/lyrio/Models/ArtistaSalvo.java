package com.example.lyrio.Models;

import java.io.Serializable;
import java.util.List;

public class ArtistaSalvo implements Serializable {
    private String nomeArtistaSalvo;
    private int qtdMusicas;
    private String imagemArtistaSalvo;
    private List<Musica> listaDeMusicas;
    private List<Album> listaDeAlbuns;

    public int getQtdMusicas() {
        return qtdMusicas;
    }

    public void setQtdMusicas(int qtdMusicas) {
        this.qtdMusicas = qtdMusicas;
    }

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
