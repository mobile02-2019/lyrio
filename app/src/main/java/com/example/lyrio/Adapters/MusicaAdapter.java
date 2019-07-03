package com.example.lyrio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrio.R;
import com.example.lyrio.Models.Musica;

import java.util.ArrayList;
import java.util.List;

public class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.ViewHolder> {

    private List<Musica> listaMusica = new ArrayList<>();

    public MusicaAdapter(List<Musica> listaMusica) {
        this.listaMusica = listaMusica;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.musica_componente, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Musica musica = listaMusica.get(i);
        viewHolder.setupMusica(musica);

    }

    @Override
    public int getItemCount() {
        return listaMusica.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView musicaTextView;
        private ImageView imagemCapaImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemCapaImageView= itemView.findViewById(R.id.imagem_album_mini_id);
            musicaTextView = itemView.findViewById(R.id.titulo_musica);

        }

        public void setupMusica(Musica musica) {
            musicaTextView.setText(musica.getNomeMusica());


        }
    }
}
