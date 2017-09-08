package com.example.rafael.registropresenca.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.model.Produto;
import com.example.rafael.registropresenca.task.ProdutoThread;

public class ConsultaActivity extends AppCompatActivity {
    EditText txtCodBar;
    Button btnAbrirEscanner;
    Button btnBuscaPreco;
    ProgressDialog dialog;
    public TextView lblPrecoProduto, lblDescricaoProduto;
    private String codBar = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        initiComponents();
    }

    public void initiComponents(){
        this.setTitle("Consulta de Preços");

        txtCodBar = (EditText) findViewById(R.id.txtCodBar);
        lblDescricaoProduto = (TextView) findViewById(R.id.lblDescricaoProduto);
        lblPrecoProduto = (TextView) findViewById(R.id.lblPrecoProduto);
        btnAbrirEscanner = (Button) findViewById(R.id.btnAbrirEscanner);
        btnBuscaPreco = (Button) findViewById(R.id.btnBuscarCodigo);

        if(getIntent().getStringExtra("leitura") != null){
            codBar = getIntent().getStringExtra("leitura");
            busca(codBar);
        }else{
            if((txtCodBar.getText() != null) && (txtCodBar.getText().length() > 0)){
                codBar = txtCodBar.getText().toString();
            }
        }
//        if(getIntent().getStringExtra("desc") != null){
//            lblDescricaoProduto.setText(getIntent().getStringExtra("desc"));
//        }
//        if(getIntent().getStringExtra("precov") != null){
//            lblPrecoProduto.setText("R$ " + getIntent().getStringExtra("precov"));
//        }

    }

    public void initDialog(String msg) {
        dialog = new ProgressDialog(this);
        dialog.setTitle("Aguarde!");
        dialog.setMessage(msg);
        dialog.show();
    }

    public void abrirEscanner(View view) {
        Intent intent = (new Intent(this, PromoterActivity.class));
        startActivity(intent);
    }

    public void buscarPreco(View view) {
        codBar = txtCodBar.getText().toString();
        if(!codBar.equals("")) {
            busca(codBar);
        }
//        }else{
//            txtCodBar.setBackgroundColor(Color.RED);
//        }
    }

    public void busca(String _codBar){
        initDialog("Buscando...");
        ProdutoThread thread = new ProdutoThread(this, dialog);
        thread.execute("PR", _codBar);
    }
}
