package com.example.lyrio;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lyrio.Adapters.ViewPagerAdapter;
import com.example.lyrio.Fregments.FragmentBuscar;
import com.example.lyrio.Fregments.FragmentHome;
import com.example.lyrio.Fregments.FragmentNoticias;

public class TabMenu extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Integer numeroDoFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab_menu);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

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
    }

    public void changeView(Integer pageNum){
        if(pageNum != null){
            viewPager.setCurrentItem(pageNum);
        }else{
            viewPager.setCurrentItem(1);
        }
    }
}
