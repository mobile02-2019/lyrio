package com.example.lyrio.api.BaseVagalume;

import com.example.lyrio.models.Musica;

import java.util.List;

public class VagalumeBusca {

    private ApiResponse response;
    private ApiArtista artist;
    private ApiArtista art;
    private List<ApiItem> mus;

    public ApiArtista getArt() {
        return art;
    }

    public void setArt(ApiArtista art) {
        this.art = art;
    }

    public List<ApiItem> getMus() {
        return mus;
    }

    public void setMus(List<ApiItem> mus) {
        this.mus = mus;
    }

    public ApiArtista getArtist() {
        return artist;
    }

    public void setArtist(ApiArtista artist) {
        this.artist = artist;
    }

    public ApiResponse getResponse() {
        return response;
    }

    public void setResponse(ApiResponse response) {
        this.response = response;
    }
}
