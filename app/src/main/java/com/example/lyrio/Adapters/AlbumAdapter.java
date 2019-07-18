package com.example.lyrio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.lyrio.R;
import com.example.lyrio.Models.Album;
import com.example.lyrio.interfaces.AlbumListener;

import java.util.ArrayList;
import java.util.List;





    public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

        private List<Album> listaAlbum;
        private AlbumListener albumListener;


        public AlbumAdapter(List<Album> listaAlbum, AlbumListener albumListener) {
            this.listaAlbum = listaAlbum;
            this.albumListener = albumListener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_componente, viewGroup, false);

            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final Album album = listaAlbum.get(i);
            viewHolder.setupAlbum(album);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    albumListener.onAlbumClicado(album);
                }
            });

        }

        @Override
        public int getItemCount() {
            return listaAlbum.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            private ImageView albumImageView;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                albumImageView = itemView.findViewById(R.id.imagem_album_id);

            }

            public void setupAlbum(Album album) {
                //TODO FAZER SETUP DOS DADOS NO XML


            }
        }


    }