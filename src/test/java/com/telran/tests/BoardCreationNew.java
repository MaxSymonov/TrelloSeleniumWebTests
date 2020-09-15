package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationNew extends TestBase {
    @Test
    public void boardCreation() {
        int before = getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoard();
        app.fillBoardForm("new qa25 board", "public");
        app.confirmBoardCreation();
        app.returnToHomepage();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }

    public int getBoardsCount() {
        int res = app.wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }

}