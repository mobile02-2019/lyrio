package com.example.lyrio.fragments;

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

import com.example.lyrio.ListaArtistasSalvosActivity;
import com.example.lyrio.PaginaArtistaActivity;
import com.example.lyrio.adapters.ArtistaSalvoAdapter;
import com.example.lyrio.adapters.MusicaSalvaAdapter;
import com.example.lyrio.adapters.NoticiaSalvaAdapter;
import com.example.lyrio.api.BaseVagalume.ApiArtista;
import com.example.lyrio.api.BaseVagalume.ApiItem;
import com.example.lyrio.api.BaseVagalume.VagalumeBusca;
import com.example.lyrio.api.VagalumeBuscaApi;
import com.example.lyrio.ConfiguracoesActivity;
import com.example.lyrio.ListaMusicaSalvaActivity;
import com.example.lyrio.ListaNoticiaSalvaActivity;
import com.example.lyrio.constantes.Constantes;
import com.example.lyrio.interfaces.EnviarDeFragmentParaActivity;
import com.example.lyrio.login.LoginActivity;
import com.example.lyrio.models.Musica;
import com.example.lyrio.models.NoticiaSalva;
import com.example.lyrio.NoticiaActivity;
import com.example.lyrio.R;
import com.example.lyrio.TelaLetras;
import com.example.lyrio.interfaces.ArtistaSalvoListener;
import com.example.lyrio.interfaces.MusicaSalvaListener;
import com.example.lyrio.interfaces.NoticiaSalvaListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        PopupMenu.OnMenuItemClickListener{

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

    //Interfaces
    private EnviarDeFragmentParaActivity enviarDeFragmentParaActivity;

    //Adapters
    private ArtistaSalvoAdapter artistaSalvoAdapter;
    private MusicaSalvaAdapter musicaSalvaAdapter;

    //Listas
    private List<ApiArtista> listaArtistaSalvo;
    private List<Musica> listaMusicaSalva;

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

        //Inicializar lista de musicas salvas;
        listaMusicaSalva = new ArrayList<>();

        //Conteudo musica salva
        String[] idDasMusicas = {"l3ade68b7g3be34ea3", "l3ade68b6g3e9aeda3", "l3ade68b8gb0bac0b3", "l3ade68b6g59b6fda3",
                "l3ade68b8gd9c820b3", "3ade68b8g736ed0b3", "3ade68b8g8371d0b3", "3ade68b8gee4ed0b3"};
        gerarListaDeMusicas(idDasMusicas);

        musicaSalvaAdapter = new MusicaSalvaAdapter(this);
        GridLayoutManager gridMusicas = new GridLayoutManager(view.getContext(),4);
        RecyclerView recyclerView = view.findViewById(R.id.musica_salva_recycler_view);
        recyclerView.setAdapter(musicaSalvaAdapter);
        recyclerView.setLayoutManager(gridMusicas);



        //Inicializar lista de artista salvo
        listaArtistaSalvo = new ArrayList<>();

        //Conteudo artista salvo
        String[] nomesDosArtistas = {"u2","skank","imagine-dragons","emicida","skrillex","rita-ora","rita-lee", "ac-dc"};
        gerarListaDeArtistas(nomesDosArtistas);

        artistaSalvoAdapter = new ArtistaSalvoAdapter(this);
        GridLayoutManager gridArtistas = new GridLayoutManager(view.getContext(), 4);
        RecyclerView recyclerView1 = view.findViewById(R.id.artistas_salvos_recycler_view);
        recyclerView1.setAdapter(artistaSalvoAdapter);
        recyclerView1.setLayoutManager(gridArtistas);





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

        //Recycler noticias
        NoticiaSalvaAdapter noticiaSalvaAdapter = new NoticiaSalvaAdapter(listaNoticiasSalvas, this);
        GridLayoutManager gridNoticias = new GridLayoutManager(view.getContext(), 3);
        RecyclerView recyclerView2 = view.findViewById(R.id.noticias_salvas_recycler_view);
        recyclerView2.setAdapter(noticiaSalvaAdapter);
        recyclerView2.setLayoutManager(gridNoticias);



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

//        Log.i(TAG, " RETROFIT: "+listaArtistaSalvo.size());                   // --------------------------------------------------------------------------
        try{
            enviarDeFragmentParaActivity.enviarListaDeArtistas(listaArtistaSalvo);
        }catch(Exception e){}

        Intent intent = new Intent(getContext(), ListaArtistasSalvosActivity.class);
        startActivity(intent);
    }


    @Override
    public void onArtistaClicado(ApiArtista artistaSalvo) {

        ApiArtista apiArtista = new ApiArtista();
        apiArtista.setDesc(artistaSalvo.getDesc());
        apiArtista.setPic_small(artistaSalvo.getPic_small());
        apiArtista.setPic_medium(artistaSalvo.getPic_medium());

        //Gerar lista para enviar ao bundle
        apiArtista.setMusicasSalvas(gerarListaDeMusicas(artistaSalvo));

        Intent intent = new Intent(getContext(), PaginaArtistaActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("ARTISTA", apiArtista);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    public void onMusicaSalvaClicado(Musica musicaSalva) {

        Intent intent = new Intent(getContext(), TelaLetras.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("MUSICA", musicaSalva);
        intent.putExtras(bundle);

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



    private void gerarListaDeArtistas(String[] nomesDosArtistas){

        // Iterar nomes de cada artista e buscar cada um na Api do Vagalume
        for(int i=0; i<nomesDosArtistas.length; i++){

//            Log.i(TAG, " NOME RECEBIDO: "+nomesDosArtistas[i]);
            getApiData(nomesDosArtistas[i],"artista");

        }
    }

    private void gerarListaDeMusicas(String[] idDasMusicas){

        // Iterar nomes de cada artista e buscar cada um na Api do Vagalume
        for(int i=0; i<idDasMusicas.length; i++){

//            Log.i(TAG, " NOME RECEBIDO: "+nomesDosArtistas[i]);
            getApiData(idDasMusicas[i],"musica");

        }
    }


    private List<Musica> gerarListaDeMusicas(ApiArtista apiArtista){

        //Gerar lista de musicas para enviar ao bundle
        List<Musica> musicasSalvas = new ArrayList<>();
        for(int i=0; i<apiArtista.getToplyrics().getItem().size(); i++){

            ApiItem curApi = apiArtista.getToplyrics().getItem().get(i);
            String url = "https://www.vagalume.com.br"+curApi.getUrl();
            Musica musicaTemp = new Musica(curApi.getId(),curApi.getDesc(),url);
            musicaTemp.setAlbumPic(apiArtista.getPic_small());

            musicasSalvas.add(musicaTemp);

        }
        return musicasSalvas;
    }


    // Integração com API
    private void getApiData(String oQueBuscar, String artistaOuMusica) {

        oQueBuscar = oQueBuscar.trim().replace(" ", "-");
        String buscaFull = "";
//        String vagaKey = "71a778e291d45ea2b7d133146fd79bb5";
        String vagaKey = UUID.randomUUID()+"";

        switch (artistaOuMusica){
            case "artista":
                buscaFull = "https://www.vagalume.com.br/"+oQueBuscar+"/index.js";
                break;
            case "musica":
                buscaFull = "https://api.vagalume.com.br/search.php?apikey="+vagaKey+"&musid="+oQueBuscar;
                break;
        }

        VagalumeBuscaApi service = retrofit.create(VagalumeBuscaApi.class);
        Call<VagalumeBusca> vagalumeBuscaCall = service.getBuscaResponse(buscaFull);
        vagalumeBuscaCall.enqueue(new Callback<VagalumeBusca>() {
            @Override
            public void onResponse(Call<VagalumeBusca> call, Response<VagalumeBusca> response) {
                if(response.isSuccessful()){
                    VagalumeBusca vagalumeBusca = response.body();

                    if(vagalumeBusca.getArt()!=null){
                        ApiArtista apiArtista = vagalumeBusca.getArt();
                        ApiItem apiMusica = vagalumeBusca.getMus().get(0);

                        ApiArtista artistaRecebido = new ApiArtista();
                        artistaRecebido.setId(apiArtista.getId());
                        artistaRecebido.setName(apiArtista.getName());
                        artistaRecebido.setUrl(apiArtista.getUrl());
                        artistaRecebido.setPic_small(apiArtista.getUrl()+"images/profile.jpg");

                        // Logcat com tag VAGALUME
//                        Log.i(TAG, " RETROFIT url imagem: "+artistaRecebido.getPic_small());

                        Musica musicaRecebida = new Musica();
                        musicaRecebida.setId(apiMusica.getId());
                        musicaRecebida.setName(apiMusica.getName());
                        musicaRecebida.setUrl(apiMusica.getUrl());
                        musicaRecebida.setLang(apiMusica.getLang());
                        musicaRecebida.setText(apiMusica.getText());
                        musicaRecebida.setAlbumPic(artistaRecebido.getPic_small());
                        musicaRecebida.setArtista(apiArtista);

                        //Adicionar a lista de Musicas
                        listaMusicaSalva.add(musicaRecebida);

                        //Adicionar ao Adapter do RecyclerView
                        musicaSalvaAdapter.adicionarMusica(musicaRecebida);


                    }else{
                        ApiArtista apiArtist = vagalumeBusca.getArtist();

                        ApiArtista artistaRecebido = new ApiArtista();
                        artistaRecebido.setDesc(apiArtist.getDesc());
                        artistaRecebido.setPic_small("https://www.vagalume.com.br"+apiArtist.getPic_small());
                        artistaRecebido.setPic_medium("https://www.vagalume.com.br"+apiArtist.getPic_medium());
                        artistaRecebido.setQtdMusicas(apiArtist.getLyrics().getItem().size());
                        artistaRecebido.setToplyrics(apiArtist.getToplyrics());

                        //Adicionar a lista de Artistas
                        listaArtistaSalvo.add(artistaRecebido);

                        //Adicionar ao Adapter do RecyclerView
                        artistaSalvoAdapter.adicionarArtista(artistaRecebido);
                    }

                }else {Log.e(TAG, " onResponse: "+response.errorBody());}
            }

            @Override
            public void onFailure(Call<VagalumeBusca> call, Throwable t){Log.e(TAG, " onFailure: "+t.getMessage());}
        });
    }
}
