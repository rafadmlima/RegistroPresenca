package com.example.rafael.registropresenca.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.task.UsuarioThread;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistroActivity extends AppCompatActivity {
    CircleImageView imgUser;
    TextView lblNomeUser;
    Button btnPresente;
    Button btnAusente;
    UsuarioThread thread;
    ProgressDialog dialog;
    FloatingActionButton fabMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponents();

    }

    public void initComponents(){

        imgUser = (CircleImageView) findViewById(R.id.imgUser);
        lblNomeUser = (TextView) findViewById(R.id.lblNomeUser);
        btnPresente = (Button) findViewById(R.id.btnPresente);
        btnAusente = (Button) findViewById(R.id.btnAusente);
        fabMaps = (FloatingActionButton) findViewById(R.id.fabMaps);





        if (getIntent().getStringExtra("username") != null){
            lblNomeUser.setText(getIntent().getStringExtra("username").toString().toUpperCase());
        }


        btnAusente.setOnClickListener(registrarAusencia());
        fabMaps.setOnClickListener(verMapa());

    }

    private View.OnClickListener verMapa() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroActivity.this, MapaActivity.class));
            }
        };
    }


    public void setDialog(String msg){
        dialog = new ProgressDialog(this);
        dialog.setTitle("Aguarde");
        dialog.setMessage(msg);
        dialog.show();
    }
    private View.OnClickListener registrarAusencia() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setDialog("Processando");
//                thread = new UsuarioThread(RegistroActivity.this, dialog);
//                // params = new String[] {"acao", "tabela" ,"empresa", "colaborador", "operacao", "motivo", "coordenada"};
//                thread.execute("P","registro",  UsuarioCorrente.usuario.getCnpjEmpresa(),
//                                                UsuarioCorrente.usuario.getCpf(),
//                                                "F",);
            }
        };
    }

    public void registrarPresenca(View view) {
        setDialog("Processando");
        thread = new UsuarioThread(RegistroActivity.this, dialog);
        // params = new String[] {"acao", "tabela" ,"empresa", "colaborador", "operacao", "motivo", "coordenada"};
        thread.execute("P","registro","5502202400133", "30387399879","E", "teste");
    }
}
