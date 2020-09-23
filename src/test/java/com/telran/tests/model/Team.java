package com.telran.tests.model;

public class Team {
    private String TeamName;
    private String newDescription;
    private String newTag;

    public Team setTeamName(String TeamName) {
        this.TeamName = TeamName;
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

    public String getTeamName() {
        return TeamName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public String getNewTag() {
        return newTag;
    }
}
