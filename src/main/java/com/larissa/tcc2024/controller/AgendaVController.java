package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.model.Agenda_v;
import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.service.AgendaService;
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
public class AgendaVController {

    @Autowired
    private AgendaVService agendaVService;

    @GetMapping("/limpadoresView")
    public ResponseEntity<List<Agenda_v>> listarView(){
        return ResponseEntity.status(HttpStatus.OK).body(agendaVService.listarAgendas());
    }
    @GetMapping("/limpadoresView/{id}")
    public ResponseEntity<List<Agenda_v>> listarViewLimpador(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(agendaVService.listarAgendasLimpador(id));
    }
}
