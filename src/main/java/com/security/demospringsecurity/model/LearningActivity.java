package com.security.demospringsecurity.model;

import javax.persistence.*;
@Entity
public class LearningActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String learningActivity;

    @ManyToMany
    @JoinColumn(name = "learningOutcome")
    private LearningOutcome learningOutcome;

    public LearningActivity(){}

    public LearningActivity(String learningActivity){this.learningActivity = learningActivity;}

    public Long getId() {
        return id;
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

    public LearningOutcome getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(LearningOutcome learningOutcome) {
        this.learningOutcome = learningOutcome;
    }
}
