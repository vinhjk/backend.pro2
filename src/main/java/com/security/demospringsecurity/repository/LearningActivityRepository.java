package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.LearningActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningActivityRepository extends JpaRepository<LearningActivity, Long> {
}
