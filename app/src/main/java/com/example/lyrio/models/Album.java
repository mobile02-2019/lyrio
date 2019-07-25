package com.example.lyrio.models;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {


    private ImageView capaAlbum;
    private String nomeAlbum;
    private List<Musica> listaDeMusicaAlbum;

    public List<Musica> getListaDeMusicaAlbum() {
        return listaDeMusicaAlbum;
    }

    public void setListaDeMusicaAlbum(List<Musica> listaDeMusicaAlbum) {
        this.listaDeMusicaAlbum = listaDeMusicaAlbum;
    }


    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public Album(int capaAlbum) {

    }

    public ImageView getCapaAlbum() {
        return capaAlbum;
    }

    public void setCapaAlbum(ImageView capaAlbum) {
        this.capaAlbum = capaAlbum;
    }
}
