package com.example.lyrio.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrio.api.BaseVagalume.ApiArtista;
import com.example.lyrio.models.Musica;
import com.example.lyrio.models.MusicaSalva;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.MusicaSalvaListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MusicaSalvaAdapter extends RecyclerView.Adapter<MusicaSalvaAdapter.ViewHolder> {

    private List<Musica> listaMusicaSalva;
    private MusicaSalvaListener musicaSalvaListener;

    public MusicaSalvaAdapter(MusicaSalvaListener musicaSalvaListener) {
        this.listaMusicaSalva = new ArrayList<>();
        this.musicaSalvaListener = musicaSalvaListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_circle_image_vertical,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Musica musicaSalva = listaMusicaSalva.get(i);
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

    public void adicionarMusica(Musica musicaSalva){
        listaMusicaSalva.add(musicaSalva);
        notifyDataSetChanged();
    }

    public void adicionarListaDeMusicas(List<Musica> listaDeMusicas) {
        listaMusicaSalva.addAll(listaDeMusicas);
        notifyDataSetChanged();
    }

    public void removerTudo(){
        while(listaMusicaSalva.size()>0){
            listaMusicaSalva.remove(0);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagemMusicaSalvaImageView;
        private TextView nomeMusicaSalvaTextView;
        private TextView campoBottomText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeMusicaSalvaTextView = itemView.findViewById(R.id.celula_circle_campo_topo);
            imagemMusicaSalvaImageView = itemView.findViewById(R.id.celula_circle_image_view);
            campoBottomText = itemView.findViewById(R.id.celula_circle_campo_bottom);

        }
        public void setupMusicaSalva(Musica musicaSalva){
            nomeMusicaSalvaTextView.setText(musicaSalva.getName());
            campoBottomText.setText(musicaSalva.getArtista().getName());
            Picasso.get().load(musicaSalva.getAlbumPic()).into(imagemMusicaSalvaImageView);
        }
    }
}
