package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "AGENDA_CLIENTE")
@Entity(name = "AGENDA_CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agenda_cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_agenda;
    private UUID id_limpador;
    private LocalDateTime dataAgendamento;
    private String nm_pessoa;
    private String nm_municipio;
    private String telefone1;
}
