package com.example.lyrio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrio.Adapters.ArtistaSalvoAdapter;
import com.example.lyrio.Adapters.ListaArtistasSalvosAdapter;
import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaArtistasSalvos extends Fragment {


    public FragmentListaArtistasSalvos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_lista_artistas_salvos, container, false);

        List<ArtistaSalvo> listaArtistaSalvo = new ArrayList<>();

        ArtistaSalvo artistaSalvo = new ArtistaSalvo();
        artistaSalvo.setNomeArtistaSalvo("Paula Fernandes");
        artistaSalvo.setImagemArtistaSalvo("https://static.wixstatic.com/media/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.jpg/v1/fill/w_234,h_234,al_c,q_80,usm_0.66_1.00_0.01/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.webp");
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);

        ListaArtistasSalvosAdapter listaArtistasSalvosAdapter = new ListaArtistasSalvosAdapter(listaArtistaSalvo);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        RecyclerView recyclerView = view.findViewById(R.id.lista_meus_artistas_recycler_view);
        recyclerView.setAdapter(listaArtistasSalvosAdapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
}

}
