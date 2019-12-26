package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.LearningProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningProgramRepository extends JpaRepository<LearningProgram, Long> {
}
