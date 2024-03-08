package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.Agenda;
import com.larissa.tcc2024.model.Servico;
import com.larissa.tcc2024.repository.AgendaRepository;
import com.larissa.tcc2024.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico gravarServico(Servico servico){
        return servicoRepository.save(servico);
    }

    public List<Servico> listarServicos (){
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarServicoId(UUID id){
        return servicoRepository.findById(id);
    }

    public Optional<Servico> atualizarServicoId(UUID id){
        return servicoRepository.findById(id);
    }

    public void deletarServicoId(Optional<Servico> servico){
        servicoRepository.delete(servico.get());
    }
}
