package com.telran.tests.alltests;

import org.testng.annotations.Test;

public class UsersProfileModifiicationTests extends TestBase{

    @Test
    public void testChangeUserAvatar(){
        app.getHeader().clickOnAvatar();
        app.getHeader().openProfile();
        app.getProfile().switchToAtlassianAccWindow();
        app.getProfile().changeAvatar();
    }
}
