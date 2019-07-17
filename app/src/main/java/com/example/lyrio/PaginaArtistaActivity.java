package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyrio.Models.ArtistaSalvo;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PaginaArtistaActivity extends AppCompatActivity {

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
    }

    private void voltarParaUltimaPagina() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
