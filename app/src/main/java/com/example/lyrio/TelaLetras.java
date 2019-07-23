package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lyrio.R;
import com.example.lyrio.api.BaseVagalume.ApiArtista;
import com.example.lyrio.models.Musica;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class TelaLetras extends AppCompatActivity {

    private TextView nomeDoArtista;
    private TextView nomeDaMusica;
    private TextView letraDaMusica;
    private CircleImageView imagemArtista;

    //Associar ao termo "VAGALUME" para filtrar no LOGCAT
    private static final String TAG = "VAGALUME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_letras);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Musica musicaSalva = (Musica) bundle.getSerializable("MUSICA");

        nomeDaMusica = findViewById(R.id.letras_nome_musica_text_view);
        nomeDoArtista = findViewById(R.id.letras_nome_artista_text_view);
        letraDaMusica = findViewById(R.id.letras_letra_musica_text_view);
        imagemArtista = findViewById(R.id.letras_artist_pic);

        nomeDaMusica.setText(musicaSalva.getName());
        nomeDoArtista.setText(musicaSalva.getArtista().getName());
        letraDaMusica.setText(musicaSalva.getText());
        Picasso.get().load(musicaSalva.getAlbumPic()).into(imagemArtista);

    }
}
