package com.larissa.tcc2024.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.larissa.tcc2024.dto.LoginDTO;
import com.larissa.tcc2024.model.LoginResponse;
import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.repository.PessoaRepository;
import com.larissa.tcc2024.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        System.out.println(loginDTO.getLogin());
        Optional<Pessoa> pessoa = pessoaService.login(loginDTO.getLogin(), loginDTO.getSenha());
        System.out.println(pessoa);
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(new LoginResponse(pessoa.get().getId_pessoa()));
    }

}
