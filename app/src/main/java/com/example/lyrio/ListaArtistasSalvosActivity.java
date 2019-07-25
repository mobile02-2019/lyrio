package com.example.lyrio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lyrio.adapters.ArtistaSalvoAdapter;
import com.example.lyrio.api.BaseVagalume.ApiArtista;
import com.example.lyrio.interfaces.ArtistaSalvoListener;
import com.example.lyrio.interfaces.EnviarDeFragmentParaActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaArtistasSalvosActivity extends AppCompatActivity
        implements ArtistaSalvoListener,
        EnviarDeFragmentParaActivity {

    private ImageButton backButton;
    private ArtistaSalvoAdapter artistaSalvoAdapter;
    private List<ApiArtista> listaArtistaSalvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_artistas_salvos);

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        ArtistaBundle artistaBundle = (ArtistaBundle) bundle.getSerializable("ARTISTA_BUNDLE");
//
//        listaArtistaSalvo = artistaBundle.getListaDeArtistas();

        artistaSalvoAdapter = new ArtistaSalvoAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        RecyclerView recyclerView1 = findViewById(R.id.lista_artistas_salvos_recycler_view_id);
        recyclerView1.setAdapter(artistaSalvoAdapter);
        recyclerView1.setLayoutManager(gridLayoutManager);

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
    public void onArtistaClicado(ApiArtista artistaSalvo) {
//        Intent intent = new Intent(this, PaginaArtistaActivity.class);
//
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("ARTISTA", artistaSalvo);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }

    @Override
    public void enviarListaDeArtistas(List<ApiArtista> listaDeArtistas) {
        listaArtistaSalvo = listaDeArtistas;
    }
}
