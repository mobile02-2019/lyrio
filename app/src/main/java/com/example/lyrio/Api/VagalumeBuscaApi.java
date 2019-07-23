package com.example.lyrio.Api;

import com.example.lyrio.Api.BaseVagalume.VagalumeBusca;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface VagalumeBuscaApi {

    @GET
    Call<VagalumeBusca> getBuscaResponse(@Url String url);


}
