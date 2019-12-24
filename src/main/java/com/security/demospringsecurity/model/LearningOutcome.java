package com.security.demospringsecurity.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LearningOutcome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String learningOutcome;

    @ManyToOne
    @JoinColumn(name = "objective")
    private Objective objective;

    @ManyToMany
    @JoinColumn(name = "learningActivity")
    private List<LearningActivity> learningActivity;

    public List<LearningActivity> getLearningActivity() {
        return learningActivity;
    }

    public void setLearningActivity(List<LearningActivity> learningActivity) {
        this.learningActivity = learningActivity;
    }

    public LearningOutcome(){}

    public LearningOutcome(String learningOutcome){this.learningOutcome = learningOutcome; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
