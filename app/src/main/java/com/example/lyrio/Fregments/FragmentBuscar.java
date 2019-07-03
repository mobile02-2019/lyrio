package com.example.lyrio.Fregments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.lyrio.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuscar extends Fragment {

    private EditText userInputBusca;


    public FragmentBuscar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_buscar, container, false);

        userInputBusca = view.findViewById(R.id.buscar_campo_de_busca);


        return view;
    }

}
