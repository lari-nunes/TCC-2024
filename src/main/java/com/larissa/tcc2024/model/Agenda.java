package com.larissa.tcc2024.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Agenda{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_agenda;
    private Status status_agendamento;
    private LocalDate dt_agendamento;
    private Boolean in_disponivel;
    @Size(max = 200)
    private String observacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_servico")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Servico servico;
}
