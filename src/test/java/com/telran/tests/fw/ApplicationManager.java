package com.telran.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
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

    public void stop() {
        wd.quit();
    }

}
