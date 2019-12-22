package com.security.demospringsecurity.security.service;

import com.security.demospringsecurity.model.Objective;

import java.util.List;
import java.util.Optional;

public interface ObjectiveService {
    List<Objective> findAll();
    Optional<Objective> findById(Long id);
    void save(Objective objective);
    void remove(Long id);
}
