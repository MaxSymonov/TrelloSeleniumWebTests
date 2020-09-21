package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TeamHelper extends HelperBase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }
    @Test
    public void createTeam() {

        click(By.xpath("//*[@id='content']//button[@data-test-id='home-navigation-create-team-button']"));
        type(By.xpath("//*[@data-test-id='header-create-team-name-input']"), "TestTeam");
        click(By.xpath("//*[@data-test-id='header-create-team-type-input']"));
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));

        type(By.xpath("//*[contains(@id,'create-team-org-description')]"), "Test description");
        click(By.xpath("//*[@data-test-id='header-create-team-submit-button']"));
        click(By.xpath("//*[@class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']"));

        //IfExists
        ifTeamExists();
    }
    @Test
    public void removeTeam(){
        click(By.xpath("//*[@id='content']//*[@data-test-id='home-team-tab-name']"));
        click(By.xpath("//*[@id='content']//ul[@class='_1T7jXM3PAP_MoF']/li[4]/a"));
        waitElementLocated(By.xpath("//*[@id='content']//a[@class='quiet-button']"));
        waitElementLocated(By.xpath("//*[@id='chrome-container']//*[@class='js-confirm full negate']"));

        //IfRemoved
        ifTeamNotExists();
    }

    public boolean ifTeamExists(){
        return wd.findElements(By.xpath("//*[contains(text(),'TestTeam')]")).size()>0;}

    public boolean ifTeamNotExists(){
        return wd.findElements(By.xpath("//*[contains(text(),'TestTeam')]")).size()<=0;
    }
}
