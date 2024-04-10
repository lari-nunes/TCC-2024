package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.ParametroAgendaServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParametroAgendaServicoRepository extends JpaRepository<ParametroAgendaServico, UUID> {
}
