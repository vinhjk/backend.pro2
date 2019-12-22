package com.security.demospringsecurity.security.service;

import com.security.demospringsecurity.model.*;

import java.util.List;
import java.util.Optional;

public interface LearningProgramService {
    List<LearningProgram> findAll();
    Optional<LearningProgram> findById(Long id);
    void save(LearningProgram learningProgram);
    void remove(Long id);
}
