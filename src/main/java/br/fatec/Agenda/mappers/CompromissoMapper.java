package br.fatec.Agenda.mappers;

import br.fatec.Agenda.dtos.CompromissoRequest;
import br.fatec.Agenda.dtos.CompromissoResponse;
import br.fatec.Agenda.entities.Compromisso;

public class CompromissoMapper {
    public static CompromissoResponse toDTO(Compromisso compromisso){
        return new CompromissoResponse(compromisso.getId(), compromisso.getTitle(), compromisso.getDescription(), compromisso.getCompromissoDate(), compromisso.getStartTime(), compromisso.getEndTime(), compromisso.getLocal(),compromisso.getCompromissoStatus(), compromisso.getPriority());
    }

    public static Compromisso toEntity(CompromissoRequest compromissoRequest){
        Compromisso compromisso = new Compromisso();
        compromisso.setTitle(compromissoRequest.title());
        compromisso.setDescription(compromissoRequest.description());
        compromisso.setCompromissoDate(compromissoRequest.compromissoDate());
        compromisso.setStartTime(compromissoRequest.startTime());
        compromisso.setEndTime(compromissoRequest.endTime());
        compromisso.setCompromissoStatus(compromissoRequest.compromissoStatus());
        compromisso.setLocal(compromissoRequest.local());
        compromisso.setPriority(compromissoRequest.priority());

        return compromisso;
    }
}
