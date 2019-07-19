package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyrio.Adapters.AlbumAdapter;
import com.example.lyrio.Adapters.ListaMusicasSalvasAdapter;
import com.example.lyrio.Models.Album;
import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.Models.MusicaSalva;
import com.example.lyrio.interfaces.AlbumListener;
import com.example.lyrio.interfaces.ListaMusicasSalvasListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PaginaArtistaActivity extends AppCompatActivity implements ListaMusicasSalvasListener, AlbumListener {

    private CircleImageView imagemArtistaImageView;
    private TextView nomeArtistaTextView;
    private Button seguirButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_artista);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArtistaSalvo artistaSalvo = (ArtistaSalvo) bundle.getSerializable("ARTISTA");

        nomeArtistaTextView = findViewById(R.id.nome_pagina_artista_text_view_id);
        imagemArtistaImageView = findViewById(R.id.imagem_pagina_artista_image_view_id);

        nomeArtistaTextView.setText(artistaSalvo.getNomeArtistaSalvo());
        Picasso.get().load(artistaSalvo.getImagemArtistaSalvo()).into(imagemArtistaImageView);

        seguirButton = findViewById(R.id.seguir_artista_button);
        seguirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaginaArtistaActivity.this, "Seguindo Artista", Toast.LENGTH_SHORT).show();
            }
        });

        backButton = findViewById(R.id.back_button_pagina_artista_image_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaUltimaPagina();
            }
        });

        List<MusicaSalva> listaMusicaSalva = new ArrayList<>();
        MusicaSalva musicaSalva = new MusicaSalva();
        musicaSalva.setNomeMusicaSalva("Passaro de Fogo");
        musicaSalva.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);

        MusicaSalva musicaSalva1 = new MusicaSalva();
        musicaSalva1.setNomeMusicaSalva("Chuva chover");
        musicaSalva1.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);

        ListaMusicasSalvasAdapter listaMusicasSalvasAdapter = new ListaMusicasSalvasAdapter(listaMusicaSalva, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.pagina_artista_lista_musicas_recycler_view);
        recyclerView.setAdapter(listaMusicasSalvasAdapter);
        recyclerView.setLayoutManager(layoutManager);

        List<Album> listaAlbum = new ArrayList<>();
        Album album1 = new Album(R.drawable.paula_fernandes);
        listaAlbum.add(album1);
        Album album2 = new Album(R.drawable.u2);
        listaAlbum.add(album2);
        Album album3 = new Album(R.drawable.paula_fernandes);
        listaAlbum.add(album3);
        Album album4 = new Album(R.drawable.u2);
        listaAlbum.add(album4);

        AlbumAdapter albumAdapter = new AlbumAdapter(listaAlbum, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView1 = findViewById(R.id.pagina_artista_lista_albuns_recyler_view);
        recyclerView1.setAdapter(albumAdapter);
        recyclerView1.setLayoutManager(linearLayoutManager);
    }

    private void voltarParaUltimaPagina() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onListaMusicasSalvasClicado(MusicaSalva musicaSalva) {

    }

    @Override
    public void onAlbumClicado(Album album) {
        Intent intent = new Intent(this, ListaAlbumActivity.class);
        startActivity(intent);
    }
}
