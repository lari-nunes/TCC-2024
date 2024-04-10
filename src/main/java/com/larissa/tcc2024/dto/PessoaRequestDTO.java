package com.larissa.tcc2024.dto;

import com.larissa.tcc2024.model.TipoPessoa;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PessoaRequestDTO {
    private UUID id_pessoa;
    private TipoPessoa tp_pessoa;
    private String nm_pessoa;
    private String email;
    private String cpf;
    private String login;
    private String senha;
    private Boolean in_excluido;
    private LocalDate dt_nascimento;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private MultipartFile imagem;
}
