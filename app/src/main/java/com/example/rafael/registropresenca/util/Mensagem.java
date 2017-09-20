package com.example.rafael.registropresenca.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.example.rafael.registropresenca.R;

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

    public ProgressDialog  dialog(String titulo, String mensagem){
        this.dialog = new ProgressDialog(this.contexto);
        this.dialog.setTitle(titulo);
        this.dialog.setMessage(mensagem);
        this.dialog.show();
        return this.dialog;
    }

    public void alertDialog(Context contexto, String mensagem){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);

        //Titulo da janela
        builder.setTitle("Primeiro Acesso");
        //Conteudo da msg
        builder.setIcon(R.mipmap.ic_launcher)
                .setMessage(mensagem)
                .setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int wich){
                        toast("OK");
                    }
                })
                .setNegativeButton("CANCELAR",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int wich){
                        toast("CANCELAR");
                    }
                })
                .setCancelable(false);

        //cria o alertDialog a partir do builder
        AlertDialog alert = builder.create();
        alert.show();
        }


}


