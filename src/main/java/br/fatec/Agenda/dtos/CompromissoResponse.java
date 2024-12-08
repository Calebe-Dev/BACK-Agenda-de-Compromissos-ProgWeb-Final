package br.fatec.Agenda.dtos;
import java.time.LocalDate;
import java.time.LocalTime;

public record CompromissoResponse(long id, String title, String description, LocalDate compromissoDate, LocalTime startTime, LocalTime endTime,String compromissoStatus, String local, long priority) {
     

}
