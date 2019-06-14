package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class UserEsqueciMinhaSenha extends AppCompatActivity {

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

    private String gotEmail = "thiferas@gmail.com";
    private String gotSenha = "P1poca";

    private Button buttonSalvar;
    private Button buttonCancelar;
    private TextView userEmail;
    private TextView userSenha;
    private TextView userConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_esqueci_minha_senha);

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        gotEmail = bundle.getString("EMAIL");
//        gotSenha = bundle.getString("SENHA");

        buttonSalvar = findViewById(R.id.button_user_esqueci_salvar);
        buttonCancelar = findViewById(R.id.button_user_esqueci_cancelar);
        userEmail = findViewById(R.id.user_esqueci_email);
        userSenha = findViewById(R.id.user_esqueci_senha);
        userConfirmarSenha = findViewById(R.id.user_esqueci_confirmar_senha);
        
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarDados();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelarTudo();
            }
        });

    }

    private void cancelarTudo() {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    private void confirmarDados() {
        userEmail.setError(null);
        userSenha.setError(null);
        userConfirmarSenha.setError(null);

        String emailDigitado = userEmail.getEditableText().toString();
        String senhaDigitada = userSenha.getEditableText().toString();
        String senhaConfirmada = userConfirmarSenha.getEditableText().toString();

        if(emailDigitado.equals(gotEmail)){
            if(senhaValida(senhaDigitada)&&senhaValida(senhaConfirmada)){
                if(senhaDigitada.equals(senhaConfirmada)&&!senhaDigitada.equals(gotSenha)){
                    Intent intent = new Intent(this, SplashActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("EMAIL", emailDigitado);
                    bundle.putString("SENHA", senhaDigitada);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    if(senhaDigitada.equals(gotSenha)){
                        userSenha.setError("Senha utilizada anteriormente");
                    }else{
                        userSenha.setError("As senhas não correspondem");
                        userConfirmarSenha.setError("As senhas não correspondem");
                    }
                }
            }else{
                userSenha.setError("As senhas devem conter números, letras maiúsculas e minúsculas");
                userConfirmarSenha.setError("As senhas devem conter números, letras maiúsculas e minúsculas");
            }
        }else{
            userEmail.setError("Usuário não encontrado");
        }
    }

    private boolean senhaValida(String senha){
        senha = senha.trim();
        return senha.length()>=6&&senha.length()<14&&textPattern.matcher(senha).matches();
    }
}
