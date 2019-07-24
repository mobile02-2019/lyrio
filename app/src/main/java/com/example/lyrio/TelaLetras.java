package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.lyrio.R;
import com.example.lyrio.api.BaseVagalume.ApiArtista;
import com.example.lyrio.api.BaseVagalume.ApiItem;
import com.example.lyrio.api.BaseVagalume.VagalumeBusca;
import com.example.lyrio.api.VagalumeBuscaApi;
import com.example.lyrio.models.Musica;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaLetras extends AppCompatActivity {

    private TextView nomeDoArtista;
    private TextView nomeDaMusica;
    private TextView letraDaMusica;
    private CircleImageView imagemArtista;
    private Retrofit retrofit;
    private Musica musicaSelecionada;


    //Associar ao termo "VAGALUME" para filtrar no LOGCAT
    private static final String TAG = "VAGALUME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_letras);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Musica musicaSalva = (Musica) bundle.getSerializable("MUSICA");


        // Iniciar retrofit para buscar infos da API
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vagalume.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        musicaSelecionada = new Musica();

        nomeDaMusica = findViewById(R.id.letras_nome_musica_text_view);
        nomeDoArtista = findViewById(R.id.letras_nome_artista_text_view);
        letraDaMusica = findViewById(R.id.letras_letra_musica_text_view);
        imagemArtista = findViewById(R.id.letras_artist_pic);


        if(musicaSalva.getText()!=null){
            nomeDaMusica.setText(musicaSalva.getName());
            nomeDoArtista.setText(musicaSalva.getArtista().getName());
            letraDaMusica.setText(musicaSalva.getText());
            Picasso.get().load(musicaSalva.getAlbumPic()).into(imagemArtista);
        }else{
            getApiData(musicaSalva.getId());
        }
    }

    private void getApiData(String idDaMusica) {

        idDaMusica = idDaMusica.trim().replace(" ", "-");
        String vagaKey =  "52433bd778677b92342a16ddf927e4bf";
        String buscaFull = "https://api.vagalume.com.br/search.php?apikey="+vagaKey+"&musid="+idDaMusica;

        VagalumeBuscaApi service = retrofit.create(VagalumeBuscaApi.class);
        Call<VagalumeBusca> vagalumeBuscaCall = service.getBuscaResponse(buscaFull);
        vagalumeBuscaCall.enqueue(new Callback<VagalumeBusca>() {
            @Override
            public void onResponse(Call<VagalumeBusca> call, Response<VagalumeBusca> response) {
                if(response.isSuccessful()){
                    VagalumeBusca vagalumeBusca = response.body();
//
//                    ApiArtista apiArtista = vagalumeBusca.getArt();
//                    ApiItem apiMusica = vagalumeBusca.getMus().get(0);

                    //Adicionar aos campos do xml
                    nomeDaMusica.setText(vagalumeBusca.getMus().get(0).getName());
                    nomeDoArtista.setText(vagalumeBusca.getArt().getName());
                    letraDaMusica.setText(vagalumeBusca.getMus().get(0).getText());
                    Picasso.get().load(vagalumeBusca.getArt().getUrl()+"images/profile.jpg").into(imagemArtista);

                }else {Log.e(TAG, " onResponse: "+response.errorBody());}
            }

            @Override
            public void onFailure(Call<VagalumeBusca> call, Throwable t){Log.e(TAG, " onFailure: "+t.getMessage());}
        });



    }
}
