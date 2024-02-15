package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "PESSOA")
@Table(name = "PESSOA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_pessoa;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tp_pessoa;
    private String nm_pessoa;
    @CPF
    @CNPJ
    private String cpf_cnpj;
    private Boolean in_excluido;
    private LocalDate dt_nascimento;
}
