package com.security.demospringsecurity.security.service.Impl;

import com.security.demospringsecurity.model.LearningOutcome;
import com.security.demospringsecurity.repository.LearningOutcomeRepository;
import com.security.demospringsecurity.security.service.LearningOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningOutcomeServiceImpl implements LearningOutcomeService {
    @Autowired
    private LearningOutcomeRepository outcomeRepository;
    @Override
    public List<LearningOutcome> findAll() {
        return outcomeRepository.findAll();
    }

    @Override
    public Optional<LearningOutcome> findById(Long id) {
        return outcomeRepository.findById(id);
    }

    @Override
    public void save(LearningOutcome learningOutcome) {
        outcomeRepository.save(learningOutcome);
    }

    @Override
    public void remove(Long id) {
        outcomeRepository.deleteById(id);
    }
}
