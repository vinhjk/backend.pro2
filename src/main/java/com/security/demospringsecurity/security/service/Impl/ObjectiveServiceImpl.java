package com.security.demospringsecurity.security.service.Impl;

import com.security.demospringsecurity.model.Objective;
import com.security.demospringsecurity.repository.ObjectiveRepository;
import com.security.demospringsecurity.security.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {
    @Autowired
    private ObjectiveRepository objectRepository;
    @Override
    public List<Objective> findAll() {
        return objectRepository.findAll();
    }

    @Override
    public Optional<Objective> findById(Long id) {
        return objectRepository.findById(id);
    }

    @Override
    public void save(Objective objective) {
        objectRepository.save(objective);
    }

    @Override
    public void remove(Long id) {
        objectRepository.deleteById(id);
    }
}
