package com.example.lyrio.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lyrio.R;
import com.example.lyrio.model.Album;

import java.util.ArrayList;
import java.util.List;





    public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

        private List<Album> listaAlbum = new ArrayList<>();



        public AlbumAdapter(List<Album> listaAlbum) {
            this.listaAlbum = listaAlbum;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_componente, viewGroup, false);

            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            Album album = listaAlbum.get(i);
            viewHolder.setupAlbum(album);

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