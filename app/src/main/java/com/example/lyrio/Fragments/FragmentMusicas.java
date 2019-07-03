package com.example.lyrio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrio.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMusicas extends Fragment {


    public FragmentMusicas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_musicas, container, false);
    }

}
