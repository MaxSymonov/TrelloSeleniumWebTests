package com.telran.tests.alltests;

import com.telran.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationNewTests extends TestBase {


    @Test(dataProvider = "validBoards", dataProviderClass = DataProviders.class)
    public void boardCreation(Board board) {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getHeader().selectCreateBoard();
        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getHeader().returnToHomepageFromBoard();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test(dataProvider = "validBoardsFromCSV", dataProviderClass = DataProviders.class)
    public void boardCreationFromCSV(Board board) {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getHeader().selectCreateBoard();
        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getHeader().returnToHomepageFromBoard();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }
}