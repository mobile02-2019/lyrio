package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lyrio.Adapters.ListaArtistasSalvosAdapter;
import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.interfaces.ListaArtistasSalvosListener;

import java.util.ArrayList;
import java.util.List;

public class ListaArtistasSalvosActivity extends AppCompatActivity implements ListaArtistasSalvosListener {

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_artistas_salvos);

        List<ArtistaSalvo> listaArtistaSalvo = new ArrayList<>();

        ArtistaSalvo artistaSalvo = new ArtistaSalvo();
        artistaSalvo.setNomeArtistaSalvo("Paula Fernandes");
        artistaSalvo.setImagemArtistaSalvo("https://static.wixstatic.com/media/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.jpg/v1/fill/w_234,h_234,al_c,q_80,usm_0.66_1.00_0.01/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.webp");
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);

        ListaArtistasSalvosAdapter listaArtistasSalvosAdapter = new ListaArtistasSalvosAdapter(listaArtistaSalvo, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        RecyclerView recyclerView = findViewById(R.id.lista_artistas_salvos_recycler_view_id);
        recyclerView.setAdapter(listaArtistasSalvosAdapter);
        recyclerView.setLayoutManager(layoutManager);

        backButton = findViewById(R.id.back_button_meus_artistas_image_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaHome();
            }
        });
    }

    private void voltarParaHome() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onListaArtistasSalvosClicado(ArtistaSalvo artistaSalvo) {
        Intent intent = new Intent(this, PaginaArtistaActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("ARTISTA", artistaSalvo);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
