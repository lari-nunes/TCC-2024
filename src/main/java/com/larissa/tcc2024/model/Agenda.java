package com.larissa.tcc2024.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private UUID id_limpador;
    private Status status_agendamento;
    private LocalDateTime dataAgendamento;
    private Boolean in_disponivel;
    @Size(max = 200)
    private String observacao;
    private UUID id_pessoa;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_servico")
    private Servico servico;
}
