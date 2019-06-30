package com.example.lyrio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lyrio.adapter.ArtistasAdapter;
import com.example.lyrio.interfaces.ArtistaListener;
import com.example.lyrio.model.Artista;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeArtistasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_artistas);

        List<Artista> listaDeArtistas = new ArrayList<>();
        Artista artista = new Artista();
        artista.setArtista("Mettalica");
        CircleImageView circleImageView;
        listaDeArtistas.add(artista);

        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);
        listaDeArtistas.add(artista);

        ArtistasAdapter artistasAdapter = new ArtistasAdapter(listaDeArtistas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_id);
        recyclerView.setAdapter(artistasAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

}
