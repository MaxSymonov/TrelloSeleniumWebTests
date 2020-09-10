package com.telran.tests;

import org.openqa.selenium.By;
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
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), "TestBoard");
        click(By.xpath("//*[@id='layer-manager-overlay']//button[@data-test-id='create-board-submit-button']"));    }

    @Test(dependsOnMethods = {"createBoard"})
    public void backToMain(){
        click(By.cssSelector("[class='_2ZNy4w8Nfa58d1 _2ZNy4w8Nfa58d1 _1WD42rQsKIT-I6']"));

    }

    @Test(dependsOnMethods = {"backToMain"})
    public void checkTable(){
        Assert.assertTrue(isBoardPresent());
    }
}
