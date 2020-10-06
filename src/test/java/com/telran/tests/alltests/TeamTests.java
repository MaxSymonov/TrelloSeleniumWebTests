package com.telran.tests.alltests;

import com.telran.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> teams() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("/src/test/resources/teams.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Team().setTeamName(split[0]).setNewDescription(split[1]).setNewTag(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "teams")
    public void teamTests(String teamName, String newDescription, String newTag) {
        int before = app.getTeam().getTeamCount();
        //app.getTeam().createTeam(new Team().setTeamName("TestBoard" + System.currentTimeMillis()));
        app.getTeam().createTeam(new Team().setTeamName(teamName));
        app.getTeam().removeTeam();
        Team team = new Team().setTeamName(teamName).setNewDescription(newDescription).setNewTag(newTag);
        app.getTeam().teamModify(team);
        app.getHeader().returnOnHomePageFromTeam();
        int after = app.getTeam().getTeamCount();
        Assert.assertNotEquals(after, before);
    }
}
