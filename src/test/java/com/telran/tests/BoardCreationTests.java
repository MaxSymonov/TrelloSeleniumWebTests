package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


    @Test()
    public void loginWithoutAtlassian(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"),"maxsimonov9@gmail.com");
        type(By.name("password"),"MaxSimonov87");
        click(By.id("login"));
    }

    @Test(dependsOnMethods = {"loginWithoutAtlassian"})
    public void createBoard() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test-id='create-board-title-input']")));
        wait.sendKeys("TestBoard");
        WebElement wait2 = new WebDriverWait(wd, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layer-manager-overlay']//button[@data-test-id='create-board-submit-button']")));
        wait2.click();
    }

    @Test(dependsOnMethods = {"createBoard"})
    public void backToMain(){
        click(By.cssSelector("[class='_2ZNy4w8Nfa58d1 _2ZNy4w8Nfa58d1 _1WD42rQsKIT-I6']"));

    }

    @Test(dependsOnMethods = {"backToMain"})
    public void checkTable(){
        Assert.assertTrue(isBoardPresent());
    }
}
