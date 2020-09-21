package com.telran.tests.alltests;

import org.testng.annotations.Test;

public class TeamTests extends TestBase {

    @Test
    public void teamTests(){
        app.getSession().loginWithoutAtlassian();
        app.getTeam().createTeam();
        app.getTeam().removeTeam();
    }
}
