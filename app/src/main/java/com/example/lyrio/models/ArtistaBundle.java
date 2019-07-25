package com.example.lyrio.models;

import com.example.lyrio.api.base_vagalume.ApiArtista;

import java.io.Serializable;
import java.util.ArrayList;

public class ArtistaBundle implements Serializable {

    private ArrayList<ApiArtista> listaDeApiArtista;

    public ArrayList<ApiArtista> getListaDeApiArtista() {
        return listaDeApiArtista;
    }

    public void setListaDeApiArtista(ArrayList<ApiArtista> listaDeApiArtista) {
        this.listaDeApiArtista = listaDeApiArtista;
    }
}
