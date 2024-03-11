package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.dto.ServicoDTO;
import com.larissa.tcc2024.model.Endereco;
import com.larissa.tcc2024.model.Servico;
import com.larissa.tcc2024.repository.ServicoRepository;
import com.larissa.tcc2024.service.ServicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ServicoRepository servicoRepository;

    @PostMapping
    public ResponseEntity<Object> gravarServico(@RequestBody Servico servico){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.gravarServico(servico));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos(){
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.listarServicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> servicoPorId(@PathVariable(value = "id") UUID id){
        Optional<Servico> servico = servicoService.buscarServicoId(id);
        if(servico.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse Servico.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.buscarServicoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarServicoPorId(@PathVariable(value = "id") UUID id, @RequestBody ServicoDTO servicoDTO) {
        try{
            Optional<Servico> servico = servicoRepository.findById(id);
            if(servico.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado");
            }
            var servicoEntidade = servico.get();
            BeanUtils.copyProperties(servicoDTO, servicoEntidade);
            return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.save(servicoEntidade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição: " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarServicoPorId(@PathVariable(value = "id") UUID id) {
        try {
            Optional<Servico> servico = servicoService.buscarServicoId(id);

            if (servico.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
            }

            servicoService.deletarServicoId(servico);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }
}
