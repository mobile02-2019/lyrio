package com.example.lyrio;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        try{
            numeroDoFragment = getIntent().getExtras().getInt("NUMERO");
        }catch (Exception e){
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


    }

    public void changeView(Integer pageNum){
        if(pageNum != null){
            viewPager.setCurrentItem(pageNum);
        }else{
            viewPager.setCurrentItem(1);
        }
    }



    //intent ir para registro
    private void irParaArtistas () {
        Intent intent = new Intent(this, ListaDeArtistasActivity.class);
        startActivity(intent);
    }
}
