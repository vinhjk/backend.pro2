package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.LearningActivity;
import com.security.demospringsecurity.model.LearningOutcome;
import com.security.demospringsecurity.security.service.LearningActivityService;
import com.security.demospringsecurity.security.service.LearningOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/auth/learningActivities")
public class LearningActivityController {
    @Autowired
    LearningActivityService learningActivityService;

    @Autowired
    LearningOutcomeService learningOutcomeService;

    @ModelAttribute("learningOutcomes")
    public List<LearningOutcome> learningOutcomes(){return learningOutcomeService.findAll();}

    @GetMapping
    private ResponseEntity<List<LearningActivity>> listAllLearningActivity() {
        List<LearningActivity> learningActivities = learningActivityService.findAll();
        if (learningActivities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(learningActivities, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createLearningActivity(@RequestBody LearningActivity learningActivity, UriComponentsBuilder ucBuilder) {
        learningActivityService.save(learningActivity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/learningActivities/{id}").buildAndExpand(learningActivity.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
