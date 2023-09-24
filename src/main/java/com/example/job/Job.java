package com.example.job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String service;
    private boolean etat;

    // Getter and Setter methods
    public Integer getId() {
        return id;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public boolean getEtat() {
        return etat;
    }
    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    public Job() {
    }

    public Job(String service, boolean etat) {
        this.service = service;
        this.etat = etat;
    }
}
