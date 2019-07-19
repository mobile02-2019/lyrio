package com.example.lyrio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyrio.R;
import com.example.lyrio.interfaces.ArtistaListener;
import com.example.lyrio.model.Artista;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArtistasAdapter extends RecyclerView.Adapter<ArtistasAdapter.ViewHolder> {

    private List<Artista> listaDeArtistas = new ArrayList<>();
    private ArtistaListener artistaListener;

    public ArtistasAdapter(List<Artista> listaDeArtistas, ArtistaListener artistaListener) {
        this.listaDeArtistas = listaDeArtistas;
        this.artistaListener = artistaListener;
    }

    public ArtistasAdapter(List<Artista> listaDeArtistas) {
        this.listaDeArtistas = listaDeArtistas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_lista_artistas, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Artista artista = listaDeArtistas.get(i);
        viewHolder.setupArtistas(artista);
    }

    @Override
    public int getItemCount() {
        return listaDeArtistas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView artistaTextView;
        private CircleImageView imagemArtistaImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistaTextView = itemView.findViewById(R.id.artista_text_view_id);
            imagemArtistaImageView = itemView.findViewById(R.id.imagem_circleImageView);

        }

        public void setupArtistas(Artista artista) {
            artistaTextView.setText(artista.getArtista());
        }
    }


}
