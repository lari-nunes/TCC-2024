package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.dto.EnderecoDTO;
import com.larissa.tcc2024.dto.PessoaDTO;
import com.larissa.tcc2024.model.Endereco;
import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.repository.EnderecoRepository;
import com.larissa.tcc2024.service.EnderecoService;
import com.larissa.tcc2024.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<Object> gravarEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.gravarEndereco(endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> enderecoPorId(@PathVariable(value = "id") UUID id){
        Optional<Endereco> endereco = enderecoService.buscarEnderecoId(id);
        if(endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse Endereço.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEnderecoPorId(@PathVariable(value = "id") UUID id, @RequestBody EnderecoDTO enderecoDTO) {
        try{
            Optional<Endereco> endereco = enderecoRepository.findById(id);
            if(endereco.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
            }
            var enderecoEntidade = endereco.get();
            BeanUtils.copyProperties(enderecoDTO, enderecoEntidade);
            return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.save(enderecoEntidade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição: " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEndereco(@PathVariable(value = "id") UUID id) {
        try {
            Optional<Endereco> endereco = enderecoService.buscarEnderecoId(id);

            if (endereco.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
            }

            enderecoService.deletarEnderecoId(endereco);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }
}
