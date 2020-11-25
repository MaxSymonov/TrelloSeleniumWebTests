package com.telran.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Properties properties;
    public WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;
    ProfileHelper profile;
    CardsHelper cards;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws IOException, InterruptedException {
        String target = System.getProperty("target", "trelloWeb");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to(properties.getProperty("web.url"));

        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
        profile = new ProfileHelper(wd);

        getSession().login(properties.getProperty("web.user"), properties.getProperty("web.password"));
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

    public CardsHelper getCards() {
        return cards;
    }

    public void stop() {
        wd.quit();
    }

}
