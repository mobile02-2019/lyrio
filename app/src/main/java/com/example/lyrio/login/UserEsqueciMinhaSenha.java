package com.example.lyrio.login;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lyrio.R;
import com.example.lyrio.TabMenu;

import java.util.regex.Pattern;

public class UserEsqueciMinhaSenha extends AppCompatActivity {

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private String mailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    private String gotEmail = "usuario@gmail.com";
    private String gotSenha = "P1poca";

    private Button buttonSalvar;
    private Button buttonCancelar;
    private TextView userEmail;
    private TextView userSenha;
    private TextView userConfirmarSenha;
    private TextView viewTopText;

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
        viewTopText = findViewById(R.id.txtTop);
        
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewTopText.setText("nao testado");
                confirmarDados();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });

    }

    private void cancelar() {
        Intent intent = new Intent(this, TabMenu.class);
        Bundle bundle = new Bundle();
        bundle.putInt("NUMERO", 0);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Validar se o usuário digitou um email existente e uma nova senha, enviando esses dados para a tela tabMenu
    private void confirmarDados() {
        boolean validMail = false;
        boolean validSenha = false;

        String emailDigitado = userEmail.getEditableText().toString();
        String senhaDigitada = userSenha.getEditableText().toString();
        String senhaConfirmada = userConfirmarSenha.getEditableText().toString();

        userEmail.setError(null);
        userSenha.setError(null);
        userConfirmarSenha.setError(null);

        //Conferir se o email é válido
        if(emailValido(emailDigitado)){
            if(emailDigitado.equals(gotEmail)){
                validMail = true;
            }else{
                userEmail.setError("Usuário não encontrado");
            }
        }else{
            userEmail.setError("Digite um e-mail válido");
        }

        if(senhaDigitada.trim().length()>0){
            if(senhaConfirmada.trim().length()>0){
                if(senhaValida(senhaDigitada)&&senhaValida(senhaConfirmada)){
                    if(senhaDigitada.equals(senhaConfirmada)&&!senhaDigitada.equals(gotSenha)){
                        validSenha = true;
                    }else{
                        if(senhaDigitada.equals(gotSenha)){
                            userSenha.setError("Senha utilizada anteriormente. Escolha uma nova senha");
                            userSenha.setError("Senha utilizada anteriormente. Escolha uma nova senha");
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
                userConfirmarSenha.setError("Você deve preencher este espaço");
            }
        }else{
            userSenha.setError("Você deve preencher este espaço");
        }

        if(validMail&&validSenha){
            enviarDados(emailDigitado, senhaDigitada);
        }
    }

    // Conferir se a senha tem letras maiúsculas, minúsculas e números.
    private boolean senhaValida(String senha){
        senha = senha.trim();
        return senha.length()>=6&&senha.length()<14&&textPattern.matcher(senha).matches();
    }

    // Conferir se o email tem um "@" e no mínimo um "." depois do arroba.
    private boolean emailValido(String mail){
        return mail.matches(mailRegex);
    }

    // Chama o activity "TabMenu" e envia os dados do email e senha do usuário.
    private void enviarDados(String emailDigitado, String senhaDigitada){
        Intent intent = new Intent(this, TabMenu.class);
        Bundle bundle = new Bundle();
        bundle.putString("EMAIL", emailDigitado);
        bundle.putString("SENHA", senhaDigitada);
        bundle.putInt("NUMERO", 0);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
