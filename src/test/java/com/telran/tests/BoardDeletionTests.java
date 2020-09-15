package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @Test
    public void boardDeletion() {
        login();
        int before = getBoardsCount();
        enterBoard();
        closeBoard();
        backToMain();
        int after = getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

    public int getBoardsCount() {
        int res = app.wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }

    public void backToMain() {
        app.click(By.xpath("//a[@data-test-id='header-home-button']"));
    }

    public void closeBoard() {
        app.waitElementLocated(By.xpath("//*[@id='content']//a[contains(@class, 'js-close-board')]"));
        app.waitClickable(By.xpath("//*[@id=\"chrome-container\"]//*[@class='js-confirm full negate']"));
    }

    public void enterBoard() {
        app.waitClickable(By.xpath("//*[@id='content']//a[@class='board-tile']"));
        app.waitClickable(By.xpath("//*[@id='content']//a[contains(@class, 'js-open-more')]"));
    }

    public void login() {
        app.loginWithoutAtlassian();
    }
}
