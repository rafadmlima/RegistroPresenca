package com.example.rafael.registropresenca.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.task.UsuarioThread;
import com.example.rafael.registropresenca.util.DadosUsuario;
import com.example.rafael.registropresenca.util.Local;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FuncActivity extends AppCompatActivity {
    UsuarioThread usuarioThread;
    SimpleDateFormat sdf;
    ProgressDialog dialog;
    Toolbar toolbar;
    ListView lista;
    TextView lblNomeFunc;
    public TextView lblTotalHoras;
    FloatingActionButton fab;
    private String operacao;
    private String status;
    private String coordenadas;
    private Local local;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_func);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponents();

    }

    public void initComponents() {

        this.setTitle("Registro de Ponto  -  " + dataOuHoraAtual("dd/MM/yyyy"));
        lista = (ListView) findViewById(R.id.lista_registro);
        lblNomeFunc = (TextView) findViewById(R.id.lblNomeFunc);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lblTotalHoras = (TextView) findViewById(R.id.lblTotalHoras);

        if (getIntent().getStringExtra("username") != null) {
            lblNomeFunc.setText(getIntent().getStringExtra("username").substring(0, 1).toUpperCase().concat(getIntent().getStringExtra("username").substring(1).toLowerCase()));
        }

        carregaRegistros();

        //lblTotalHoras.setText(lblTotalHoras.getText() + "  " + DadosUsuario.getTotalTrabalhado());
        if(local == null) {
            local = new Local(this);
        }
    }

    public void initDialog(String msg) {
        dialog = new ProgressDialog(this);
        dialog.setTitle("Aguarde!");
        dialog.setMessage(msg);
        dialog.show();
    }

    public void carregaRegistros() {

        initDialog("Processando...");
        usuarioThread = new UsuarioThread(this, dialog);
        usuarioThread.execute("S", String.valueOf(DadosUsuario.getUsuario().getCpf()), dataOuHoraAtual("dd/MM/yyyy"));

    }

    public String dataOuHoraAtual(String formato) {
        String data;
        sdf = new SimpleDateFormat(formato);
        data = sdf.format(new Date());
        return data;
    }

    public void registrarPonto(View view) {

        coordenadas = DadosUsuario.getCoordenadas();

        initDialog("Processando...");

        if (DadosUsuario.getUltOperacao().equals("")) {
            operacao = "S";
            status = "S";
        }
        if (DadosUsuario.getUltOperacao().equals("E")) {
            operacao = "S";
        } else if (DadosUsuario.getUltOperacao().equals("S")) {
            operacao = "E";
        }
        if (DadosUsuario.getUltStatus().equals("E")) {
            status = "S";
        } else if (DadosUsuario.getUltStatus().equals("S")) {
            status = "E";
        }

        usuarioThread = new UsuarioThread(this, dialog);
        //'$acao','tabela','$empresa', '$colaborador', '$data_reuniao, '$operacao', '$motivo', '$status', '$coordenadas'
        usuarioThread.execute("P",
                "registro",
                String.valueOf(DadosUsuario.getUsuario().getCnpjEmpresa()),
                String.valueOf(DadosUsuario.getUsuario().getCpf()),
                //dataOuHoraAtual("dd/MM/yyyy").replace("/","."),
                dataOuHoraAtual("dd/MM/yyyy").replace("/", "."),//data_reuniao
                operacao,
                "nenhum motivo",
                //dataOuHoraAtual("HH:mm:ss"),
                status,
                //dataOuHoraAtual("HH:mm:ss"),
                coordenadas);
    }
}
