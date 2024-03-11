package com.larissa.tcc2024.dto;

public record EnderecoDTO(
        String nm_municipio,
        String nm_uf,
        String cep,
        String rua,
        String bairro,
        Integer numero,
        String complemento
) {
}
