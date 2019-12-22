package com.security.demospringsecurity.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String objective;

    @OneToMany(targetEntity = LearningOutcome.class, mappedBy = "objective")
    private List<LearningOutcome> learningOutcomes;

    @ManyToOne
    @JoinColumn(name = "learningProgram_id")
    private LearningProgram learningProgram;

    public Objective(){}

    public Objective(String objective){this.objective = objective; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<LearningOutcome> getLearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(List<LearningOutcome> learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    public LearningProgram getLearningProgram() {
        return learningProgram;
    }

    public void setLearningProgram(LearningProgram learningProgram) {
        this.learningProgram = learningProgram;
    }
}
