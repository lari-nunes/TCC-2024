package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Agenda;
import com.larissa.tcc2024.model.Agenda_v;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AgendaVRepository extends JpaRepository<Agenda_v, UUID> {
    @Query(value = "SELECT a.* from agenda_v a where a.id_limpador = :id", nativeQuery = true)
    List<Agenda_v> findByLimpador(UUID id);
}
