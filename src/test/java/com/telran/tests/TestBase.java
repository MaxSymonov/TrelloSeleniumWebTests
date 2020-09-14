package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        //create ne instance of WebDriver (ex. open Chrome Browser)
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //open Site
        wd.navigate().to("https://trello.com/");

    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }


    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    protected boolean isLoginErrorPresent() {
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

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean isAvatarPresent(){
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    @Test()
    public boolean isBoardPresent(){

        return wd.findElements(By.xpath("//div[@title='TestBoard']")).size() > 0;
    }
    public void waitClickable(By locator){
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.elementToBeClickable(locator));
        wait.click();
    }

    public void waitElementLocated(By locator){
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.click();
    }

}