package com.security.demospringsecurity.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LearningActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String learningActivity;

    @ManyToMany
    @JoinColumn(name = "learningOutcome")
    private List<LearningOutcome> learningOutcome;

    public LearningActivity(){}

    public LearningActivity(String learningActivity){this.learningActivity = learningActivity;}

    public Long getId() {
        return id;
    }

    public List<LearningOutcome> getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(List<LearningOutcome> learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLearningActivity() {
        return learningActivity;
    }

    public void setLearningActivity(String learningActivity) {
        this.learningActivity = learningActivity;
    }
}
