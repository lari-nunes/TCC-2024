package com.larissa.tcc2024.repository;

import com.larissa.tcc2024.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

    //@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
    //Pessoa findByCPF(@Param("cpf") String cpf);
}
