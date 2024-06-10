package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "SERVICO")
@Table(name = "SERVICO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_servico;
    @Size(max = 200)
    private String descricao;
    private Double vlr_estimado;
    private UUID id_pessoa;
}
