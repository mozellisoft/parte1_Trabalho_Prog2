package com.example.model;

import java.util.Date;

public class Consulta {
    private int id;
    private int idMedico;
    private int idPaciente;
    private Date data;
    private String observacoes;

    public Consulta() {
    }

    public Consulta(int id, int idMedico, int idPaciente, Date data, String observacoes) {
        this.id = id;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.data = data;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", idMedico=" + idMedico +
                ", idPaciente=" + idPaciente +
                ", data=" + data +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
} 