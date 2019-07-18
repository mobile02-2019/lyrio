package com.example.lyrio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrio.Models.MusicaSalva;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ListaMusicasSalvasListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaMusicasSalvasAdapter extends RecyclerView.Adapter<ListaMusicasSalvasAdapter.ViewHolder> {

    private List<MusicaSalva> listaMusicaSalva;
    private ListaMusicasSalvasListener listaMusicasSalvasListener;

    public ListaMusicasSalvasAdapter(List<MusicaSalva> listaMusicaSalva, ListaMusicasSalvasListener listaMusicasSalvasListener) {
        this.listaMusicaSalva = listaMusicaSalva;
        this.listaMusicasSalvasListener = listaMusicasSalvasListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_lista_musica_salva,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final MusicaSalva musicaSalva = listaMusicaSalva.get(i);
        viewHolder.setupListaMusicaSalva(musicaSalva);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaMusicasSalvasListener.onListaMusicasSalvasClicado(musicaSalva);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaMusicaSalva.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagemMusicaSalvaImageView;
        private TextView nomeMusicaSalvaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemMusicaSalvaImageView = itemView.findViewById(R.id.imagem_lista_artista_salvos_circle_image_view_id);
            nomeMusicaSalvaTextView=itemView.findViewById(R.id.nome_musica_salva_text_view);

        }
        public void setupListaMusicaSalva(MusicaSalva musicaSalva){
            nomeMusicaSalvaTextView.setText(musicaSalva.getNomeMusicaSalva());
            Picasso.get().load(musicaSalva.getImagemMusicaSalva()).into(imagemMusicaSalvaImageView);
        }
    }
}
