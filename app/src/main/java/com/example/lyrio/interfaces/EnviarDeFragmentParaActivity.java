package com.example.lyrio.interfaces;

import com.example.lyrio.api.base_vagalume.ApiArtista;

import java.util.List;

public interface EnviarDeFragmentParaActivity {

    void enviarListaDeArtistas(List<ApiArtista> listaDeArtistas);

}
