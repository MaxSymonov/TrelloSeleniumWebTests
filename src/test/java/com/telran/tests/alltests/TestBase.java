package com.telran.tests.alltests;

import com.telran.tests.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        //create ne instance of WebDriver (ex. open Chrome Browser)
        app.init();

    }

    @AfterClass(enabled = false)
    public void tearDown() {
        app.stop();

    }

}