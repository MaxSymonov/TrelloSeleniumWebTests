package com.telran.tests.alltests;

import com.telran.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationNewTests extends TestBase {
    @Test
    public void boardCreation() {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getHeader().selectCreateBoard();
        app.getBoard().fillBoardForm(new Board().setBoardName("NewTeam").setTeamVisible("public"));
        app.getBoard().confirmBoardCreation();
        app.getHeader().returnToHomepage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }
}