package com.security.demospringsecurity.security.service;

import com.security.demospringsecurity.model.LearningOutcome;

import java.util.List;
import java.util.Optional;

public interface LearningOutcomeService {
    List<LearningOutcome> findAll();
    Optional<LearningOutcome> findById(Long id);
    void save(LearningOutcome learningOutcome);
    void remove(Long id);
}
