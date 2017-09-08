package com.example.rafael.registropresenca.model;



import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by RAFAEL on 20/05/2017.
 */

public class Registro {
/* ID
    EMPRESA
    COLABORADOR
    DATA
    DATA_REUNIAO
    OPERACAO
    MOTIVO
    HORA
    STATUS
    TRABALHADO    */

    private long id;
    private long empresa;
    private long colaborador;
    private String data;
    private String data_reuniao;
    private String operacao;
    private String motivo;
    private String horario;
    private String status;
    private String trabalhado;
    private String coordenadas;
    private String ttTrabalhado;

    public Registro() {
    }

    public Registro(long id, long empresa, long colaborador, String data, String data_reuniao, String operacao, String motivo, String horario, String status, String trabalhado, String coordenadas, String ttTrabalhado) {
        this.id = id;
        this.empresa = empresa;
        this.colaborador = colaborador;
        this.data = data;
        this.data_reuniao = data_reuniao;
        this.operacao = operacao;
        this.motivo = motivo;
        this.horario = horario;
        this.status = status;
        this.trabalhado = trabalhado;
        this.coordenadas = coordenadas;
        this.ttTrabalhado = ttTrabalhado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(long empresa) {
        this.empresa = empresa;
    }

    public long getColaborador() {
        return colaborador;
    }

    public void setColaborador(long colaborador) {
        this.colaborador = colaborador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData_reuniao() {
        return data_reuniao;
    }

    public void setData_reuniao(String data_reuniao) {
        this.data_reuniao = data_reuniao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrabalhado() {
        return trabalhado;
    }

    public void setTrabalhado(String trabalhado) {
        this.trabalhado = trabalhado;
    }

    public String getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getTtTrabalhado() {
        return ttTrabalhado;
    }

    public void setTtTrabalhado(String ttTrabalhado) {
        this.ttTrabalhado = ttTrabalhado;
    }
}
