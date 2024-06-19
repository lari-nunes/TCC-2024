package com.larissa.tcc2024.service;

import com.larissa.tcc2024.dto.AgendamentoDTO;
import com.larissa.tcc2024.exceptions.CustomExceptionTeste;
import com.larissa.tcc2024.model.Agenda;
import com.larissa.tcc2024.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public void verificarAgendamentoExistente(LocalDateTime dataAgendamento) throws CustomExceptionTeste {
        //boolean exists = agendaRepository.existsByDataAgendamento(dataAgendamento);
        //if (exists) {
          //  throw new CustomExceptionTeste("Já existe um agendamento nesse mesmo horário.");
        //}
    }

    public Agenda gravarAgenda(Agenda agenda){
        boolean existeDataAgenda = agendaRepository.existsByDataAgendamentoLimpador(agenda.getId_limpador(),agenda.getDataAgendamento());
        if(existeDataAgenda){
            throw new CustomExceptionTeste("Não é possível realizar agendamento, o piscineiro já possui limpeza para esse horario!");
        }
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataAgendamento = agenda.getDataAgendamento();
        System.out.println(dataAgendamento);
        if (dataAgendamento.isBefore(dataAtual)) {
            throw new CustomExceptionTeste("Não é possível agendar datas passadas do dia de hoje ou adiante!");
        }
        if (dataAgendamento.isBefore(dataAtual.plusHours(3))) {
            throw new CustomExceptionTeste("O agendamento deve ser feito com pelo menos 3 horas de antecedência!");
        }

        return agendaRepository.save(agenda);
    }

    public Agenda gravarAgendaNewData(Agenda agenda) throws CustomExceptionTeste{
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataAgendamento = agenda.getDataAgendamento();

        if (dataAgendamento.isBefore(dataAtual)) {
            throw new CustomExceptionTeste("Não é possível agendar datas passadas do dia de hoje ou adiante!");
        }

        return agendaRepository.save(agenda);
    }

    public List<Agenda> listarAgendamentos(UUID id){
        return agendaRepository.listarAgendas(id);
    }
    public List<Agenda> listarAgendamentosLimpador(UUID id){
        return agendaRepository.listarAgendasLimpador(id);
    }

    public List<Agenda> listarAgendas (UUID id){
        return agendaRepository.findAll();
    }

    public Optional<Agenda> buscarAgendaId(UUID id){
        return agendaRepository.findById(id);
    }

    public Optional<Agenda> atualizarAgendaId(UUID id){
        return agendaRepository.findById(id);
    }

    public void deletarAgendaId(Optional<Agenda> agenda){
        agendaRepository.delete(agenda.get());
    }

    public List<AgendamentoDTO> listaAgendamentos(UUID id) {
        return agendaRepository.listaAgendamentos(id);
    }
}
