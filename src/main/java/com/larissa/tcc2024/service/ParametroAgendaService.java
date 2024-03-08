package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.Agenda;
import com.larissa.tcc2024.model.ParametroAgenda;
import com.larissa.tcc2024.repository.AgendaRepository;
import com.larissa.tcc2024.repository.ParametroAgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParametroAgendaService {
    @Autowired
    private ParametroAgendaRepository parametroAgendaRepository;

    public ParametroAgenda gravarParametroAgenda(ParametroAgenda parametroAgenda){
        return parametroAgendaRepository.save(parametroAgenda);
    }

    public List<ParametroAgenda> listarAgendas (){
        return parametroAgendaRepository.findAll();
    }

    public Optional<ParametroAgenda> buscarAgendaId(UUID id){
        return parametroAgendaRepository.findById(id);
    }

    public Optional<ParametroAgenda> atualizarParametroAgendaId(UUID id){
        return parametroAgendaRepository.findById(id);
    }

    public void deletarParametroAgendaId(Optional<ParametroAgenda> parametroAgenda){
        parametroAgendaRepository.delete(parametroAgenda.get());
    }
}
