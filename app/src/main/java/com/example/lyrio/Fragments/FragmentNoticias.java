package com.example.lyrio.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrio.Adapters.HotspotAdapter;
import com.example.lyrio.Api.VagalumeHotspotApi;
import com.example.lyrio.HotspotAbrirLink;
import com.example.lyrio.Models.Hotspot;
import com.example.lyrio.Api.BaseVagalume.VagalumeHotspot;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.HotspotListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNoticias extends Fragment implements HotspotListener {

    private static final String TAG = "VAGALUME";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private HotspotAdapter hotspotAdapter;

    public FragmentNoticias() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_noticias, container, false);

        // Iniciar retrofit para buscar infos da API
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vagalume.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Configurar retrofit
        recyclerView = view.findViewById(R.id.recycler_view_id);
        hotspotAdapter = new HotspotAdapter(this.getActivity(), this); // "this" adicionado por causa do Glide
        recyclerView.setAdapter(hotspotAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Executar retrofit para buscar dados da API
        getRetrofitData();

        return view;
    }

    private void  getRetrofitData(){
        VagalumeHotspotApi service = retrofit.create(VagalumeHotspotApi.class);
        Call<VagalumeHotspot> vagalumeHotspotCall = service.getListaHotspot();
        vagalumeHotspotCall.enqueue(new Callback<VagalumeHotspot>() {
            @Override
            public void onResponse(Call<VagalumeHotspot> call, Response<VagalumeHotspot> response) {
                if(response.isSuccessful()){
                    VagalumeHotspot vagalumeHotspot = response.body();
                    ArrayList<Hotspot> listaHotspot = vagalumeHotspot.getHotspots();
                    hotspotAdapter.adicionarListaHotspot(listaHotspot);

                    // Logar no console cada info recebida pela API
                    for(int i=0; i<listaHotspot.size(); i++){
                        Hotspot h = listaHotspot.get(i);
                        Log.i(TAG, " Hotspot: " +h.getTitle());
                    }

                }else {Log.e(TAG, " onResponse: "+response.errorBody());}
            }

            @Override
            public void onFailure(Call<VagalumeHotspot> call, Throwable t){Log.e(TAG, " onFailure: "+t.getMessage());}
        });
    }

    @Override
    public void onHotspotClicado(Hotspot hotspot) {
        String url = hotspot.getLink();

        Intent intent = new Intent(getActivity(), HotspotAbrirLink.class);
        Bundle bundle = new Bundle();

        // Para poder adicionar um Pais ao bundle, a classe tem que implementar "Serializable"
        bundle.putString("HOTSPOT_LINK", hotspot.getLink());
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
