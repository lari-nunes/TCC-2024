package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
