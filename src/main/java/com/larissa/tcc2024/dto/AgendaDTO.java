package com.larissa.tcc2024.dto;

import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.model.Servico;
import com.larissa.tcc2024.model.Status;

import java.time.LocalDate;

public record AgendaDTO(
        Status status_agendamento,
        LocalDate dt_agendamento,
        Boolean in_disponivel,
        String observacao,
        Pessoa pessoa,
        Servico servico
) {
}
