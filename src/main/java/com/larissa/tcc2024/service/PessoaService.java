package com.larissa.tcc2024.service;

import com.larissa.tcc2024.exceptions.CustomExceptionTeste;
import com.larissa.tcc2024.model.Pessoa;
import com.larissa.tcc2024.repository.AgendaRepository;
import com.larissa.tcc2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AgendaRepository agendaRepository;

    public Pessoa gravarPessoa(Pessoa pessoa) throws CustomExceptionTeste {

        Optional<Pessoa> pessoaExistente = pessoaRepository.findByLogin(pessoa.getLogin());
        if (pessoaExistente.isPresent()) {
            throw new CustomExceptionTeste("Este login já está cadastrado");
        }

        Optional<String> cpfExistente = pessoaRepository.findCpfByCpfCustomQuery(pessoa.getCpf());
        if (cpfExistente.isPresent()) {
            throw new CustomExceptionTeste("Este CPF já está cadastrado");
        }


        if (pessoa.getNm_pessoa() == null || pessoa.getCpf() == null) {
            throw new CustomExceptionTeste("Nome CPF não podem ser nulos");
        }

        if (pessoa.getNm_pessoa() == null ) {
            throw new CustomExceptionTeste("Nome não pode");
        }

        if (!isValidCPF(pessoa.getCpf())) {
            throw new CustomExceptionTeste("CPF inválido");
        }


        String senhaCriptografada = passwordEncoder.encode(pessoa.getSenha());


        return pessoaRepository.save(pessoa);
    }

    private boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (10 - i) * (cpf.charAt(i) - '0');
            }
            int checkDigit1 = 11 - (sum % 11);
            if (checkDigit1 >= 10) {
                checkDigit1 = 0;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (11 - i) * (cpf.charAt(i) - '0');
            }
            int checkDigit2 = 11 - (sum % 11);
            if (checkDigit2 >= 10) {
                checkDigit2 = 0;
            }

            return checkDigit1 == (cpf.charAt(9) - '0') && checkDigit2 == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }
    }

    public List<Pessoa> listarPessoas (){
        return pessoaRepository.findAll();
    }
    public Optional<Pessoa> login(String login, String senha) {
        Optional<Pessoa> pessoa = pessoaRepository.findByLogin(login);
        System.out.println(pessoa.get().getSenha());
        if (pessoa.isPresent() && passwordEncoder.matches(senha, pessoa.get().getSenha())) {
            return pessoa;
        }

        return Optional.empty();
    }
    public List<Pessoa> listarLimpadores(){
        return pessoaRepository.findByTpPessoaLimpador();
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

    public List<Pessoa>listarAgendaFiltro(LocalDateTime dataAgendamento, String nm_municipio){
        System.out.println(dataAgendamento);
        return pessoaRepository.listarAgendaFiltro(dataAgendamento,nm_municipio);
    }
    public List<Pessoa>listarAgendaFiltroData(LocalDateTime dataAgendamento){
        return pessoaRepository.listarAgendaFiltroData(dataAgendamento);
    }

}