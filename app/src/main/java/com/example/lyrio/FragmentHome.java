package com.example.lyrio;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

//    private Button buttonIrParaEsqueciMinhaSenha;


    public FragmentHome() {
        // Required empty public constructor
    }

    private String gotMail;
    private TextView userName;
    private TextView userStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        Button buttonIrEsqueciMinhaSenha = view.findViewById(R.id.button_ir_esqueci_minha_senha);
        buttonIrEsqueciMinhaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserEsqueciMinhaSenha.class);
                startActivity(intent);
            }
        });

        userName = view.findViewById(R.id.txtUserName);
        userStatus = view.findViewById(R.id.txtUserStatus);

        try{
            gotMail = getActivity().getIntent().getExtras().getString("EMAIL");
        }catch (Exception e){
            gotMail = null;
        }

        if(gotMail != null){
            userName.setText(gotMail);
            userStatus.setText("Notificações ativas");
        }else{
            userName.setText("Faça seu login");
            userStatus.setText("Sem notificações");
        }

        return view;

    }

}
