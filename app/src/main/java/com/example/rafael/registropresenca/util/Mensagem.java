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

    public ProgressDialog dialog(String titulo, String mensagem){
        this.dialog = new ProgressDialog(this.contexto);
        this.dialog.setTitle(titulo);
        this.dialog.setMessage(mensagem);
        this.dialog.show();
        return this.dialog;
    }

    public void alertDialog(Context contexto, String mensagem){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(contexto);

        //Titulo da janela
        builder.setTitle("Opções de Imagem do Perfil");
        //Conteudo da msg
        builder.setMessage("Para adicionar uma imagem no seu perfil\n basta escolher uma das opções abaixo!");

        builder.setPositiveButton("Ok",botaoOk());
        builder.setNegativeButton("Cancelar",botaoCancelar());

        //cria o alertDialog a partir do builder
        android.app.AlertDialog alert = builder.create();
        alert.show();
        }

    private DialogInterface.OnClickListener botaoCancelar() {
        return null;
    }

    private DialogInterface.OnClickListener botaoOk() {
        return null;
    }
}

}
