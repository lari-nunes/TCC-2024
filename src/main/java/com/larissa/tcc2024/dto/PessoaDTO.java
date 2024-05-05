package com.larissa.tcc2024.dto;

import com.larissa.tcc2024.model.TipoPessoa;

import java.time.LocalDate;

public record PessoaDTO (
        TipoPessoa tp_pessoa,
        String nm_pessoa,
        String cpf,
        String telefone1,
        String login,
        String senha,
        String email,
        String descricao
){

    @Override
    public TipoPessoa tp_pessoa() {
        return tp_pessoa;
    }

    @Override
    public String nm_pessoa() {
        return nm_pessoa;
    }

    @Override
    public String cpf() {
        return cpf;
    }

    @Override
    public String telefone1() {
        return telefone1;
    }

    @Override
    public String login() {
        return login;
    }

    @Override
    public String senha() {
        return senha;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String descricao() {
        return descricao;
    }
}
