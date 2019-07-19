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
import com.example.lyrio.interfaces.MusicaSalvaListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MusicaSalvaAdapter extends RecyclerView.Adapter<MusicaSalvaAdapter.ViewHolder> {

    private List<MusicaSalva> listaMusicaSalva;
    private MusicaSalvaListener musicaSalvaListener;

    public MusicaSalvaAdapter(List<MusicaSalva> listaMusicaSalva, MusicaSalvaListener musicaSalvaListener) {
        this.listaMusicaSalva = listaMusicaSalva;
        this.musicaSalvaListener = musicaSalvaListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_musica_salva,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final MusicaSalva musicaSalva = listaMusicaSalva.get(i);
        viewHolder.setupMusicaSalva(musicaSalva);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicaSalvaListener.onMusicaSalvaClicado(musicaSalva);
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

            nomeMusicaSalvaTextView = itemView.findViewById(R.id.busca_campo_top);
            imagemMusicaSalvaImageView = itemView.findViewById(R.id.busca_img_artista);

        }
        public void setupMusicaSalva(MusicaSalva musicaSalva){
            nomeMusicaSalvaTextView.setText(musicaSalva.getNomeMusicaSalva());
            Picasso.get().load(musicaSalva.getImagemMusicaSalva()).into(imagemMusicaSalvaImageView);
        }
    }
}
