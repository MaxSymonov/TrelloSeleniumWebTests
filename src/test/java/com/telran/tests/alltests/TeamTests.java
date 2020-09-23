package com.telran.tests.alltests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamTests extends TestBase {

    @Test
    public void teamTests() {
        app.getSession().loginWithoutAtlassian();
        int before = app.getTeam().getTeamCount();
        app.getTeam().createTeam("TestTeam" + TimeUnit.MILLISECONDS);
        app.getTeam().removeTeam();
        app.getTeam().teamModify("NewName" + TimeUnit.MILLISECONDS, "New description", "tag" + TimeUnit.MILLISECONDS);
        app.getHeader().returnOnHomePageFromTeam();
        int after = app.getTeam().getTeamCount();
        Assert.assertNotEquals(after, before);
    }
}
