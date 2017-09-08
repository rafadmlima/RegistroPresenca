package com.example.rafael.registropresenca.model;

/**
 * Created by RAFAEL on 23/07/2017.
 */

public class Produto {

    private long codigo;
    private String codbar;
    private int linha;
    private String marca;
    private String descricao;
    private double venda;
    private String fornec;
    private int sd_atu;


    public Produto(long codigo, String codbar, int linha, String marca, String descricao, double venda, String fornec, int sd_atu) {
        this.codigo = codigo;
        this.codbar = codbar;
        this.linha = linha;
        this.marca = marca;
        this.descricao = descricao;
        this.venda = venda;
        this.fornec = fornec;
        this.sd_atu = sd_atu;
    }

    public Produto() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCodbar() {
        return codbar;
    }

    public void setCodbar(String codbar) {
        this.codbar = codbar;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }

    public String getFornec() {
        return fornec;
    }

    public void setFornec(String fornec) {
        this.fornec = fornec;
    }

    public int getSd_atu() {
        return sd_atu;
    }

    public void setSd_atu(int sd_atu) {
        this.sd_atu = sd_atu;
    }
}
