package com.larissa.tcc2024.model;

public enum Status {
    ANDAMENTO("andamento"),
    CONCLUIDO("concluido");

    private String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
