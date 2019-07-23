package com.example.lyrio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyrio.Models.ArtistaSalvo;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ArtistaSalvoListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArtistaSalvoAdapter extends RecyclerView.Adapter<ArtistaSalvoAdapter.ViewHolder> {
    private List<ArtistaSalvo> listaArtistaSalvo;
    private ArtistaSalvoListener artistaSalvoListener;

    public ArtistaSalvoAdapter(List<ArtistaSalvo> listaArtistaSalvo, ArtistaSalvoListener artistaSalvoListener) {
        this.listaArtistaSalvo = listaArtistaSalvo;
        this.artistaSalvoListener = artistaSalvoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_artista_salvo,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ArtistaSalvo artistaSalvo = listaArtistaSalvo.get(i);
        viewHolder.setupArtistaSalvo(artistaSalvo);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                artistaSalvoListener.onArtistaClicado(artistaSalvo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaArtistaSalvo.size();
    }

    public void adicionarArtista(ArtistaSalvo artistaSalvo){
        listaArtistaSalvo.add(artistaSalvo);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imagemArtistaSalvoCircleImageView;
        private TextView nomeArtistaSalvoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemArtistaSalvoCircleImageView = itemView.findViewById(R.id.imagem_artista_salvo_circle_image_view);
            nomeArtistaSalvoTextView = itemView.findViewById(R.id.nome_artista_salvo_text_view);
        }
        public void setupArtistaSalvo(ArtistaSalvo artistaSalvo){
            nomeArtistaSalvoTextView.setText(artistaSalvo.getNomeArtistaSalvo());
            Picasso.get().load(artistaSalvo.getImagemArtistaSalvo()).into(imagemArtistaSalvoCircleImageView);
        }
    }
}
