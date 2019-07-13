package com.example.lyrio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyrio.Adapters.ArtistaSalvoAdapter;
import com.example.lyrio.Adapters.MusicaSalvaAdapter;
import com.example.lyrio.Adapters.NoticiaSalvaAdapter;
import com.example.lyrio.Models.Artista;
import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.Models.MusicaSalva;
import com.example.lyrio.Models.NoticiaSalva;
import com.example.lyrio.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }

    private String gotMail;
    private TextView userName;
    private TextView userStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        List<MusicaSalva> listaMusicaSalva = new ArrayList<>();

        MusicaSalva musicaSalva = new MusicaSalva();
        musicaSalva.setNomeMusicaSalva("Passaro de Fogo");
        musicaSalva.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva);

        MusicaSalva musicaSalva1 = new MusicaSalva();
        musicaSalva1.setNomeMusicaSalva("Chuva chover");
        musicaSalva1.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva);listaMusicaSalva.add(musicaSalva1);listaMusicaSalva.add(musicaSalva);listaMusicaSalva.add(musicaSalva1);

        MusicaSalvaAdapter musicaSalvaAdapter = new MusicaSalvaAdapter(listaMusicaSalva);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.musica_salva_recycler_view);

        recyclerView.setAdapter((musicaSalvaAdapter));
        recyclerView.setLayoutManager(layoutManager);

        List<ArtistaSalvo> listaArtistaSalvo = new ArrayList<>();

        ArtistaSalvo artistaSalvo = new ArtistaSalvo();
        artistaSalvo.setNomeArtistaSalvo("Paula Fernandes");
        artistaSalvo.setImagemArtistaSalvo("https://static.wixstatic.com/media/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.jpg/v1/fill/w_234,h_234,al_c,q_80,usm_0.66_1.00_0.01/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.webp");
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);listaArtistaSalvo.add(artistaSalvo);

        ArtistaSalvoAdapter artistaSalvoAdapter = new ArtistaSalvoAdapter(listaArtistaSalvo);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView1 = view.findViewById(R.id.artistas_salvos_recycler_view);

        recyclerView1.setAdapter(artistaSalvoAdapter);
        recyclerView1.setLayoutManager(layoutManager1);

        List<NoticiaSalva> listaNoticiasSalvas = new ArrayList<>();

        NoticiaSalva noticiaSalva = new NoticiaSalva();
        noticiaSalva.setTituloNoticiaSalva("Dia do Rock");
        noticiaSalva.setImagemNoticiaSalva("https://caisdamemoria.files.wordpress.com/2018/07/dia-mundial-do-rock.jpg?w=620");
        listaNoticiasSalvas.add(noticiaSalva);
        listaNoticiasSalvas.add(noticiaSalva);listaNoticiasSalvas.add(noticiaSalva);listaNoticiasSalvas.add(noticiaSalva);

        NoticiaSalvaAdapter noticiaSalvaAdapter = new NoticiaSalvaAdapter(listaNoticiasSalvas);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerView2 = view.findViewById(R.id.noticias_salvas_recycler_view);

        recyclerView2.setAdapter(noticiaSalvaAdapter);
        recyclerView2.setLayoutManager(layoutManager2);


        userName = view.findViewById(R.id.txtUserName);
        userStatus = view.findViewById(R.id.txtUserStatus);

        try{
            gotMail = getActivity().getIntent().getExtras().getString("EMAIL");
        }catch (Exception e){
            gotMail = null;
        }

        if(gotMail != null){
            userName.setText(gotMail);
            userStatus.setText("Notificações ativas");
        }else{
            userName.setText("Faça seu login");
            userStatus.setText("Sem notificações");
        }

        return view;
    }
}
