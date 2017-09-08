package com.example.rafael.registropresenca.util;

import com.example.rafael.registropresenca.model.Usuario;

/**
 * Created by RAFAEL on 19/05/2017.
 */

public class UsuarioCorrente {
    //dados pessoais
    public static long codigo;
    public static String nome;
    public static long cpf;
    public static long fone;
    public static long cnpjEmpresa;
    public static String email;
    //dados de localização
    public static long cep;
    public static String endereco;
    public static int numero;
    public static String bairro;
    public static String cidade;
    public static String UF;
    public static String[] latLng;
    //dados de acesso
    public static String forma;
    public static String forma_titulo;
    public static String senha;
    public static String imei;
    public static long nivel;

    public static Usuario usuario;


    public UsuarioCorrente() {
    }


    public static void setUsuarioCorrente(Usuario userCurrent) {
        UsuarioCorrente.usuario = userCurrent;
    }

    public static Usuario getUsuarioCorrente() {
        return usuario;
    }

}
