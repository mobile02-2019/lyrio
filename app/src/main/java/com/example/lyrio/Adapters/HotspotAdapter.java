package com.example.lyrio.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lyrio.Login.LoginActivity;
import com.example.lyrio.Login.UserCadastroActivity;
import com.example.lyrio.Models.Hotspot;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.HotspotListener;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class HotspotAdapter extends RecyclerView.Adapter<HotspotAdapter.ViewHolder>{

    private List<Hotspot> listaDeHotspots;
    private HotspotListener hotspotListener;

    // Referencia criada para poder usar o Glide;
    private Context context;

    public HotspotAdapter(Context context, HotspotListener hotspotListener) {
        // Inicializar lista
        listaDeHotspots = new ArrayList<>();

        // Para usar o Glide;
        this.context = context;
        this.hotspotListener = hotspotListener;
    }

    public HotspotAdapter(List<Hotspot> listaDeHotspots){
        this.listaDeHotspots = listaDeHotspots;
    }

    @NonNull
    @Override
    public HotspotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_cardview, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotspotAdapter.ViewHolder viewHolder, int i) {
        final Hotspot hotspot = listaDeHotspots.get(i);
        viewHolder.setupHotspot(hotspot);

        // Setup do glide
        Glide.with(context)
                .load(hotspot.getPic_src())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.recyclerImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotspotListener.onHotspotClicado(hotspot);

//                Toast.makeText(context, hotspot.getLink(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDeHotspots.size();
    }

    public void adicionarListaHotspot(ArrayList<Hotspot> listaHotspot) {
        listaDeHotspots.addAll(listaHotspot);
        notifyDataSetChanged();
    }

    // Começar sempre por essa classe
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView recyclerArtista;
        private TextView recyclerChamada;
        private TextView recyclerTags;
        private TextView maisInfo;
        private ImageView recyclerImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerArtista = itemView.findViewById(R.id.recycler_nome_artista);
            recyclerChamada = itemView.findViewById(R.id.recycler_chamada);
            recyclerTags = itemView.findViewById(R.id.recycler_tags);
            maisInfo = itemView.findViewById(R.id.recycler_mais_info);
            recyclerImage = itemView.findViewById(R.id.recycler_image);
        }

        public void setupHotspot(Hotspot hotspot){
            recyclerArtista.setText(hotspot.getTitle());
            recyclerChamada.setText(hotspot.getDescr());
            recyclerTags.setText(hotspot.getDate_fmt());
        }
    }


}
