package com.telran.tests.model;

public class Team {
    private String newTestName;
    private String newDescription;
    private String newTag;

    public Team setNewTestName(String newTestName) {
        this.newTestName = newTestName;
        return this;
    }

    public Team setNewDescription(String newDescription) {
        this.newDescription = newDescription;
        return this;
    }

    public Team setNewTag(String newTag) {
        this.newTag = newTag;
        return this;
    }

    public String getNewTestName() {
        return newTestName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public String getNewTag() {
        return newTag;
    }
}
