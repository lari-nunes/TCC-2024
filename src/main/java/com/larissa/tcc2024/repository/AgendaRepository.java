package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.dto.AgendamentoDTO;
import com.larissa.tcc2024.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT CASE WHEN COUNT(a.*) > 0 THEN true ELSE false END FROM Agenda a WHERE a.id_limpador = :id AND a.data_agendamento = :dataAgendamento", nativeQuery = true)
    boolean existsByDataAgendamentoLimpador(UUID id,  LocalDateTime dataAgendamento);

    @Query(value = "SELECT a.id_agenda, a.data_agendamento, p.nm_pessoa, e.nm_municipio, e.rua, e.bairro, e.numero " +
            "FROM agenda a " +
            "JOIN endereco e ON e.id_pessoa = a.id_pessoa " +
            "JOIN pessoa p ON p.id_pessoa = a.id_pessoa " +
            "WHERE a.id_limpador = :id",
            nativeQuery = true)
    List<AgendamentoDTO> listaAgendamentos(@Param("id") UUID id);

    //boolean existsByData_agendamento(LocalDateTime dataAgendamento);

}