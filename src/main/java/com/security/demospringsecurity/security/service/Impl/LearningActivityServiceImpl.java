package com.security.demospringsecurity.security.service.Impl;

import com.security.demospringsecurity.model.LearningActivity;
import com.security.demospringsecurity.repository.LearningActivityRepository;
import com.security.demospringsecurity.security.service.LearningActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningActivityServiceImpl implements LearningActivityService {

    @Autowired
    private LearningActivityRepository activityRepository;
    @Override
    public List<LearningActivity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Optional<LearningActivity> findById(Long id) {
        return activityRepository.findById(id);
    }

    @Override
    public void save(LearningActivity learningActivity) {
        activityRepository.save(learningActivity);
    }

    @Override
    public void remove(Long id) {
        activityRepository.deleteById(id);
    }
}
