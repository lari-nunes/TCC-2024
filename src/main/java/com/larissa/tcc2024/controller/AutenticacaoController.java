package com.larissa.tcc2024.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.larissa.tcc2024.dto.LoginDTO;
import com.larissa.tcc2024.model.LoginResponse;
import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.repository.PessoaRepository;
import com.larissa.tcc2024.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class AutenticacaoController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO loginDTO) {
        Optional<Pessoa> pessoa = pessoaService.login(loginDTO.getLogin(), loginDTO.getSenha());
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(new LoginResponse(pessoa.get().getId_pessoa()));
    }

//    @GetMapping("/{login}/{senha}")
//    public ResponseEntity<Optional<Pessoa>> login(@PathVariable String login, @PathVariable String senha){
//        Optional<Pessoa> pessoa = pessoaService.login(login, senha);
//        if (pessoa == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.ok(pessoa);
//    }
}
