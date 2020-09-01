package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().deleteAllCookies();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testLoginPositive() throws InterruptedException {
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.id("user")).sendKeys("maxsimonov9@gmail.com");
        Thread.sleep(10000);
        wd.findElement(By.id("password")).sendKeys("MaxSimonov87");
        wd.findElement(By.id("login")).click();
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}