package com.example.lyrio.Fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.lyrio.Adapters.ArtistaSalvoAdapter;
import com.example.lyrio.Adapters.MusicaSalvaAdapter;
import com.example.lyrio.Adapters.NoticiaSalvaAdapter;
import com.example.lyrio.ListaArtistasSalvosActivity;
import com.example.lyrio.ListaMusicaSalvaActivity;
import com.example.lyrio.ListaNoticiaSalvaActivity;
import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.Models.MusicaSalva;
import com.example.lyrio.Models.NoticiaSalva;
import com.example.lyrio.PaginaArtistaActivity;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ArtistaSalvoListener;
import com.example.lyrio.interfaces.MusicaSalvaListener;
import com.example.lyrio.interfaces.NoticiaSalvaListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentConfiguracoes extends Fragment {


    private ImageView setaVoltar;
    private Button logoutButton;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_configuracoes, container, false);


        setaVoltar = view.findViewById(R.id.voltar_imageView);
        logoutButton = view.findViewById(R.id.logout_button);


        setaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                voltarParaHome();
            }
        });


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(container.getContext())
                        .setTitle("ATENÇÃO")
                        .setMessage("Deseja realmente fazer LogOut no APP?")
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                fecharApp();
                            }
                        })
                        .setNegativeButton("NÂO", null);
                alert.create();
                alert.show();
            }
        });

    } // não to achando esse erro


    private void fecharApp() {

        // precisa fechas o app

    }

    private void voltarParaHome() {
        Intent intent = new Intent(getContext(), FragmentHome.class);
        startActivity(intent);
    }
}
