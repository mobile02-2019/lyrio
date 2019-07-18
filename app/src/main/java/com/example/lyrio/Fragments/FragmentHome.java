package com.example.lyrio.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.example.lyrio.Adapters.ArtistaSalvoAdapter;
import com.example.lyrio.Adapters.MusicaSalvaAdapter;
import com.example.lyrio.Adapters.NoticiaSalvaAdapter;
import com.example.lyrio.ListaArtistasSalvosActivity;
import com.example.lyrio.ListaMusicaSalvaActivity;
import com.example.lyrio.ListaNoticiaSalvaActivity;
import com.example.lyrio.Login.LoginActivity;
import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.Models.MusicaSalva;
import com.example.lyrio.Models.NoticiaSalva;
import com.example.lyrio.NoticiaActivity;
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
public class FragmentHome extends Fragment implements ArtistaSalvoListener,
        MusicaSalvaListener,
        NoticiaSalvaListener,
        PopupMenu.OnMenuItemClickListener {

    public FragmentHome() {
        // Required empty public constructor
    }

    private String gotMail;
    private TextView userName;
    private TextView userStatus;
    private ImageButton opcoesUsuario;
    private TextView verMaisMusica;
    private TextView verMaisArtistas;
    private TextView verMaisNoticias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);


        //Conteudo musica salva
        List<MusicaSalva> listaMusicaSalva = new ArrayList<>();
        MusicaSalva musicaSalva = new MusicaSalva();
        musicaSalva.setNomeMusicaSalva("Passaro de Fogo");
        musicaSalva.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva);
        MusicaSalva musicaSalva1 = new MusicaSalva();
        musicaSalva1.setNomeMusicaSalva("Chuva chover");
        musicaSalva1.setImagemMusicaSalva("https://upload.wikimedia.org/wikipedia/pt/a/a5/P%C3%A1ssaro_de_Fogo.jpg");
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva1);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva1);

        //Recycler musica salva
        MusicaSalvaAdapter musicaSalvaAdapter = new MusicaSalvaAdapter(listaMusicaSalva, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = view.findViewById(R.id.musica_salva_recycler_view);
        recyclerView.setAdapter((musicaSalvaAdapter));
        recyclerView.setLayoutManager(layoutManager);


        //Conteudo artista salvo
        List<ArtistaSalvo> listaArtistaSalvo = new ArrayList<>();
        ArtistaSalvo artistaSalvo = new ArtistaSalvo();
        artistaSalvo.setNomeArtistaSalvo("Paula Fernandes");
        artistaSalvo.setImagemArtistaSalvo("https://static.wixstatic.com/media/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.jpg/v1/fill/w_234,h_234,al_c,q_80,usm_0.66_1.00_0.01/c1fcef_47f7144f7185411b82ac6ab7d0e8f1ec~mv2.webp");
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);
        listaArtistaSalvo.add(artistaSalvo);

        //Recycler artista salvo
        ArtistaSalvoAdapter artistaSalvoAdapter = new ArtistaSalvoAdapter(listaArtistaSalvo, this);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView1 = view.findViewById(R.id.artistas_salvos_recycler_view);
        recyclerView1.setAdapter(artistaSalvoAdapter);
        recyclerView1.setLayoutManager(layoutManager1);


        //Conteudo lista noticias
        List<NoticiaSalva> listaNoticiasSalvas = new ArrayList<>();
        NoticiaSalva noticiaSalva = new NoticiaSalva();
        noticiaSalva.setTituloNoticiaSalva("Dia do Rock!");
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

        //Recycler noticias
        NoticiaSalvaAdapter noticiaSalvaAdapter = new NoticiaSalvaAdapter(listaNoticiasSalvas, this);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView2 = view.findViewById(R.id.noticias_salvas_recycler_view);
        recyclerView2.setAdapter(noticiaSalvaAdapter);
        recyclerView2.setLayoutManager(layoutManager2);


        opcoesUsuario = view.findViewById(R.id.home_user_icon_image_button);
        opcoesUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), opcoesUsuario);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(FragmentHome.this);
            }
        });


        verMaisArtistas = view.findViewById(R.id.ver_mais_artistas_salvos_text_view);
        verMaisArtistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaMeusArtistas();
            }
        });

        verMaisMusica = view.findViewById(R.id.ver_mais_musica_text_view);
        verMaisMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaMinhasMusicas();
            }
        });

        verMaisNoticias = view.findViewById(R.id.ver_mais_noticias_salvas_text_view);
        verMaisNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaMinhasNoticias();
            }
        });


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
    //metodo que direciona para o Fragment que contem a lista de noticias salvas mas não esta direcionando direito
    private void irParaMinhasNoticias() {
        Intent intent = new Intent(getContext(), ListaNoticiaSalvaActivity.class);
        startActivity(intent);
    }
    //metodo que direciona para o Fragment que contem a lista de musicas salvas mas não esta direcionando direito
    private void irParaMinhasMusicas() {
        Intent intent = new Intent(getContext(), ListaMusicaSalvaActivity.class);

        startActivity(intent);
    }
    //metodo que direciona para o Fragment que contem a lista de artistas salvas mas não esta direcionando direito
    private void irParaMeusArtistas() {
        Intent intent = new Intent(getContext(), ListaArtistasSalvosActivity.class);
        startActivity(intent);
    }


    @Override
    public void onArtistaClicado(ArtistaSalvo artistaSalvo) {
        Intent intent = new Intent(getContext(), PaginaArtistaActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("ARTISTA", artistaSalvo);
        intent.putExtras(bundle);
        startActivity(intent);



    }

    @Override
    public void onMusicaSalvaClicado(MusicaSalva musicaSalva) {

    }

    @Override
    public void onNoticiaSalvaClicado(NoticiaSalva noticiaSalva) {
        Intent intent = new Intent(getContext(), NoticiaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch ((menuItem.getItemId())){
            case R.id.item_sair:
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
