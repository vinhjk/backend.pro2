package com.security.demospringsecurity.security.service;

import com.security.demospringsecurity.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface LearningProgramService {
    List<LearningProgram> findAll();
    Optional<LearningProgram> findById(Long id);
    void save(LearningProgram learningProgram);
    void remove(Long id);
}
