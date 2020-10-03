package com.telran.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;
    ProfileHelper profile;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
        profile = new ProfileHelper(wd);
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public ProfileHelper getProfile() {
        return profile;
    }

    public void stop() {
        wd.quit();
    }

}
