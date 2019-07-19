package com.example.lyrio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lyrio.Fragments.FragmentHome;
import com.example.lyrio.Login.LoginActivity;

public class ConfiguracoesActivity extends AppCompatActivity {

    private ImageView setaVoltar;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        setaVoltar = findViewById(R.id.voltar_imageView);
        logoutButton = findViewById(R.id.logout_button);

        setaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaHome();
            }
        });


//        logoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog.Builder alert = new AlertDialog.Builder(this)
//                        .setTitle("ATENÇÃO")
//                        .setMessage("Deseja realmente fazer LogOut no APP?")
//                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                fecharApp();
//                            }
//                        })
//                        .setNegativeButton("NÂO", null);
//                alert.create();
//                alert.show();
//            }
//        });
    }

    private void fecharApp() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }

    private void voltarParaHome() {
        Intent intent = new Intent(this, TabMenu.class);
        Bundle bundle = new Bundle();
        bundle.putInt("NUMERO", 0);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
