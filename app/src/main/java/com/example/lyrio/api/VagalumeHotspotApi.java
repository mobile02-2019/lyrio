package com.example.lyrio.api;

import com.example.lyrio.api.BaseVagalume.VagalumeHotspot;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VagalumeHotspotApi {

    String vagaKey =  "52433bd778677b92342a16ddf927e4bf";

    @GET("hotspots.php?apikey="+vagaKey)
    Call<VagalumeHotspot> getListaHotspot();

}
