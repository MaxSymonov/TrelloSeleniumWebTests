package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    SessionHelper session;
    BoardHelper board;

    protected void init() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
    }

    protected void stop() {
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

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    @Test()
    public boolean isBoardPresent() {

        return wd.findElements(By.xpath("//div[@title='TestBoard']")).size() > 0;
    }

    public void waitClickable(By locator) {
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.elementToBeClickable(locator));
        wait.click();
    }

    public void waitElementLocated(By locator) {
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.click();
    }

    @Test
    public void boardCreation2() {
        clickOnPlusButton();
        selectCreateBoard();
        fillBoardForm("qa25-board", "private");
        confirmBoardCreation();
        returnToHomepage();
        //personal boards count before, after
    }

    public void returnToHomepage() {
        new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mod-list-add-button")));
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName, String teamVisible) {
        //title
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), boardName);
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!!!!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }

        //public/private ("" + var + "")
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + teamVisible + "']/../.."));


//        //confirmPublic
//        if(isElementPresent(By.cssSelector(".X6LMWvod566P68"))){
//            click(By.cssSelector(".X6LMWvod566P68 button"));
//        }

        if (teamVisible.equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }

    @Test()
    public void loginWithoutAtlassian() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), "maxsimonov9@gmail.com");
        type(By.name("password"), "MaxSimonov87");
        click(By.id("login"));
    }
}
