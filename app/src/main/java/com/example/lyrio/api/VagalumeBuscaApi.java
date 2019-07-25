package com.example.lyrio.api;

import com.example.lyrio.api.base_vagalume.VagalumeBusca;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface VagalumeBuscaApi {

    @GET
    Call<VagalumeBusca> getBuscaResponse(@Url String url);


}
