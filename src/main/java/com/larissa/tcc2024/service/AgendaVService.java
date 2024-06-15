package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.Agenda_v;
import com.larissa.tcc2024.repository.AgendaVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AgendaVService {

    @Autowired
    private AgendaVRepository agendaVRepository;

    public List<Agenda_v> listarAgendas (){
        return agendaVRepository.findAll();
    }
    public List<Agenda_v>listarAgendasLimpador(UUID id){
        System.out.println(id);
        return agendaVRepository.findByLimpador(id);
    }
}
