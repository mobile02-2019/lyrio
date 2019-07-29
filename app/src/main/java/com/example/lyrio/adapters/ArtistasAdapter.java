package com.example.lyrio.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyrio.R;
import com.example.lyrio.interfaces.ArtistaListener;
import com.example.lyrio.models.Artista_old;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArtistasAdapter extends RecyclerView.Adapter<ArtistasAdapter.ViewHolder> {

    private List<Artista_old> listaDeArtistaOlds = new ArrayList<>();
    private ArtistaListener artistaListener;

    public ArtistasAdapter(List<Artista_old> listaDeArtistaOlds, ArtistaListener artistaListener) {
        this.listaDeArtistaOlds = listaDeArtistaOlds;
        this.artistaListener = artistaListener;
    }

    public ArtistasAdapter(List<Artista_old> listaDeArtistaOlds) { this.listaDeArtistaOlds = listaDeArtistaOlds; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_lista_artistas, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Artista_old artistaOld = listaDeArtistaOlds.get(i);
        viewHolder.setupArtistas(artistaOld);
    }

    @Override
    public int getItemCount() {
        return listaDeArtistaOlds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView artistaTextView;
        private CircleImageView imagemArtistaImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistaTextView=itemView.findViewById(R.id.artista_text_view_id);
            imagemArtistaImageView=itemView.findViewById(R.id.imagem_circleImageView);

        }

        public void setupArtistas (Artista_old artistaOld){
            artistaTextView.setText(artistaOld.getArtista());
        }
    }


}
