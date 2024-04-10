package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "PARAMENTRO_AGENDA_SERVICO")
@Table(name = "PARAMENTRO_AGENDA_SERVICO")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ParametroAgendaServico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_paramentro_agenda_servico;
    private String tmp_estimado;
    private Double vlr_estimado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_servico")
    private Servico servico;
}
