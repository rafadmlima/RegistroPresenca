package com.example.rafael.registropresenca.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.task.ProdutoThread;
import com.example.rafael.registropresenca.util.Mensagem;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Locale;

public class PromoterActivity extends AppCompatActivity {
    private Activity activity;
    private Mensagem mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoter);
        activity = this;
        escanear();
    }

    public void escanear(){
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Enquadre o código no centro da tela.");
        integrator.setCameraId(0);
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                mensagem = new Mensagem(this);
                mensagem.toast("Escaneamento Cancelado!!!");
                finish();
            } else {
                System.out.println("**************LEITURA: " + result.getContents());
                Intent intent = (new Intent(this, ConsultaActivity.class));
                intent.putExtra("leitura", result.getContents());
                startActivity(intent);
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}

