package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Agenda_cliente;
import com.larissa.tcc2024.model.Agenda_v;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface Agenda_ClienteRepository extends JpaRepository<Agenda_cliente, UUID> {
    @Query(value = "SELECT a.* from agenda_cliente a where a.id_pessoa = :id", nativeQuery = true)
    List<Agenda_cliente> findByCliente(UUID id);
}
