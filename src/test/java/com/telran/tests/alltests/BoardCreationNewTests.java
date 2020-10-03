package com.telran.tests.alltests;

import com.telran.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationNewTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"1DPboard", "public"});
        list.add(new Object[]{"1D-Pboard", "public"});
        list.add(new Object[]{"1", "public"});
        list.add(new Object[]{"!@&$", "public"});

        return list.iterator();
    }

    @Test(dataProvider = "validBoards")
    public void boardCreation(String boardName, String teamVisibility) {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getHeader().selectCreateBoard();
        Board board = new Board().setBoardName(boardName).setTeamVisible(teamVisibility);
        //app.getBoard().fillBoardForm(new Board().setBoardName("NewTeam").setTeamVisible("public"));
        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getHeader().returnToHomepageFromBoard();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }
}