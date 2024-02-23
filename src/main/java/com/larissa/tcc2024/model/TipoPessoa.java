package com.larissa.tcc2024.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum TipoPessoa {
    USUARIO("usuario"),
    CLIENTE("cliente");

    private String tipoPessoa;

    TipoPessoa(String tipoPessoa){
        this.tipoPessoa = tipoPessoa;
    }

    public String getTipoPessoa(){
        return tipoPessoa;
    }
}
