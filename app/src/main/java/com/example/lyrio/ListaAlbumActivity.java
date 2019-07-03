package com.example.lyrio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.lyrio.Adapters.AlbumAdapter;
import com.example.lyrio.Adapters.MusicaAdapter;
import com.example.lyrio.Models.Album;
import com.example.lyrio.Models.Musica;

import java.util.ArrayList;
import java.util.List;

public class ListaAlbumActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_album);

        List<Album> listaAlbum = new ArrayList<>();
        Album album1 = new Album(R.drawable.paula_fernandes);
        listaAlbum.add(album1);
        Album album2 = new Album(R.drawable.u2);
        listaAlbum.add(album2);
        Album album3 = new Album(R.drawable.paula_fernandes);
        listaAlbum.add(album3);
        Album album4 = new Album(R.drawable.u2);
        listaAlbum.add(album4);




        List<Musica> listamusica = new ArrayList<>();
        Musica musica1 = new Musica("Passaro de Fogo");
        listamusica.add(musica1);
        Musica musica2 = new Musica("Tocando em Frente");
        listamusica.add(musica2);
        Musica musica3 = new Musica("Sensações");
        listamusica.add(musica3);
        Musica musica4 = new Musica("Passaro de Fogo");
        listamusica.add(musica4);
        Musica musica5 = new Musica("Tocando em Frente");
        listamusica.add(musica5);
        Musica musica6 = new Musica("Sensações");
        listamusica.add(musica6);


        AlbumAdapter albumAdapter = new AlbumAdapter(listaAlbum);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView = findViewById(R.id.recycler_album);
        recyclerView.setAdapter(albumAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);


        MusicaAdapter musicaAdapter = new MusicaAdapter(listamusica);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);

        RecyclerView recyclerView1= findViewById(R.id.recycler_musica);
        recyclerView1.setAdapter(musicaAdapter);
        recyclerView1.setLayoutManager(linearLayoutManager1);

    }
}
