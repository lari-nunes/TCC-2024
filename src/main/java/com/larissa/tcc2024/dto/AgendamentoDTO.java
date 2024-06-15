package com.larissa.tcc2024.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AgendamentoDTO {
    
    private UUID id_limpador;
    private UUID id_agenda;
    private LocalDateTime dataAgendamento;
    private String nm_pessoa;
    private String nm_municipio;
    private String rua;
    private String bairro;
    private String numero;

    public AgendamentoDTO(UUID id_agenda, UUID id_limpador, LocalDateTime dataAgendamento, String nm_pessoa, String nm_municipio, String rua, String bairro, String numero) {
        this.id_agenda = id_agenda;
        this.id_limpador = id_limpador;
        this.dataAgendamento = dataAgendamento;
        this.nm_pessoa = nm_pessoa;
        this.nm_municipio = nm_municipio;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public UUID getId_agenda() {
        return id_agenda;
    }

    public UUID getId_limpador() {
        return id_limpador;
    }

    public void setId_limpador(UUID id_limpador) {
        this.id_limpador = id_limpador;
    }

    public void setId_agenda(UUID id_agenda) {
        this.id_agenda = id_agenda;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getNm_pessoa() {
        return nm_pessoa;
    }

    public void setNm_pessoa(String nm_pessoa) {
        this.nm_pessoa = nm_pessoa;
    }

    public String getNm_municipio() {
        return nm_municipio;
    }

    public void setNm_municipio(String nm_municipio) {
        this.nm_municipio = nm_municipio;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
