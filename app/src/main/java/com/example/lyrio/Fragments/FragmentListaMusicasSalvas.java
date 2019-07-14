package com.example.lyrio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrio.Adapters.ListaMusicasSalvasAdapter;
import com.example.lyrio.Models.MusicaSalva;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ListaMusicasSalvasListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaMusicasSalvas extends Fragment implements ListaMusicasSalvasListener {


    public FragmentListaMusicasSalvas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_lista_musicas_salvas, container, false);

        List<MusicaSalva> listaMusicaSalva = new ArrayList<>();

        MusicaSalva musicaSalva1 = new MusicaSalva();
        musicaSalva1.setNomeMusicaSalva("Chuva chover");
        musicaSalva1.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva1);

        ListaMusicasSalvasAdapter listaMusicasSalvasAdapter = new ListaMusicasSalvasAdapter(listaMusicaSalva, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = view.findViewById(R.id.lista_minhas_musicas_recycler_view);
        recyclerView.setAdapter(listaMusicasSalvasAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onListaMusicasSalvasClicado(MusicaSalva musicaSalva) {

    }
}
