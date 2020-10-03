package com.telran.tests.alltests;

import com.telran.tests.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() {
        //create ne instance of WebDriver (ex. open Chrome Browser)
        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }
}