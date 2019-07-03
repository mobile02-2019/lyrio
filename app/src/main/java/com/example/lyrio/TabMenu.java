package com.example.lyrio;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lyrio.Adapters.ViewPagerAdapter;


public class TabMenu extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Integer numeroDoFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab_menu);
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new com.example.lyrio.Fragments.FragmentHome(), "Home");
        adapter.AddFragment(new com.example.lyrio.Fragments.FragmentNoticias(), "Notícias");
        adapter.AddFragment(new com.example.lyrio.Fragments.FragmentBuscar(), "Buscar");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        try {
            numeroDoFragment = getIntent().getExtras().getInt("NUMERO");
        } catch (Exception e) {
            numeroDoFragment = null;
        }

        changeView(numeroDoFragment);


        final Button apertarButton = findViewById(R.id.artista_button_id);
        apertarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaArtistas();

            }
        });


        final Button apertarButton2 = findViewById(R.id.musica_button_id);
        apertarButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaMusicas();

            }
        });

    }

    public void changeView(Integer pageNum) {
        if (pageNum != null) {
            viewPager.setCurrentItem(pageNum);
        } else {
            viewPager.setCurrentItem(1);
        }
    }

    //intent ir para registro
    private void irParaArtistas () {
        Intent intent = new Intent(this, ListaDeArtistasActivity.class);
        startActivity(intent);
    }

    private void irParaMusicas () {
        Intent intent = new Intent(this, ListaAlbumActivity.class);
        startActivity(intent);
    }

}

