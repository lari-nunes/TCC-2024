package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.Agenda_cliente;
import com.larissa.tcc2024.model.Agenda_v;
import com.larissa.tcc2024.repository.Agenda_ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Agend_ClienteService {

    @Autowired
    private Agenda_ClienteRepository agendaClienteRepository;

    public List<Agenda_cliente> listarAgendas (){
        return agendaClienteRepository.findAll();
    }
    public List<Agenda_cliente> listarAgendasClientes(UUID id){
        System.out.println(id);
        return agendaClienteRepository.findByCliente(id);
    }
}
