package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.LearningOutcome;
import com.security.demospringsecurity.model.Objective;
import com.security.demospringsecurity.security.service.LearningOutcomeService;
import com.security.demospringsecurity.security.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/auth/learningOutcomes")
public class LearningOutcomeController {
    @Autowired
    private LearningOutcomeService learningOutcomeService;

    @Autowired
    private ObjectiveService objectiveService;

    @ModelAttribute("objectives")
    public List<Objective> objectives() {
        return objectiveService.findAll();
    }

    @GetMapping
    private ResponseEntity<List<LearningOutcome>> listAllLearningOutcome() {
        List<LearningOutcome> learningOutcomes = learningOutcomeService.findAll();
        if (learningOutcomes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(learningOutcomes, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createLearningOutcome(@RequestBody LearningOutcome learningOutcome, UriComponentsBuilder ucBuilder) {
        learningOutcomeService.save(learningOutcome);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/learningOutcomes/{id}").buildAndExpand(learningOutcome.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
