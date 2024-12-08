package br.fatec.Agenda.dtos;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CompromissoRequest(
    @NotBlank(message="Precisamos de um titulo")
     String title,
     
     String description,

     LocalDate compromissoDate,

     LocalTime startTime,

     LocalTime endTime,

     String compromissoStatus,

     @NotBlank
     String local,

    @Min(value = 1, message = "A prioridade deve ser pelo menos 1")
    @Max(value = 10, message = "A prioridade pode ser no máximo 10")
    long priority) {
     

    
}
