package com.larissa.tcc2024.dto;

import com.larissa.tcc2024.model.TipoPessoa;

import java.time.LocalDate;

public record PessoaDTO (TipoPessoa tp_pessoa, String nm_pessoa, String cpf_cnpj, Boolean in_excluido, LocalDate dt_nascimento){
}
