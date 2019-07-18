package com.example.lyrio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lyrio.Api.BaseVagalume.ApiResponse;
import com.example.lyrio.Api.BaseVagalume.VagalumeBusca;
import com.example.lyrio.Api.VagalumeBuscaApi;
import com.example.lyrio.Api.BaseVagalume.ApiArtista;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ApiBuscaListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuscar extends Fragment implements ApiBuscaListener {

    private static final String TAG = "VAGALUME";
    private Retrofit retrofit;
    private EditText userInputBusca;
    private TextView retornoBusca;
    private Button botaoBuscar;

    public FragmentBuscar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_buscar, container, false);

        // Iniciar retrofit para buscar infos da API
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vagalume.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userInputBusca = view.findViewById(R.id.buscar_campo_de_busca);
        retornoBusca = view.findViewById(R.id.buscar_temp_textview);
        botaoBuscar = view.findViewById(R.id.buscar_botao_busca);

        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fazerBusca(userInputBusca.getText().toString(), "ambos", 5);
            }
        });

        return view;
    }

    private void fazerBusca(String termoBuscado, String artistaOuMusica, Integer qtdResultados) {

        termoBuscado = termoBuscado.trim().replace(" ", "%20");
        String vagaKey =  "52433bd778677b92342a16ddf927e4bf";
        String limitador = "&limit="+qtdResultados.toString();

        String buscaBase = "";
        switch (artistaOuMusica){
            case "artista":
                buscaBase = "search.art?apikey=" + vagaKey + "&q=";
                break;
            case "musica":
                buscaBase = "search.excerpt?apikey=" + vagaKey + "&q=";
                break;
            default:
                buscaBase = "search.artmus?apikey=" + vagaKey + "&q=";
        }

        String buscaFull = buscaBase+termoBuscado+limitador;

        VagalumeBuscaApi service = retrofit.create(VagalumeBuscaApi.class);
        Call<VagalumeBusca> vagalumeBuscaCall = service.getBuscaResponse(buscaFull);
        vagalumeBuscaCall.enqueue(new Callback<VagalumeBusca>() {
            @Override
            public void onResponse(Call<VagalumeBusca> call, Response<VagalumeBusca> response) {
                if(response.isSuccessful()){
                    VagalumeBusca vagalumeBusca = response.body();
                    ApiResponse buscaResponse = vagalumeBusca.getResponse();
                    int qtdResult = buscaResponse.getDocs().size();
                    String gotResult = "";

                    if(qtdResult>0){
                        for(int i=0; i<qtdResult; i++){

                            String bandName = buscaResponse.getDocs().get(i).getBand();
                            String songTitle = buscaResponse.getDocs().get(i).getTitle();

                            if(bandName != null && songTitle != null){
                                gotResult = gotResult+"MÚSICA - "+bandName+" - "+songTitle+"\n";
                            } else if(bandName != null && songTitle == null){
                                gotResult = gotResult+"ARTISTA - "+bandName+"\n";
                            }
                        }
                    }

                    if(gotResult.equals("")){
                        retornoBusca.setText("Não encontramos...");
                    }else{
                        retornoBusca.setText(gotResult);
                    }

//                    Log.i(TAG, " Título: " +buscaResponse.getDocs().get(0).getTitle());

                }else {Log.e(TAG, " onResponse: "+response.errorBody());}
            }

            @Override
            public void onFailure(Call<VagalumeBusca> call, Throwable t){Log.e(TAG, " onFailure: "+t.getMessage());}
        });
    }




    @Override
    public void onApiBuscarClicado(ApiArtista apiArtista) {

    }
}
