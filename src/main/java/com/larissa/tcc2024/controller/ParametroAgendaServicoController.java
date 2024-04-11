package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.dto.EnderecoDTO;
import com.larissa.tcc2024.dto.ParametroAgendaServicoDTO;
import com.larissa.tcc2024.model.Endereco;
import com.larissa.tcc2024.model.ParametroAgendaServico;
import com.larissa.tcc2024.repository.EnderecoRepository;
import com.larissa.tcc2024.repository.ParametroAgendaServicoRepository;
import com.larissa.tcc2024.service.EnderecoService;
import com.larissa.tcc2024.service.ParametroAgendaServicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/parametroAgendaServico")
public class ParametroAgendaServicoController {

    @Autowired
    private ParametroAgendaServicoService parametroAgendaServicoService;

    @Autowired
    private ParametroAgendaServicoRepository parametroAgendaServicoRepository;

    @PostMapping
    public ResponseEntity<Object> gravarParametroAgendaServico(@RequestBody ParametroAgendaServico parametroAgendaServico){
        return ResponseEntity.status(HttpStatus.CREATED).body(parametroAgendaServicoService.gravarParametroAgendaServico(parametroAgendaServico));
    }

    @GetMapping
    public ResponseEntity<List<ParametroAgendaServico>> listarParametroAgendaServico(){
        return ResponseEntity.status(HttpStatus.OK).body(parametroAgendaServicoService.listarParametroAgendaServico());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> parametroAgendaServicoId(@PathVariable(value = "id") UUID id){
        Optional<ParametroAgendaServico> parametroAgendaServico = parametroAgendaServicoService.buscarParametroAgendaServicoId(id);
        if(parametroAgendaServico.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse Parâmetro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parametroAgendaServicoService.buscarParametroAgendaServicoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarParametroAgendaServicoId(@PathVariable(value = "id") UUID id, @RequestBody ParametroAgendaServicoDTO parametroAgendaServicoDTO) {
        try{
            Optional<ParametroAgendaServico> parametroAgendaServico = parametroAgendaServicoRepository.findById(id);
            if(parametroAgendaServico.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parâmetro não encontrado");
            }
            var parametroEntidade = parametroAgendaServico.get();
            BeanUtils.copyProperties(parametroAgendaServicoDTO, parametroEntidade);
            return ResponseEntity.status(HttpStatus.OK).body(parametroAgendaServicoRepository.save(parametroEntidade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição: " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarParametroAgendaServicoId(@PathVariable(value = "id") UUID id) {
        try {
            Optional<ParametroAgendaServico> parametroAgendaServico = parametroAgendaServicoService.buscarParametroAgendaServicoId(id);

            if (parametroAgendaServico.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
            }

            parametroAgendaServicoService.deletarParametroAgendaServicoId(parametroAgendaServico);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }
}
