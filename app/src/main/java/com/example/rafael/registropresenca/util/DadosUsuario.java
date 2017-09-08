package com.example.rafael.registropresenca.util;

import android.icu.util.Calendar;

import com. example.rafael.registropresenca.model.Usuario;

import java.io.DataOutput;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Rafael on 06/09/2016.
 */
public class DadosUsuario {
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


    public static String ultOperacao;
    public static String ultStatus;
    public static String totalTrabalhado;
    public static String coordenadas;

    public static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuarioCorrente(Usuario usuarioCorrente) {
        DadosUsuario.usuario = usuarioCorrente;
        DadosUsuario.codigo = usuarioCorrente.getCodigo();
        DadosUsuario.nome   = usuarioCorrente.getNome();
        DadosUsuario.cpf = usuarioCorrente.getCpf();
        DadosUsuario.fone = usuarioCorrente.getFone();
        DadosUsuario.cnpjEmpresa = usuarioCorrente.getCnpjEmpresa();
        DadosUsuario.email  = usuarioCorrente.getEmail();
        DadosUsuario.cep = usuarioCorrente.getCep();
        DadosUsuario.endereco = usuarioCorrente.getEndereco();
        DadosUsuario.numero = usuarioCorrente.getNumero();
        DadosUsuario.bairro = usuarioCorrente.getBairro();
        DadosUsuario.cidade = usuarioCorrente.getCidade();
        DadosUsuario.UF = usuarioCorrente.getUF();
        DadosUsuario.forma = usuarioCorrente.getForma();
        DadosUsuario.forma_titulo = usuarioCorrente.getForma_titulo();
        DadosUsuario.senha  = usuarioCorrente.getSenha();
        DadosUsuario.imei = usuarioCorrente.getImei();


//        DadosUsuario.imagem   = usuarioCorrente.getImagem();
    }

    public static String getUltOperacao() {
        return ultOperacao;
    }

    public static void setUltOperacao(String ultOperacao) { DadosUsuario.ultOperacao = ultOperacao; }

    public static String getUltStatus() {
        return ultStatus;
    }

    public static void setUltStatus(String ultStatus) {
        DadosUsuario.ultStatus = ultStatus;
    }

    public static String getTotalTrabalhado() { return totalTrabalhado; }

    public static void setTotalTrabalhado(String totalTrabalhado) { DadosUsuario.totalTrabalhado = totalTrabalhado; }

    public static String getCoordenadas() {
        return coordenadas;
    }

    public static void setCoordenadas(String coordenadas) {
        DadosUsuario.coordenadas = coordenadas;
    }
}
