package com.example.lyrio.api;

import com.example.lyrio.api.BaseVagalume.VagalumeHotspot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VagalumeHotspotApi {

    @GET("hotspots.php")
    Call<VagalumeHotspot> getListaHotspot(@Query("apiKey") String apiKey);

}
