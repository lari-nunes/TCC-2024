package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "AGENDA_V")
@Entity(name = "AGENDA_V")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agenda_v {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_agenda;
    private UUID id_limpador;
    private LocalDateTime dataAgendamento;
    private String nm_pessoa;
    private String nm_municipio;
    private String rua;
    private String bairro;
    private String numero;
    private String telefone1;
}

