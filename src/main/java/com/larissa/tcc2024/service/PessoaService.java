package com.larissa.tcc2024.service;

import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Pessoa gravarPessoa(Pessoa pessoa){
        if(pessoaRepository.findByCpf(pessoa.getCpf_cnpj()).isPresent()){
            throw new RuntimeException("Esse CPF/CPNPJ já existe");
        }
        if(pessoa.getNm_pessoa() == null || pessoa.getCpf_cnpj() == null){
            throw new RuntimeException("O nome da pessoa e o CPF/CNPJ não podem");
        }
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas (){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaId(UUID id){
        return pessoaRepository.findById(id);
    }

    public Optional<Pessoa> atualizarPessoaId(UUID id){
        return pessoaRepository.findById(id);
    }

    public void deletarPessoaId(Optional<Pessoa> pessoa){
        pessoaRepository.delete(pessoa.get());
    }
}
