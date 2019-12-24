package com.security.demospringsecurity.security.service.Impl;

import com.security.demospringsecurity.model.LearningProgram;
import com.security.demospringsecurity.repository.LearningProgramRepository;
import com.security.demospringsecurity.security.service.LearningProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningProgramServiceImpl implements LearningProgramService {
    @Autowired
    LearningProgramRepository programRepository;
    @Override
    public List<LearningProgram> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Optional<LearningProgram> findById(Long id) {
        return programRepository.findById(id);
    }

    @Override
    public void save(LearningProgram learningProgram) {
        programRepository.save(learningProgram);
    }

    @Override
    public void remove(Long id) {
        programRepository.deleteById(id);
    }
}
