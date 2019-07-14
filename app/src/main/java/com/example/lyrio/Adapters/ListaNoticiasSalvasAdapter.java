package com.example.lyrio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrio.Models.NoticiaSalva;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ListaNoticiasSalvasListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaNoticiasSalvasAdapter extends RecyclerView.Adapter<ListaNoticiasSalvasAdapter.ViewHolder> {
    private List<NoticiaSalva> listaNoticiasSalvas;
    private ListaNoticiasSalvasListener listaNoticiasSalvasListener;

    public ListaNoticiasSalvasAdapter(List<NoticiaSalva> listaNoticiasSalvas, ListaNoticiasSalvasListener listaNoticiasSalvasListener) {
        this.listaNoticiasSalvas = listaNoticiasSalvas;
        this.listaNoticiasSalvasListener = listaNoticiasSalvasListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_lista_noticia_salva,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final NoticiaSalva noticiaSalva = new NoticiaSalva();
        viewHolder.setupNoticiaSalva(noticiaSalva);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaNoticiasSalvasListener.onListaNoticiasSalvasClicado(noticiaSalva);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaNoticiasSalvas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagemNoticiaSalvaImageView;
        private TextView tituloNoticiaSalvaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemNoticiaSalvaImageView = itemView.findViewById(R.id.imagem_lista_noticia_salva_image_view);
            tituloNoticiaSalvaTextView = itemView.findViewById(R.id.titulo_lista_noticia_salva_text_view);
        }
        public void setupNoticiaSalva(NoticiaSalva noticiaSalva){
            tituloNoticiaSalvaTextView.setText(noticiaSalva.getTituloNoticiaSalva());
            Picasso.get().load(noticiaSalva.getImagemNoticiaSalva()).into(imagemNoticiaSalvaImageView);
        }
    }
}
