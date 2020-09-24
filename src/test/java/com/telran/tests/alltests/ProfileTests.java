package com.telran.tests.alltests;

import com.telran.tests.model.Profile;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProfileTests extends TestBase {

    @Test
    public void testProfile(){
        String option1 = "//li[1]";
        String option2 = "//li[2]";
        String option3 = "//li[3]";
        app.getSession().loginWithoutAtlassian();
        app.getProfile().openProfile();
        app.getProfile().changePassword(new Profile().setNewPassword("Abc" + TimeUnit.MILLISECONDS).setOldPassword("Uteshitel999"));
        // 1 - never, 2 - periodically, 3- instantly
        app.getProfile().changeEmailFrequency(option1);
    }
}

