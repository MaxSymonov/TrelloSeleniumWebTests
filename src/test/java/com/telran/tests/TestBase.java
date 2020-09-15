package com.telran.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(){
        //create ne instance of WebDriver (ex. open Chrome Browser)
        app.init();

        //open Site
        app.wd.navigate().to("https://trello.com/");

    }

    @AfterClass(enabled = false)
    public void tearDown(){
        app.stop();

    }


}