package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.LearningProgram;
import com.security.demospringsecurity.model.Objective;
import com.security.demospringsecurity.security.service.LearningProgramService;
import com.security.demospringsecurity.security.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/objectives")
public class ObjectiveController {
    @Autowired
    private ObjectiveService objectiveService;

    @Autowired
    private LearningProgramService learningProgramService;

    @ModelAttribute("learningProgram")
    public List<LearningProgram> kindOfQuestions() {
        return learningProgramService.findAll();
    }

    @GetMapping
    private ResponseEntity<List<Objective>> listAllQuestion() {
        List<Objective> objectives = objectiveService.findAll();
        if (objectives.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(objectives, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createObjective(@RequestBody Objective objective, UriComponentsBuilder ucBuilder) {
        objectiveService.save(objective);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/objectives/{id}").buildAndExpand(objective.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Objective> getObjectiveById(@PathVariable Long id) {
        Optional<Objective> objective = objectiveService.findById(id);
        if (objective.isPresent()) {
            return new ResponseEntity<>(objective.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Objective> updateObjective(@PathVariable Long id, @RequestBody Objective objective) {
        Optional<Objective> currentObjective = objectiveService.findById(id);
        if (currentObjective.isPresent()) {
            currentObjective.get().setId(objective.getId());
            currentObjective.get().setObjective(objective.getObjective());
            currentObjective.get().setLearningOutcomes(objective.getLearningOutcomes());
            currentObjective.get().setLearningProgram(objective.getLearningProgram());

            objectiveService.save(currentObjective.get());
            return new ResponseEntity<>(currentObjective.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Objective> deleteObjective(@PathVariable Long id) {
        Optional<Objective> objective = objectiveService.findById(id);
        if (objective.isPresent()) {
            objectiveService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
