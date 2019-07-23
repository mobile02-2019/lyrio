package com.example.lyrio.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.lyrio.Api.BaseVagalume.ApiArtista;
import com.example.lyrio.Api.BaseVagalume.ApiItem;
import com.example.lyrio.Api.BaseVagalume.VagalumeBusca;
import com.example.lyrio.Api.VagalumeBuscaApi;
import com.example.lyrio.ConfiguracoesActivity;
import com.example.lyrio.Interface.ApiBuscaListener_02;
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
import com.example.lyrio.TelaLetras;
import com.example.lyrio.interfaces.ArtistaSalvoListener;
import com.example.lyrio.interfaces.MusicaSalvaListener;
import com.example.lyrio.interfaces.NoticiaSalvaListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment implements ArtistaSalvoListener,
        MusicaSalvaListener,
        NoticiaSalvaListener,
        PopupMenu.OnMenuItemClickListener,
        ApiBuscaListener_02 {

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

    //Adapters
    ArtistaSalvoAdapter artistaSalvoAdapter;

    //Integração Api
    private Retrofit retrofit;

    //Associar ao termo "VAGALUME" para filtrar no LOGCAT
    private static final String TAG = "VAGALUME";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);


        // Iniciar retrofit para buscar infos da API
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vagalume.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        //Conteudo musica salva
        List<MusicaSalva> listaMusicaSalva = new ArrayList<>();
        MusicaSalva musicaSalva = new MusicaSalva();
        musicaSalva.setNomeMusicaSalva("Imagine");
        musicaSalva.setImagemMusicaSalva("https://studiosol-a.akamaihd.net/letras/150x150/fotos/0/6/b/9/06b906a076ba97a916e8283db292cf0a.jpg");
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);
        listaMusicaSalva.add(musicaSalva);


        //Recycler musica salva
        MusicaSalvaAdapter musicaSalvaAdapter = new MusicaSalvaAdapter(listaMusicaSalva, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = view.findViewById(R.id.musica_salva_recycler_view);
        recyclerView.setAdapter((musicaSalvaAdapter));
        recyclerView.setLayoutManager(layoutManager);


        //Conteudo artista salvo
        List<ArtistaSalvo> listaArtistaSalvo = new ArrayList<>();
        getApiData("u2","");
        getApiData("skank","");
        getApiData("imagine-dragons","");
        getApiData("emicida","");
        getApiData("skrillex","");
        getApiData("natiruts","");
        getApiData("paralamas-do-sucesso","");
        getApiData("rita-lee","");

        //Recycler artista salvo
        artistaSalvoAdapter = new ArtistaSalvoAdapter(listaArtistaSalvo, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 4);
        RecyclerView recyclerView1 = view.findViewById(R.id.artistas_salvos_recycler_view);
        recyclerView1.setAdapter(artistaSalvoAdapter);
        recyclerView1.setLayoutManager(gridLayoutManager);


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
        Intent intent = new Intent(getContext(), TelaLetras.class);
        startActivity(intent);

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
            case R.id.item_editar_perfil:
                Intent intent02 = new Intent(getContext(), ConfiguracoesActivity.class);
                startActivity(intent02);
                return true;
            default:
                return false;
        }
    }




    // Integração com API

    private void getApiData(String nomeDoArtista, String nomeDaMusica) {

        nomeDoArtista = nomeDoArtista.trim().replace(" ", "-");
        String vagaKey =  "52433bd778677b92342a16ddf927e4bf";

        String buscaBase = "https://www.vagalume.com.br/";
        String buscaArtista = nomeDoArtista+"/index.js";
        String buscaFull = buscaBase+buscaArtista;

        VagalumeBuscaApi service = retrofit.create(VagalumeBuscaApi.class);
        Call<VagalumeBusca> vagalumeBuscaCall = service.getBuscaResponse(buscaFull);
        vagalumeBuscaCall.enqueue(new Callback<VagalumeBusca>() {
            @Override
            public void onResponse(Call<VagalumeBusca> call, Response<VagalumeBusca> response) {
                if(response.isSuccessful()){
                    VagalumeBusca vagalumeBusca = response.body();
                    ApiArtista apiArtist = vagalumeBusca.getArtist();

                    ArtistaSalvo artistaSalvo = new ArtistaSalvo();
                    artistaSalvo.setNomeArtistaSalvo(apiArtist.getDesc());
                    artistaSalvo.setImagemArtistaSalvo("https://www.vagalume.com.br"+apiArtist.getPic_small());

                    artistaSalvoAdapter.adicionarArtista(artistaSalvo);

                    String popSong = "";

                    try{
                        popSong = apiArtist.getToplyrics().getItem().get(0).getDesc();
                    }catch(Exception e){}

                    //Logcat -> nome do artista e url
                    Log.i(TAG, " getApiData -> Nome Artista: "+artistaSalvo.getNomeArtistaSalvo()+",\nImagem: "+artistaSalvo.getImagemArtistaSalvo()+",\nPop Song: "+popSong);


                }else {Log.e(TAG, " onResponse: "+response.errorBody());}
            }

            @Override
            public void onFailure(Call<VagalumeBusca> call, Throwable t){Log.e(TAG, " onFailure: "+t.getMessage());}
        });
    }


    @Override
    public void onApiBuscarClicado(ApiItem apiItem) {
//        String url = apiItem.getUrl();
////        String[] urlSplit = url.split("/");
//        url = "https://www.vagalume.com.br"+url;
//
//        Intent intent = new Intent(getActivity(), VagalumeAbrirLink.class);
//        Bundle bundle = new Bundle();
//
//        // Para poder adicionar ao bundle, a classe tem que implementar "Serializable"
//        bundle.putString("HOTSPOT_LINK", url);
//        intent.putExtras(bundle);
//
//        startActivity(intent);
    }



}
