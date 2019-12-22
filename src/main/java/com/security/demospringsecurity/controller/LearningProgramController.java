package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.LearningProgram;
import com.security.demospringsecurity.security.service.LearningProgramService;
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
@RequestMapping("/api/auth/learningPrograms")
public class LearningProgramController {
    @Autowired
    private LearningProgramService learningProgramService;

    @GetMapping
    private ResponseEntity<List<LearningProgram>> listAllLearningProgram() {
        List<LearningProgram> learningPrograms = learningProgramService.findAll();
        if (learningPrograms.isEmpty()) {
            return new ResponseEntity<List<LearningProgram>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LearningProgram>>(learningPrograms, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createLearningProgram(@RequestBody LearningProgram learningProgram, UriComponentsBuilder ucBuilder) {
        learningProgramService.save(learningProgram);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/learningPrograms/{id}").buildAndExpand(learningProgram.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<LearningProgram> getLearningProgramById(@PathVariable Long id) {
        Optional<LearningProgram> learningProgram = learningProgramService.findById(id);
        if (learningProgram.isPresent()) {
            return new ResponseEntity<>(learningProgram.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    private ResponseEntity<LearningProgram> updateLearningProgram(@PathVariable Long id, @RequestBody LearningProgram learningProgram) {
        Optional<LearningProgram> currentLearningProgram = learningProgramService.findById(id);
        if (currentLearningProgram.isPresent()) {
            currentLearningProgram.get().setLearningProgram(learningProgram.getLearningProgram());
            currentLearningProgram.get().setId(learningProgram.getId());
            currentLearningProgram.get().setObjectives(learningProgram.getObjectives());

            learningProgramService.save(currentLearningProgram.get());

            return new ResponseEntity<LearningProgram>(currentLearningProgram.get(), HttpStatus.OK);
        }

        return new ResponseEntity<LearningProgram>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    private ResponseEntity<LearningProgram> deleteLearningProgram(@PathVariable Long id) {

        Optional<LearningProgram> learningProgram = learningProgramService.findById(id);
        if (learningProgram.isPresent()) {
            learningProgramService.remove(id);
            return new ResponseEntity<LearningProgram>(HttpStatus.OK);
        }


        return new ResponseEntity<LearningProgram>(HttpStatus.NOT_FOUND);

    }
}
