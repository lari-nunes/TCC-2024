package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, UUID> {

    @Query(value = "SELECT a.* from Agenda a where a.id_pessoa = :id", nativeQuery = true)
    List<Agenda> listarAgendas(UUID id);

    @Query(value = "SELECT a.* from Agenda a where a.id_limpador = :id", nativeQuery = true)
    List<Agenda> listarAgendasLimpador(UUID id);




    boolean existsByDataAgendamento(LocalDateTime dataAgendamento);

}
