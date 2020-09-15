package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test()
    public void loginWithoutAtlassian() {
        app.click(By.cssSelector("[href='/login']"));
        app.type(By.name("user"), "maxsimonov9@gmail.com");
        app.type(By.name("password"), "MaxSimonov87");
        app.click(By.id("login"));
    }


    @Test(dependsOnMethods = {"loginWithoutAtlassian"})
    public void createBoard() {
        app.clickOnPlusButton();
        app.selectCreateBoard();
        WebElement wait = new WebDriverWait(app.wd, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test-id='create-board-title-input']")));
        wait.sendKeys("TestBoard");
        WebElement wait2 = new WebDriverWait(app.wd, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layer-manager-overlay']//button[@data-test-id='create-board-submit-button']")));
        wait2.click();
    }

    @Test(dependsOnMethods = {"createBoard"})
    public void backToMain(){
        app.click(By.xpath("//a[@data-test-id='header-home-button']"));

    }

    @Test(dependsOnMethods = {"backToMain"})
    public void checkTable(){
        Assert.assertTrue(app.isBoardPresent());
    }
}
