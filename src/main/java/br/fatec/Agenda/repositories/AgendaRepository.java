package br.fatec.Agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.Agenda.entities.Compromisso;

public interface AgendaRepository extends JpaRepository<Compromisso, Long>{
    
    
}
