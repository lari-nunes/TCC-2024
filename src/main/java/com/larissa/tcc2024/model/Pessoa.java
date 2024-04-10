package com.larissa.tcc2024.model;

import  jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.sql.Clob;
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
    @CPF(message = "CPF inválido")
    private String cpf;
    private String login;
    private String senha;
    private Boolean in_excluido;
    private LocalDate dt_nascimento;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    @Lob
    @Column(name = "entity_value")
    private String imagem;
}
