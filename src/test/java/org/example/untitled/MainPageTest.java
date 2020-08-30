package org.example.untitled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
        wd = new ChromeDriver(options);
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