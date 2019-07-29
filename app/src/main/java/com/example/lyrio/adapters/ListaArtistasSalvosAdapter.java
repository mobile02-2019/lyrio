package com.example.lyrio.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyrio.models.ArtistaSalvo;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ListaArtistasSalvosListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaArtistasSalvosAdapter extends RecyclerView.Adapter<ListaArtistasSalvosAdapter.ViewHolder> {
    private List<ArtistaSalvo> listaArtistasSalvos;
    private ListaArtistasSalvosListener listaArtistasSalvosListener;

    public ListaArtistasSalvosAdapter(List<ArtistaSalvo> listaArtistasSalvos, ListaArtistasSalvosListener listaArtistasSalvosListener) {
        this.listaArtistasSalvos = listaArtistasSalvos;
        this.listaArtistasSalvosListener = listaArtistasSalvosListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_lista_artista_salvo,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ArtistaSalvo artistaSalvo = listaArtistasSalvos.get(i);
        viewHolder.setupArtistaSalvo(artistaSalvo);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaArtistasSalvosListener.onListaArtistasSalvosClicado(artistaSalvo);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaArtistasSalvos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imagemArtistaSalvoCircleImageView;
        private TextView nomeArtistaSalvoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemArtistaSalvoCircleImageView = itemView.findViewById(R.id.busca_img_artista);
            nomeArtistaSalvoTextView = itemView.findViewById(R.id.nome_lista_artistas_salvos_text_view);
        }
        public void setupArtistaSalvo(ArtistaSalvo artistaSalvo){
            nomeArtistaSalvoTextView.setText(artistaSalvo.getNomeArtistaSalvo());
            Picasso.get().load(artistaSalvo.getImagemArtistaSalvo()).into(imagemArtistaSalvoCircleImageView);
        }
    }
}
