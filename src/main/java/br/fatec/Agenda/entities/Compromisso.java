package br.fatec.Agenda.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compromisso implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate compromissoDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String local;
    private String compromissoStatus;
    public String getCompromissoStatus() {
        return compromissoStatus;
    }

    public void setCompromissoStatus(String compromissoStatus) {
        this.compromissoStatus = compromissoStatus;
    }

    private Long priority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCompromissoDate() {
        return compromissoDate;
    }

    public void setCompromissoDate(LocalDate compromissoDate){
        this.compromissoDate = compromissoDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority){
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Compromisso other = (Compromisso) obj;
        if (id != other.id)
            return false;
        return true;
    }

 

    
}