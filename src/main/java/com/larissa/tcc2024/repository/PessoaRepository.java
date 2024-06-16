package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    Optional<Pessoa> findByLogin(String login);

    @Query(value = "SELECT p.* FROM Pessoa p WHERE p.tp_pessoa = 'USUARIO'", nativeQuery = true)
    List<Pessoa> findByTpPessoaLimpador();

    @Query(value = "SELECT p.cpf FROM Pessoa p WHERE p.cpf = :cpf", nativeQuery = true)
    Optional<String> findCpfByCpfCustomQuery(@Param("cpf") String cpf);

    @Query(value = "SELECT DISTINCT p.* FROM pessoa p " +
            "INNER JOIN agenda a ON p.id_pessoa = a.id_limpador " +
            "INNER JOIN endereco e ON p.id_pessoa = e.id_pessoa " +
            "WHERE (a.data_agendamento != :dataAgendamento) " +
            "AND (e.nm_municipio LIKE %:nm_municipio%) " +
            "AND p.tp_pessoa = 'USUARIO'", nativeQuery = true)
    List<Pessoa> listarAgendaFiltro(@Param("dataAgendamento") LocalDateTime dataAgendamento, @Param("nm_municipio") String nm_municipio);


    @Query(value = "SELECT DISTINCT p.* FROM pessoa p " +
            "LEFT JOIN agenda a ON p.id_pessoa = a.id_limpador " +
            "WHERE (a.data_agendamento != :dataAgendamento OR a.data_agendamento IS NULL) " +
            "AND p.tp_pessoa = 'USUARIO'", nativeQuery = true)
    List<Pessoa> listarAgendaFiltroData(@Param("dataAgendamento") LocalDateTime dataAgendamento);
}
