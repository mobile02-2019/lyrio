package com.example.lyrio.fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lyrio.adapters.BuscaAdapter;
import com.example.lyrio.api.base_vagalume.ApiItem;
import com.example.lyrio.api.base_vagalume.ApiResponse;
import com.example.lyrio.api.base_vagalume.VagalumeBusca;
import com.example.lyrio.api.VagalumeBuscaApi;
import com.example.lyrio.VagalumeAbrirLink;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ApiBuscaListener;
import com.example.lyrio.util.Constantes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuscar extends Fragment implements ApiBuscaListener{

    private static final String TAG = "VAGALUME";
//    private ArrayList<ApiItem> listaTemApi = new ArrayList<>();
    private Retrofit retrofit;
    private EditText userInputBusca;
    private TextView retornoBusca;
    private Button botaoBuscar;
    private RecyclerView recyclerView;
    private BuscaAdapter buscaAdapter;

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
//        retornoBusca = view.findViewById(R.id.buscar_temp_textview);
        botaoBuscar = view.findViewById(R.id.buscar_botao_busca);

        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaAdapter.removerTudo();
                fazerBusca(userInputBusca.getText().toString(), "ambos", 5);
            }
        });

        recyclerView = view.findViewById(R.id.buscar_recycler);
        buscaAdapter = new BuscaAdapter(this.getActivity(), this); // "this" adicionado por causa do Glide
        recyclerView.setAdapter(buscaAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    private void fazerBusca(String termoBuscado, String artistaOuMusica, Integer qtdResultados) {

        termoBuscado = termoBuscado.trim().replace(" ", "%20");
        String vagaKey =  Constantes.VAGALUME_KEY;
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

                    ArrayList<ApiItem> listaDeArtistas = new ArrayList<>();
                    ArrayList<ApiItem> listaDeMusicas = new ArrayList<>();

                    if(qtdResult>0){
                        for(int i=0; i<qtdResult; i++){

                            String bandName = buscaResponse.getDocs().get(i).getBand();
                            String songTitle = buscaResponse.getDocs().get(i).getTitle();
                            String pgUrl = buscaResponse.getDocs().get(i).getUrl();
                            ApiItem curApiItem = new ApiItem();

                            if(bandName != null && songTitle != null){

                                // Logar em txt
                                gotResult = gotResult+"MÚSICA - "+bandName+" - "+songTitle+"\n";

                                // Adicionar ao Recycler
                                curApiItem.setBand(bandName);
                                curApiItem.setCampoTop(songTitle);
                                curApiItem.setCampoBottom(bandName);
                                curApiItem.setUrl(pgUrl);
                                listaDeMusicas.add(curApiItem);
                                Log.i(TAG, " Musica API: " +curApiItem.getCampoTop());

                            } else if(bandName != null && songTitle == null){

                                // Printar txt
                                gotResult = gotResult+"ARTISTA - "+bandName+"\n";

                                // Adicionar ao Recycler
                                curApiItem.setBand(bandName);
                                curApiItem.setCampoTop(bandName);
                                curApiItem.setCampoBottom("Ver músicas");
                                curApiItem.setUrl(pgUrl);
                                listaDeArtistas.add(curApiItem);
                                Log.i(TAG, " Artista_old API: " +curApiItem.getCampoTop());
                            }
                        }

                    }

                    Log.i(TAG, " Tamanho Lista Artistas: " +listaDeArtistas.size());
                    Log.i(TAG, " Tamanho Lista Musicas: " +listaDeMusicas.size());

                    listaDeArtistas.addAll(listaDeMusicas);
                    buscaAdapter.adicionarListaDeApiItems(listaDeArtistas);

                }else {Log.e(TAG, " onResponse: "+response.errorBody());}
            }

            @Override
            public void onFailure(Call<VagalumeBusca> call, Throwable t){Log.e(TAG, " onFailure: "+t.getMessage());}
        });
    }


    @Override
    public void onApiBuscarClicado(ApiItem apiItem) {
        String url = apiItem.getUrl();
        url = "https://www.vagalume.com.br"+url;

        Intent intent = new Intent(getActivity(), VagalumeAbrirLink.class);
        Bundle bundle = new Bundle();

        // Para poder adicionar ao bundle, a classe tem que implementar "Serializable"
        bundle.putString("HOTSPOT_LINK", url);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
