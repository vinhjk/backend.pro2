package com.security.demospringsecurity.security.service;

import com.security.demospringsecurity.model.LearningActivity;

import java.util.List;
import java.util.Optional;

public interface LearningActivityService {
    List<LearningActivity> findAll();
    Optional<LearningActivity> findById(Long id);
    void save(LearningActivity learningActivity);
    void remove(Long id);
}
