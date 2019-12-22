package com.security.demospringsecurity.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LearningProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String learningProgram;

    @OneToMany(targetEntity = Objective.class)
    private List<Objective> objectives;

    public LearningProgram(){}

    public LearningProgram(String learningProgram){
        this.learningProgram = learningProgram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLearningProgram() {
        return learningProgram;
    }

    public void setLearningProgram(String learningProgram) {
        this.learningProgram = learningProgram;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }
}
