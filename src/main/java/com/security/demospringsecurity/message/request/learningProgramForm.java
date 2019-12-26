package com.security.demospringsecurity.message.request;

public class learningProgramForm {
    private String learningProgram;

    public learningProgramForm(String learningProgram) {
        this.learningProgram = learningProgram;
    }

    public learningProgramForm() {
    }

    public String getLearningProgram() {
        return learningProgram;
    }

    public void setLearningProgram(String learningProgram) {
        this.learningProgram = learningProgram;
    }
}
