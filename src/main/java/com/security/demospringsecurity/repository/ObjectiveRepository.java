package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.Objective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
}
