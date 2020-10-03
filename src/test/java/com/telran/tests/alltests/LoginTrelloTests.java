package com.telran.tests.alltests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getHeader().isAvatarPresent()) {
            app.getHeader().logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        app.getSession().login("rochman.elena@gmail.com", "12345.com");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(app.getHeader().isAvatarPresent());
        //is user correct

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        app.getSession().login("maxsimonov9@gmail.com", "MaxSimonooov87");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(app.getSession().isLoginErrorPresent());
        Assert.assertFalse(app.getHeader().isAvatarPresent());

    }

}
