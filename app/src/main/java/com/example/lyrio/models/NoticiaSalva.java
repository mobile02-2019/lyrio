package com.example.lyrio.models;

import java.io.Serializable;

public class NoticiaSalva implements Serializable {
    private String tituloNoticiaSalva;
    private String imagemNoticiaSalva;

    public String getTituloNoticiaSalva() {
        return tituloNoticiaSalva;
    }

    public void setTituloNoticiaSalva(String tituloNoticiaSalva) {
        this.tituloNoticiaSalva = tituloNoticiaSalva;
    }

    public String getImagemNoticiaSalva() {
        return imagemNoticiaSalva;
    }

    public void setImagemNoticiaSalva(String imagemNoticiaSalva) {
        this.imagemNoticiaSalva = imagemNoticiaSalva;
    }
}
