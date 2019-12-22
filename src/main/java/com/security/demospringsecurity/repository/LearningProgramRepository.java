package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.LearningProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningProgramRepository extends JpaRepository<LearningProgram, Long> {
}
