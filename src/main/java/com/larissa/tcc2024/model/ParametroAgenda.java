package com.larissa.tcc2024.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "PARAMETRO_AGENDA")
@Entity(name = "PARAMETRO_AGENDA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ParametroAgenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id_parametro_agenda;
    private String dia_semana;
    private Integer qtd_semana;
    private LocalDate hr_inicial;
    private LocalDate hr_final;
    private LocalDate hr_inicial_vespertino;
    private LocalDate hr_final_vespertino;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa")
    private Pessoa pessoa;
}
