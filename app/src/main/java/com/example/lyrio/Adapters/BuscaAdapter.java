package com.example.lyrio.Adapters;

import android.content.Context;
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
import com.example.lyrio.Api.BaseVagalume.ApiItem;
import com.example.lyrio.R;
import com.example.lyrio.interfaces.ApiBuscaListener;

import java.util.ArrayList;
import java.util.List;

public class BuscaAdapter extends RecyclerView.Adapter<BuscaAdapter.ViewHolder>{

    private List<ApiItem> listaDeApiItems;
    private ApiBuscaListener apiBuscaListener;
    private Context context;

    public BuscaAdapter(Context context, ApiBuscaListener apiBuscaListener){
        //Inicializar lista
        listaDeApiItems = new ArrayList<>();

        //Para usar o Glide
        this.context = context;
        this.apiBuscaListener = apiBuscaListener;
    }

    public BuscaAdapter(List<ApiItem> listaDeApiItems){
        this.listaDeApiItems = listaDeApiItems;
    }

    @NonNull
    @Override
    public BuscaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.busca_resultados, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuscaAdapter.ViewHolder viewHolder, int i) {
        final ApiItem apiItem = listaDeApiItems.get(i);
        viewHolder.setupApiItem(apiItem);

        String bandName = apiItem.getUrl();
        String[] bandSplit = bandName.split("/");
        bandName = bandSplit[1];

        // Setup do glide
        Glide.with(context)
                .load("https://www.vagalume.com.br/"+bandName+"/images/profile.jpg")
                .placeholder(R.drawable.ic_account_circle_black_24dp)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.buscaImgArtista);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiBuscaListener.onApiBuscarClicado(apiItem);
//                Toast.makeText(context, "ARTISTA: "+apiItem.getBand(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeApiItems.size();
    }

    public void adicionarListaDeApiItems(ArrayList<ApiItem> listaApiIt) {
        listaDeApiItems.addAll(listaApiIt);
        notifyDataSetChanged();
    }

    public void removerTudo() {
        while(listaDeApiItems.size()>0){
            listaDeApiItems.remove(0);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView buscaCampoTop;
        private TextView buscaCampoBottom;
        private ImageView buscaImgArtista;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buscaCampoTop = itemView.findViewById(R.id.busca_campo_top);
            buscaCampoBottom = itemView.findViewById(R.id.busca_campo_bottom);
            buscaImgArtista = itemView.findViewById(R.id.busca_img_artista);
        }

        public void setupApiItem(ApiItem apiItem){
            buscaCampoTop.setText(apiItem.getCampoTop());
            buscaCampoBottom.setText(apiItem.getCampoBottom());
        }
    }

}
