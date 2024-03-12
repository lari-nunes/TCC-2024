package com.larissa.tcc2024.dto;

import java.time.LocalDate;

public record ParametroAgendaDTO(
        String dia_semana,
        Integer qtd_semana,
        LocalDate hr_inicial,
        LocalDate hr_final,
        LocalDate hr_inicial_vespertino,
        LocalDate hr_final_vespertino
) {
}
