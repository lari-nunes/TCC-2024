package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "AGENDA")
@Entity(name = "AGENDA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_agenda;
    @Size(max = 20)
    private Status status_agendamento;
    private LocalDate dt_agendamento;
    private Boolean in_disponivel;
    @Size(max = 200)
    private String observacao;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa")
    private Pessoa pessoa;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id_servico")
    private Servico servico;
}
