package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lyrio.adapters.ListaNoticiasSalvasAdapter;
import com.example.lyrio.models.NoticiaSalva;
import com.example.lyrio.interfaces.ListaNoticiasSalvasListener;

import java.util.ArrayList;
import java.util.List;

public class ListaNoticiaSalvaActivity extends AppCompatActivity implements ListaNoticiasSalvasListener {

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticia_salva);

        //Conteudo fakenews
        List<NoticiaSalva> listaNoticiasSalvas = new ArrayList<>();
        NoticiaSalva noticiaSalva = new NoticiaSalva();
        noticiaSalva.setTituloNoticiaSalva("Dia do Rock");
        noticiaSalva.setImagemNoticiaSalva("https://caisdamemoria.files.wordpress.com/2018/07/dia-mundial-do-rock.jpg?w=620");
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);

        //Recycler fakenews
        ListaNoticiasSalvasAdapter listaNoticiasSalvasAdapter = new ListaNoticiasSalvasAdapter(listaNoticiasSalvas,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.lista_minhas_noticias_salvas_recycler_view_id);
        recyclerView.setAdapter(listaNoticiasSalvasAdapter);
        recyclerView.setLayoutManager(layoutManager);

        backButton = findViewById(R.id.back_button_minhas_noticias_image_button);
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
    public void onListaNoticiasSalvasClicado(NoticiaSalva noticiaSalva) {
        Intent intent = new Intent(this, NoticiaActivity.class);
        startActivity(intent);

    }
}
