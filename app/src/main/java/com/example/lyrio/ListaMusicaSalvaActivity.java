package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lyrio.adapters.ListaMusicasSalvasAdapter;
import com.example.lyrio.models.Musica;
import com.example.lyrio.models.MusicaSalva;
import com.example.lyrio.interfaces.ListaMusicasSalvasListener;

import java.util.ArrayList;
import java.util.List;

public class ListaMusicaSalvaActivity extends AppCompatActivity implements ListaMusicasSalvasListener {

    private ImageButton voltarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_musica_salva);

        List<Musica> listaMusicaSalva = new ArrayList<>();

        Musica musicaSalva1 = new Musica();
        musicaSalva1.setDesc("Chuva chover");
        musicaSalva1.setAlbumPic("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva1);

        listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);


//        ListaMusicasSalvasAdapter listaMusicasSalvasAdapter = new ListaMusicasSalvasAdapter(listaMusicaSalva, this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        RecyclerView recyclerView = findViewById(R.id.minhas_musicas_salvas_recycler_view_id);
//        recyclerView.setAdapter(listaMusicasSalvasAdapter);
//        recyclerView.setLayoutManager(layoutManager);

        voltarButton = findViewById(R.id.back_button_minhas_musicas_image_button);
        voltarButton.setOnClickListener(new View.OnClickListener() {
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
    public void onListaMusicasSalvasClicado(Musica musicaSalva) {
        Intent intent = new Intent(this, TelaLetras.class);
        startActivity(intent);
    }
}
