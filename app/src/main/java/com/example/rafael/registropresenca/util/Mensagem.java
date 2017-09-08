package com.example.rafael.registropresenca.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by RAFAEL on 28/04/2017.
 */

public class Mensagem {
    //private String mensagem;
    private Context contexto;
    private ProgressDialog dialog;

    public Mensagem(Context contexto) {
        this.contexto = contexto;
    }


    public void toast(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();
    }

    public ProgressDialog dialog(String titulo, String mensagem){
        this.dialog = new ProgressDialog(this.contexto);
        this.dialog.setTitle(titulo);
        this.dialog.setMessage(mensagem);
        this.dialog.show();
        return this.dialog;
    }

}
