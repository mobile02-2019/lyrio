package com.example.lyrio;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lyrio.adapters.ViewPagerAdapter;
import com.example.lyrio.fragments.FragmentBuscar;
import com.example.lyrio.fragments.FragmentHome;
import com.example.lyrio.fragments.FragmentNoticias;


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
        adapter.AddFragment(new FragmentHome(), "Home");
        adapter.AddFragment(new FragmentNoticias(), "Notícias");
        adapter.AddFragment(new FragmentBuscar(), "Buscar");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        try {
            numeroDoFragment = getIntent().getExtras().getInt("NUMERO");
        } catch (Exception e) {
            numeroDoFragment = null;
        }

        changeView(numeroDoFragment);




        //DESATIVAR MENU DO TOPO

//        final Button apertarButton = findViewById(R.id.artista_button_id);
//        apertarButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                irParaArtistas();
//            }
//        });
//
//
//        final Button apertarButton2 = findViewById(R.id.musica_button_id);
//        apertarButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                irParaMusicas();
//
//            }
//        });

    }

    public void changeView(Integer pageNum) {
        if (pageNum != null) {
            viewPager.setCurrentItem(pageNum);
        } else {
            viewPager.setCurrentItem(1);
        }
    }

    //DESATIVAR MENU DO TOPO

//    //intent ir para registro
//    private void irParaArtistas () {
//        Intent intent = new Intent(this, ListaDeArtistasActivity.class);
//        startActivity(intent);
//    }
//
//    private void irParaMusicas () {
//        Intent intent = new Intent(this, ListaAlbumActivity.class);
//        startActivity(intent);
//    }

}

