package com.example.lyrio.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentArtistaDetalhes extends Fragment {


    public FragmentArtistaDetalhes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_artista_detalhes, container, false);
    }

}
