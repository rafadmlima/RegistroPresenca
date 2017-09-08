package com.example.rafael.registropresenca.model;

/**
 * Created by RAFAEL on 04/05/2017.
 */

public class Usuario {
//dados pessoais
    private static long codigo;
    private static String nome;
    private static long cpf;
    private  static long fone;
    private  static long cnpjEmpresa;
    private static String email;
//dados de localização
    private static long cep;
    private static String endereco;
    private static int numero;
    private static String bairro;
    private static String cidade;
    private static String UF;
    private static String[] latLng;
//dados de acesso
    private static String forma;
    private static String forma_titulo;
    private static String senha;
    private static String imei;
    private static long nivel;

    public Usuario() {
    }

    public Usuario(long codigo, String nome, long cpf, long fone, long cnpjEmpresa, String email, long cep, String endereco, int numero, String bairro, String cidade, String UF, String[] latLng, String forma, String forma_titulo, String senha, String imei, long nivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.cnpjEmpresa = cnpjEmpresa;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.latLng = latLng;
        this.forma = forma;
        this.forma_titulo = forma_titulo;
        this.senha = senha;
        this.imei = imei;
        this.nivel = nivel;
    }

    public Usuario(int anInt, String string, String string1, String string2, int anInt1) {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getFone() {
        return fone;
    }

    public void setFone(long fone) {
        this.fone = fone;
    }

    public long getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(long cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String[] getLatLng() {
        return latLng;
    }

    public void setLatLng(String[] latLng) {
        this.latLng = latLng;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getForma_titulo() {
        return forma_titulo;
    }

    public void setForma_titulo(String forma_titulo) {
        this.forma_titulo = forma_titulo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    //metodos
}