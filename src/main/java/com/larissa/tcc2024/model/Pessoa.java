package com.larissa.tcc2024.model;

import com.larissa.tcc2024.dto.PessoaDTO;
import  jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "PESSOA")
@Table(name = "PESSOA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_pessoa;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tp_pessoa;
    private String nm_pessoa;
    private String email;
    @CPF
    private String cpf;
    private String login;
    private String senha;
    private Boolean in_excluido;
    private LocalDate dt_nascimento;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    @Size(max = 200)
    private String descricao;

    public void PessoaDTO(Pessoa obj){
        this.id_pessoa = getId_pessoa();
        this.nm_pessoa = getNm_pessoa();
        this.email = getEmail();
        this.cpf = getCpf();
        this.login = getLogin();
        this.senha = getSenha();
        this.tp_pessoa = getTp_pessoa();
        this.telefone1 = getTelefone1();
        this.descricao = getDescricao();
    }
}
