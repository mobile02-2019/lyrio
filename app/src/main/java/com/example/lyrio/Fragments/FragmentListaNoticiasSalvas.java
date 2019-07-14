package com.example.lyrio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrio.Adapters.ListaNoticiasSalvasAdapter;
import com.example.lyrio.Models.NoticiaSalva;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ListaNoticiasSalvasListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaNoticiasSalvas extends Fragment implements ListaNoticiasSalvasListener {


    public FragmentListaNoticiasSalvas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_lista_noticias_salvas, container, false);

        List<NoticiaSalva> listaNoticiasSalvas = new ArrayList<>();

        NoticiaSalva noticiaSalva = new NoticiaSalva();
        noticiaSalva.setTituloNoticiaSalva("Dia do Rock");
        noticiaSalva.setImagemNoticiaSalva("https://caisdamemoria.files.wordpress.com/2018/07/dia-mundial-do-rock.jpg?w=620");
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);listaNoticiasSalvas.add(noticiaSalva);listaNoticiasSalvas.add(noticiaSalva);

        ListaNoticiasSalvasAdapter listaNoticiasSalvasAdapter = new ListaNoticiasSalvasAdapter(listaNoticiasSalvas, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = view.findViewById(R.id.lista_minhas_noticias_recycler_view);
        recyclerView.setAdapter(listaNoticiasSalvasAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onListaNoticiasSalvasClicado(NoticiaSalva noticiaSalva) {

    }
}
