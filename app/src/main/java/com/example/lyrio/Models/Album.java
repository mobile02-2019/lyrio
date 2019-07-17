package com.example.lyrio.Models;

import android.widget.ImageView;

import java.util.List;

public class Album {


    private ImageView capaAlbum;
    private List<Musica> listaDeMusicaAlbum;

    public List<Musica> getListaDeMusicaAlbum() {
        return listaDeMusicaAlbum;
    }

    public void setListaDeMusicaAlbum(List<Musica> listaDeMusicaAlbum) {
        this.listaDeMusicaAlbum = listaDeMusicaAlbum;
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
