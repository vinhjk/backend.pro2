package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.LearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningOutcomeRepository extends JpaRepository<LearningOutcome, Long> {
}
