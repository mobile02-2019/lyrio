package com.example.lyrio.Api.BaseVagalume;

public class VagalumeBusca {

    private ApiResponse response;
    private ApiArtista artist;

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
