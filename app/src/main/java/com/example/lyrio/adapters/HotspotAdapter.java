package com.example.lyrio.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lyrio.models.Hotspot;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.HotspotListener;
import com.example.lyrio.util.Constantes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celula_hotspot_noticia, viewGroup, false);
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

        private ToggleButton favourite_toggle;
        private TextView recyclerArtista;
        private TextView recyclerChamada;
        private TextView recyclerTags;
        private TextView maisInfo;
        private ImageView recyclerImage;
        private CircleImageView hotCircleArtist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerArtista = itemView.findViewById(R.id.recycler_nome_artista);
            recyclerChamada = itemView.findViewById(R.id.recycler_chamada);
            recyclerTags = itemView.findViewById(R.id.recycler_tags);
            maisInfo = itemView.findViewById(R.id.hotspot_abrir_link);
            recyclerImage = itemView.findViewById(R.id.recycler_image);
            hotCircleArtist = itemView.findViewById(R.id.hotspot_artist_circle_image_view);
            favourite_toggle = itemView.findViewById(R.id.letras_favorito_button);
        }

        public void setupHotspot(Hotspot hotspot){
            final Hotspot hots = hotspot;
            String artistPic = "";

            recyclerArtista.setText(hotspot.getTitle());
            recyclerArtista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            recyclerChamada.setText(hotspot.getDescr());
            recyclerTags.setText(hotspot.getDate_fmt());
            if(hotspot.getArtUrl()!=null){
                Picasso.get().load("https://www.vagalume.com.br/"+hotspot.getArtUrl()+"/images/profile.jpg").into(hotCircleArtist);
            }

            maisInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hotspotListener.onHotspotClicado(hots);
                }
            });

            favourite_toggle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(favourite_toggle.isChecked()){
                        Toast.makeText(context, Constantes.TOAST_NOTICIA_FAVORITA_ADICIONAR, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, Constantes.TOAST_NOTICIA_FAVORITA_EXCLUIR, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}