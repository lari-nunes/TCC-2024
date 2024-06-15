package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.ParametroAgendaServico;
import com.larissa.tcc2024.repository.ParametroAgendaServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParametroAgendaServicoService {

    @Autowired
    private ParametroAgendaServicoRepository parametroAgendaServicoRepository;

    public ParametroAgendaServico gravarParametroAgendaServico(ParametroAgendaServico parametroAgendaServico){
        return parametroAgendaServicoRepository.save(parametroAgendaServico);
    }

    public List<ParametroAgendaServico> listarParametroAgendaServico (){
        return parametroAgendaServicoRepository.findAll();
    }

    public Optional<ParametroAgendaServico> buscarParametroAgendaServicoId(UUID id){
        return parametroAgendaServicoRepository.findById(id);
    }

    public Optional<ParametroAgendaServico> atualizarParametroAgendaServicoId(UUID id){
        return parametroAgendaServicoRepository.findById(id);
    }

    public void deletarParametroAgendaServicoId(Optional<ParametroAgendaServico> parametroAgendaServico){
        parametroAgendaServicoRepository.delete(parametroAgendaServico.get());
    }
}
