package com.example.rafael.registropresenca.control;

import android.content.Context;

import com.example.rafael.registropresenca.dao.UsuarioDao;
import com.example.rafael.registropresenca.model.Usuario;
import com.example.rafael.registropresenca.view.LoginActivity;

/**
 * Created by RAFAEL on 16/08/2017.
 */

public class UsuarioControle {
    private Usuario usuario = null;
    private Context contexto;
    UsuarioDao dao;

    public UsuarioControle(){}

    public UsuarioControle(Context contexto) {
        if(this.usuario == null){
            this.usuario = new Usuario();
            this.contexto = contexto;
        }
    }

    public long inserir(String codigo, String nome){

        this.usuario.setCodigo(Long.parseLong(codigo));
        this.usuario.setNome(nome);
        dao = new UsuarioDao(contexto);
        return dao.inserir(this.usuario);

    }

    public boolean login(Context context, long codigo, String nome){

        this.usuario.setCodigo(codigo);
        this.usuario.setNome(nome);

        dao = new UsuarioDao(context);
        return  dao.login(usuario);

    }

}
