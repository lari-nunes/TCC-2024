package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.Agenda;
import com.larissa.tcc2024.model.Endereco;
import com.larissa.tcc2024.repository.AgendaRepository;
import com.larissa.tcc2024.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco gravarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos (){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEnderecoId(UUID id){
        return enderecoRepository.findById(id);
    }

    public Optional<Endereco> atualizarAgendaId(UUID id){
        return enderecoRepository.findById(id);
    }

    public void deletarEnderecoId(Optional<Endereco> endereco){
        enderecoRepository.delete(endereco.get());
    }
}
