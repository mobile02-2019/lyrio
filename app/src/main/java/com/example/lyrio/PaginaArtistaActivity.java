package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyrio.adapters.ListaMusicasSalvasAdapter;
import com.example.lyrio.api.BaseVagalume.ApiArtista;
import com.example.lyrio.models.Album;
import com.example.lyrio.models.Musica;
import com.example.lyrio.interfaces.AlbumListener;
import com.example.lyrio.interfaces.ListaMusicasSalvasListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PaginaArtistaActivity extends AppCompatActivity implements ListaMusicasSalvasListener, AlbumListener {

    private CircleImageView imagemArtistaImageView;
    private TextView nomeArtistaTextView;
    private Button seguirButton;
    private ImageButton backButton;
    private ImageView artistaBg;

    //Associar ao termo "VAGALUME" para filtrar no LOGCAT
    private static final String TAG = "VAGALUME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_artista);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ApiArtista artistaSalvo = (ApiArtista) bundle.getSerializable("ARTISTA");

        //Definir as variaveis
        artistaBg = findViewById(R.id.artista_imagem_bg);
        nomeArtistaTextView = findViewById(R.id.artista_nome_artista_text_view);
        imagemArtistaImageView = findViewById(R.id.artista_profile_image_view);
        seguirButton = findViewById(R.id.seguir_artista_button);
        backButton = findViewById(R.id.back_button_pagina_artista_image_button);

        //Set variaveis
        nomeArtistaTextView.setText(artistaSalvo.getDesc());
        Picasso.get().load(artistaSalvo.getPic_small()).into(imagemArtistaImageView);
        Picasso.get().load(artistaSalvo.getPic_medium()).into(artistaBg);

        seguirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaginaArtistaActivity.this, "Seguindo Artista", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaUltimaPagina();
            }
        });

        //Recycler com a lista de músicas que veio no Bundle
        ListaMusicasSalvasAdapter listaMusicasSalvasAdapter = new ListaMusicasSalvasAdapter(artistaSalvo.getMusicasSalvas(), this, artistaSalvo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.pagina_artista_lista_musicas_recycler_view);
        recyclerView.setAdapter(listaMusicasSalvasAdapter);
        recyclerView.setLayoutManager(layoutManager);


//        List<Album> listaAlbum = new ArrayList<>();
//        Album album1 = new Album(R.drawable.paula_fernandes);
//        listaAlbum.add(album1);
//        Album album2 = new Album(R.drawable.u2);
//        listaAlbum.add(album2);
//        Album album3 = new Album(R.drawable.paula_fernandes);
//        listaAlbum.add(album3);
//        Album album4 = new Album(R.drawable.u2);
//        listaAlbum.add(album4);
//
//        AlbumAdapter albumAdapter = new AlbumAdapter(listaAlbum, this);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
//        RecyclerView recyclerView1 = findViewById(R.id.pagina_artista_lista_albuns_recyler_view);
//        recyclerView1.setAdapter(albumAdapter);
//        recyclerView1.setLayoutManager(linearLayoutManager);
    }

    private void voltarParaUltimaPagina() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onAlbumClicado(Album album) {
        Intent intent = new Intent(this, ListaAlbumActivity.class);
        startActivity(intent);
    }

    @Override
    public void onListaMusicasSalvasClicado(Musica musicaSalva) {

//        Log.i(TAG, " LETRA: "+musicaSalva.getText());

        Intent intent = new Intent(this, TelaLetras.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("MUSICA", musicaSalva);
        intent.putExtras(bundle);

        startActivity(intent);


//        Intent intent = new Intent(this, VagalumeAbrirLink.class);
//        Bundle bundle = new Bundle();
//
//        // Para poder adicionar ao bundle, a classe tem que implementar "Serializable"
//        bundle.putString("HOTSPOT_LINK", musicaSalva.getUrl());
//        intent.putExtras(bundle);
//
//        startActivity(intent);
    }
}
