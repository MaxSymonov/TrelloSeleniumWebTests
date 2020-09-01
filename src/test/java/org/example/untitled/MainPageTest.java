package org.example.untitled;

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
        ChromeOptions options = new ChromeOptions();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().deleteAllCookies();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void login(){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.id("user")).sendKeys("maxsimonov9@gmail.com");
        wd.findElement(By.id("password")).sendKeys("MaxSimonov87");
        wd.findElement(By.id("login")).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}