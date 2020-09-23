package com.telran.tests.alltests;

import com.telran.tests.model.Team;
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
        app.getTeam().teamModify(new Team().setNewTestName("NewName" + TimeUnit.MILLISECONDS).setNewDescription("New description").setNewTag("tag" + TimeUnit.MILLISECONDS));
        app.getHeader().returnOnHomePageFromTeam();
        int after = app.getTeam().getTeamCount();
        Assert.assertNotEquals(after, before);
    }
}
