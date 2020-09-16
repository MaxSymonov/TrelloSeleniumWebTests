package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoginErrorPresent() {
        return isElementPresent(By.cssSelector("#login-error"));
    }

    public void login(String email, String pwd) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        //fillLoginFom
        //fill email
        type(By.name("user"), email);
        //clickOnLoginWithAtlassianButton
        click(By.id("login"));
        Thread.sleep(10000);
        //fillPassword
        type(By.id("password"), pwd);
        //confirm login
        click(By.id("login-submit"));
    }

    @Test()
    public void loginWithoutAtlassian() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), "maxsimonov9@gmail.com");
        type(By.name("password"), "MaxSimonov87");
        click(By.id("login"));
    }
}

