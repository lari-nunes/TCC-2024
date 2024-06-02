package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Agenda;
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
//    Optional<Pessoa> findByCpf(String cpf);
    Optional<Pessoa> findByLogin(String login);

    @Query(value = "SELECT p.* from Pessoa p where p.tp_pessoa = 'USUARIO'", nativeQuery = true)
    List<Pessoa> findByTpPessoaLimpador();

    @Query(value = "SELECT p.cpf FROM Pessoa p WHERE p.cpf = :cpf", nativeQuery = true)
    Optional<String> findCpfByCpfCustomQuery(String cpf);

    @Query(value="select p.* from pessoa p " +
            "left join agenda a on (p.id_pessoa = a.id_limpador) " +
            "inner join endereco e on (p.id_pessoa = e.id_pessoa) " +
            "where a.dataAgendamento != :dataAgendamento or a.dataAgendamento is null " +
            "and (:nm_municipio is null or e.nm_municipio like %:nm_municipio%) and p.tp_pessoa = 'USUARIO'", nativeQuery = true)
    List<Pessoa> listarAgendaFiltro(LocalDateTime dataAgendamento, String nm_municipio);

    @Query(value="select p.* from pessoa p " +
            "left join agenda a on (p.id_pessoa = a.id_limpador) " +
            "where a.dataAgendamento != :dataAgendamento or a.dataAgendamento is null and p.tp_pessoa = 'USUARIO'", nativeQuery = true)
    List<Pessoa> listarAgendaFiltroData(LocalDateTime dataAgendamento);


    //@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
    //Pessoa findByCPF(@Param("cpf") String cpf);
}
