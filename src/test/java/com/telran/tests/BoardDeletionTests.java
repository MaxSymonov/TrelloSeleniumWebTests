package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{
    @Test
    public void boardDeletion(){
        login();
        int before = getBoardsCount();
        enterBoard();
        closeBoard();
        backToMain();
        int after = getBoardsCount();
        Assert.assertEquals(after, before-1);
    }
    public int getBoardsCount() {
        int res= wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    public void backToMain() {
        click(By.xpath("//a[@data-test-id='header-home-button']"));
    }

    public void closeBoard() {
        waitElementLocated(By.xpath("//*[@id='content']//a[contains(@class, 'js-close-board')]"));
        waitClickable(By.xpath("//*[@id=\"chrome-container\"]//*[@class='js-confirm full negate']"));
    }

    public void enterBoard() {
        waitClickable(By.xpath("//*[@id='content']//a[@class='board-tile']"));
        waitClickable(By.xpath("//*[@id='content']//a[contains(@class, 'js-open-more')]"));
    }

    public void login(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"),"maxsimonov9@gmail.com");
        type(By.name("password"),"MaxSimonov87");
        click(By.id("login"));
    }
}
