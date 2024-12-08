package br.fatec.Agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.Agenda.dtos.CompromissoRequest;
import br.fatec.Agenda.dtos.CompromissoResponse;
import br.fatec.Agenda.entities.Compromisso;
import br.fatec.Agenda.mappers.CompromissoMapper;
import br.fatec.Agenda.repositories.AgendaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaServices {
    
    @Autowired
    private AgendaRepository repository;

    public List<CompromissoResponse> GetAllCompromissos(){
        return repository.findAll().stream().map(c -> CompromissoMapper.toDTO(c)).collect(Collectors.toList());
    }

    public CompromissoResponse GetCompromissoById(long id){
        Compromisso compromisso = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Compromisso não encontrado")
        );
        return CompromissoMapper.toDTO(compromisso);
    }

    public void delete(long id){
        if(repository.existsById(id))
        {
            repository.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException("Compromisso não encontrado");
        }
    }

    public CompromissoResponse save(CompromissoRequest compromisso){
        Compromisso newCompromisso = repository.save(CompromissoMapper.toEntity(compromisso));
        return CompromissoMapper.toDTO(newCompromisso);
    }

    public void update(CompromissoRequest compromisso,long id){
        Compromisso aux = repository.getReferenceById(id);

        aux.setTitle(compromisso.title());
        aux.setDescription(compromisso.description());
        aux.setCompromissoDate(compromisso.compromissoDate());
        aux.setStartTime(compromisso.startTime());
        aux.setEndTime(compromisso.endTime());
        aux.setLocal(compromisso.local());
        aux.setCompromissoStatus(compromisso.compromissoStatus());
        aux.setPriority(compromisso.priority()); 
        
        repository.save(aux);
      //  System.out.println("Payload recebido: " + compromisso);

    }

}
