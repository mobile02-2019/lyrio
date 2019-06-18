package com.example.lyrio;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button confirmarButton = findViewById(R.id.botaoLogin);
        confirmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoClicado(view);

            }
        });

        usernameEditText= findViewById(R.id.emailDigitado);
        passwordEditText = findViewById(R.id.senhaLogin);

        TextView registro = findViewById(R.id.registreSe);
        Button buttonFacebook = findViewById(R.id.botaoLoginFacebook);
        Button registreComGoogle = findViewById(R.id.botaoLoginGoogle);
        TextView esqueceuSenha = findViewById(R.id.esqueceuSenha);


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaRegistro();
            }
        });

       esqueceuSenha.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               esqueceuSenha();
           }
       });

    }

    public void botaoClicado(View view){

        usernameEditText.setError(null);
        passwordEditText.setError(null);

        if (usernameEditText.getEditableText().toString().equals("")){
            usernameEditText.setError("Informe seu email");
        }else if (!usernameEditText.getEditableText().toString().matches(emailRegex)) {
            usernameEditText.setError("O email deve conter @ e .");
        }else if (passwordEditText.getEditableText().toString().equals("")){
            passwordEditText.setError("Informe sua senha");
        } else if (!senhaValida(passwordEditText.getEditableText().toString())){
            passwordEditText.setError("senha deve ter entre 6 e 14 caracteres");
        }
        else{
            Intent intent = new Intent(this, TabMenu.class);

            startActivity(intent);
        }

    }

    // confirmar se o formato da senha é valido
    private boolean senhaValida(String senha) {
        senha = senha.trim();
        return senha.length() >= 6 && senha.length() < 14 && textPattern.matcher(senha).matches();

    }

    private void irParaRegistro () {
        Intent intent = new Intent(this, UserCadastroActivity.class);
        startActivity(intent);
    }


    // ir para esqueci a minha senha
    private void esqueceuSenha (){
        Intent intent = new Intent(this, UserEsqueciMinhaSenha.class);
        startActivity(intent);

    }

}


