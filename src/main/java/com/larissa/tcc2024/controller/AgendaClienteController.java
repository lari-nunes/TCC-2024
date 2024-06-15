package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.model.Agenda_cliente;
import com.larissa.tcc2024.model.Agenda_v;
import com.larissa.tcc2024.service.Agend_ClienteService;
import com.larissa.tcc2024.service.AgendaVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agenda")
public class AgendaClienteController {

    @Autowired
    private Agend_ClienteService agendClienteService;

    @GetMapping("/agendaCliente")
    public ResponseEntity<List<Agenda_cliente>> listarView(){
        return ResponseEntity.status(HttpStatus.OK).body(agendClienteService.listarAgendas());
    }
    @GetMapping("/agendaCliente/{id}")
    public ResponseEntity<List<Agenda_cliente>> listarViewCliente(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(agendClienteService.listarAgendasClientes(id));
    }
}
