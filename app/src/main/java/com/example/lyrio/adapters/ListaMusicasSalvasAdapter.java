package com.example.lyrio.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrio.api.base_vagalume.ApiArtista;
import com.example.lyrio.models.Musica;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ListaMusicasSalvasListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaMusicasSalvasAdapter extends RecyclerView.Adapter<ListaMusicasSalvasAdapter.ViewHolder> {

    private List<Musica> listaMusicaSalva;
    private ListaMusicasSalvasListener listaMusicasSalvasListener;
    private ApiArtista apiArtista;

    public ListaMusicasSalvasAdapter(List<Musica> listaMusicaSalva, ListaMusicasSalvasListener listaMusicasSalvasListener, ApiArtista apiArtista) {
        this.listaMusicaSalva = listaMusicaSalva;
        this.listaMusicasSalvasListener = listaMusicasSalvasListener;
        this.apiArtista = apiArtista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_lista_musica_salva,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Musica musicaSalva = listaMusicaSalva.get(i);
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
        private TextView buscaCampoBottom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemMusicaSalvaImageView = itemView.findViewById(R.id.busca_img_artista);
            nomeMusicaSalvaTextView=itemView.findViewById(R.id.busca_campo_top);
            buscaCampoBottom=itemView.findViewById(R.id.busca_campo_bottom);

        }
        public void setupListaMusicaSalva(Musica musicaSalva){
            buscaCampoBottom.setText(apiArtista.getDesc());
            nomeMusicaSalvaTextView.setText(musicaSalva.getDesc());
            Picasso.get().load(musicaSalva.getAlbumPic()).into(imagemMusicaSalvaImageView);
        }
    }
}
