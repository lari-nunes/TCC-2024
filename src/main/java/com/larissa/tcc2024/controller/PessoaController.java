package com.larissa.tcc2024.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.larissa.tcc2024.dto.PessoaDTO;
import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.repository.PessoaRepository;
import com.larissa.tcc2024.exceptions.CustomExceptionTeste;
import com.larissa.tcc2024.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Object> gravarPessoa(@RequestBody Pessoa pessoa) {
        try {
            var passwordHash = BCrypt.withDefaults().hashToString(12, pessoa.getSenha().toCharArray());
            pessoa.setSenha(passwordHash);
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.gravarPessoa(pessoa));
        } catch (CustomExceptionTeste e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping("/limpadores")
    public ResponseEntity<List<Pessoa>> listarLimpadores(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarLimpadores());
    }


    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pessoaPorId(@PathVariable (value = "id") UUID id){
        Optional<Pessoa> pessoa = pessoaService.buscarPessoaId(id);
        if(pessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe essa pessoa.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoaId(@PathVariable(value = "id") UUID id, @RequestBody PessoaDTO pessoaDTO) {
        try{
            Optional<Pessoa> pessoa = pessoaRepository.findById(id);
            if(pessoa.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
            }
            var pessoaEntidade = pessoa.get();
            BeanUtils.copyProperties(pessoaDTO, pessoaEntidade);
            return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(pessoaEntidade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição: " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPessoa(@PathVariable(value = "id") UUID id) {
        try {
            Optional<Pessoa> pessoa = pessoaService.buscarPessoaId(id);

            if (pessoa.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
            }

            pessoaService.deletarPessoaId(pessoa);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }
    @GetMapping("/listaFiltro/{dataAgendamento}")
    public ResponseEntity<List<Pessoa>> listarAgendaFiltro(
            @PathVariable LocalDate dataAgendamento,
            @RequestParam(required = false) String nm_municipio
    ) {

        List<Pessoa> pessoas;
        if (StringUtils.hasText(nm_municipio)) {
            System.out.println("entrou aqui");
            pessoas = pessoaService.listarAgendaFiltro(dataAgendamento.atStartOfDay(), nm_municipio);
        } else {
            pessoas = pessoaService.listarAgendaFiltroData(dataAgendamento.atStartOfDay());
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }


}