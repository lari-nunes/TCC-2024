package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "ENDERECO")
@Table(name = "ENDERECO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_endereco;
    private String nm_municipio;
    private String nm_uf;
    private String cep;
    private String rua;
    private String bairro;
    private Integer numero;
    private String complemento;
    @Column(name="id_pessoa")
    private UUID id_pessoa;

}
