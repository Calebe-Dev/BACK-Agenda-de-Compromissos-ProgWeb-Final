package br.fatec.Agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.Agenda.dtos.CompromissoRequest;
import br.fatec.Agenda.dtos.CompromissoResponse;
import br.fatec.Agenda.services.AgendaServices;


@CrossOrigin
@RestController
@RequestMapping("Compromisso")
public class AgendaController {
    
    @Autowired
    private AgendaServices service;

        @GetMapping
        public ResponseEntity<List<CompromissoResponse>> GetCompromissos(){
            return ResponseEntity.ok(service.GetAllCompromissos());
        }

        @GetMapping("{id}")
        public ResponseEntity<CompromissoResponse> GetCompromisso(@PathVariable Long id){
            return ResponseEntity.ok(service.GetCompromissoById(id));
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Void> DeleteCompromisso(@PathVariable long id){
            service.delete(id);
           return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public ResponseEntity<Void> UpdateCompromisso(@PathVariable long id, @Validated @RequestBody CompromissoRequest compromisso)
        {
            service.update(compromisso, id);
            return ResponseEntity.ok().build();
        }

        @PostMapping()
        public ResponseEntity<CompromissoResponse> SaveCompromisso(@Validated @RequestBody CompromissoRequest compromisso){
            System.out.println("Payload recebido: " + compromisso);
            CompromissoResponse newCompromisso = service.save(compromisso);
            return ResponseEntity.created(null).body(newCompromisso);
        }
}