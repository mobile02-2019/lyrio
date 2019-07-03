package com.example.lyrio;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lyrio.adapter.ArtistasAdapter;
import com.example.lyrio.model.Artista;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaDeArtistasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_artistas);

        List<Artista> listaDeArtistas = new ArrayList<>();
        Artista artista = new Artista();
        artista.setArtista("Paula Fernandes");
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

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        ArtistasAdapter artistasAdapter = new ArtistasAdapter(listaDeArtistas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_artistas_id);
        recyclerView.setAdapter(artistasAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void irParaListaArtista(View view) {
    }

    public void irParaMinhaBiblioteca(View view) {
    }

    public void irParaFragmentArtistaDetalhe(View view) {
    }
}
