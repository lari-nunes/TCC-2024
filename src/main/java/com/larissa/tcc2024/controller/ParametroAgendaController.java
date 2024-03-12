package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.dto.ParametroAgendaDTO;
import com.larissa.tcc2024.dto.ServicoDTO;
import com.larissa.tcc2024.model.ParametroAgenda;
import com.larissa.tcc2024.model.Servico;
import com.larissa.tcc2024.repository.ParametroAgendaRepository;
import com.larissa.tcc2024.service.ParametroAgendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/parametroAgenda")
public class ParametroAgendaController {

    @Autowired
    private ParametroAgendaRepository parametroAgendaRepository;

    @Autowired
    private ParametroAgendaService parametroAgendaService;

    @PostMapping
    public ResponseEntity<Object> gravarParametroAgenda(@RequestBody ParametroAgenda parametroAgenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(parametroAgendaService.gravarParametroAgenda(parametroAgenda));
    }

    @GetMapping
    public ResponseEntity<List<ParametroAgenda>> listarParametroAgenda(){
        return ResponseEntity.status(HttpStatus.OK).body(parametroAgendaService.listarParametroAgenda());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> servicoPorId(@PathVariable(value = "id") UUID id){
        Optional<ParametroAgenda> parametroAgenda = parametroAgendaService.buscarParametroAgendaId(id);
        if(parametroAgenda.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse Paramêtro Servico.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parametroAgendaService.buscarParametroAgendaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarParametroAgendaId(@PathVariable(value = "id") UUID id, @RequestBody ParametroAgendaDTO parametroAgendaDTO) {
        try{
            Optional<ParametroAgenda> parametroAgenda = parametroAgendaRepository.findById(id);
            if(parametroAgenda.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paramêtro Agenda não encontrado");
            }
            var parametroAgendaEntidade = parametroAgenda.get();
            BeanUtils.copyProperties(parametroAgendaDTO, parametroAgendaEntidade);
            return ResponseEntity.status(HttpStatus.OK).body(parametroAgendaRepository.save(parametroAgendaEntidade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição: " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarParametroAgendaId(@PathVariable(value = "id") UUID id) {
        try {
            Optional<ParametroAgenda> parametroAgenda = parametroAgendaService.buscarParametroAgendaId(id);

            if (parametroAgenda.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
            }

            parametroAgendaService.deletarParametroAgendaId(parametroAgenda);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }
}
