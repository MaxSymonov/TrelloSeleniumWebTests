package com.telran.tests.alltests;

import com.telran.tests.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        //create ne instance of WebDriver (ex. open Chrome Browser)
        app.init();
        app.getSession().loginWithoutAtlassian();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Tests started" + m.getName() + " with parameters: " + Arrays.asList(p));
    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("Tests stopped" + m.getName());
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }
}