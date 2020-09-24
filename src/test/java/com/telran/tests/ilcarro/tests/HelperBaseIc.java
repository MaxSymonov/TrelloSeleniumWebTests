package com.telran.tests.ilcarro.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBaseIc {
    public WebDriver wd;

    public void click (By locator){
        wd.findElement(locator).click();
    }

    public void login(){
        click(By.xpath("//ul[@class='header__nav desktop']//li[5]/a"));
        type(By.xpath("//input[@type='email']"), "test9@test.com");
        type(By.xpath("//input[@type='password']"), "MaxSimonov87");
        click(By.xpath("//input[@type='submit']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitElementLocated(By locator) {
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.click();
    }

    public void waitElementLocatedType(By locator, String text) {
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.clear();
        wait.sendKeys(text);
    }
}
