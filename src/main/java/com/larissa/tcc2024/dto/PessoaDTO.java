package com.larissa.tcc2024.dto;

import com.larissa.tcc2024.model.TipoPessoa;

import java.time.LocalDate;

public record PessoaDTO (
        TipoPessoa tp_pessoa,
        String nm_pessoa,
        String cpf,
        Boolean in_excluido,
        LocalDate dt_nascimento,
        String telefone1,
        String telefone2,
        String telefone3,
        String login,
        String senha,
        String email
){

}
