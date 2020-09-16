package com.telran.tests.alltests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @Test
    public void boardDeletion() {
        app.getSession().loginWithoutAtlassian();
        int before = app.getBoard().getBoardsCount();
        app.getBoard().enterBoard();
        app.getBoard().closeBoard();
        app.getHeader().backToMain();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

}
