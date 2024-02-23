package com.larissa.tcc2024.controller;

import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa/login")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> gravarPessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
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
    public ResponseEntity<Object> atualizarPessoaId(@PathVariable(value = "id") UUID id, @RequestBody Pessoa pessoa) {
        try {
            Optional<Pessoa> pessoa1 = pessoaService.atualizarPessoaId(id);

            if (pessoa1.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Pessoa não encontrada");
            }

            Pessoa pessoa2 = pessoa1.get();
            pessoa2.setNm_pessoa(pessoa.getNm_pessoa());
            pessoa2.setEmail(pessoa.getEmail());
            pessoa2.setDt_nascimento(pessoa.getDt_nascimento());
            pessoa2.setLogin(pessoa.getLogin());
            pessoa2.setSenha(pessoa.getSenha());
            pessoa2.setCpf_cnpj(pessoa.getCpf_cnpj());
            pessoa2.setTelefone1(pessoa.getTelefone1());
            pessoa2.setTelefone2(pessoa.getTelefone2());
            pessoa2.setTelefone3(pessoa.getTelefone3());

            Pessoa pessoaAtualizada = pessoaService.gravarPessoa(pessoa2);
            return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
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
}
