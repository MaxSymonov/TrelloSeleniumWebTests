package com.telran.tests.model;

public class Board {
    private String boardName;
    private String teamVisible;

    public Board setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board setTeamVisible(String teamVisible) {
        this.teamVisible = teamVisible;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getTeamVisible() {
        return teamVisible;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                ", teamVisible='" + teamVisible + '\'' +
                '}';
    }
}
