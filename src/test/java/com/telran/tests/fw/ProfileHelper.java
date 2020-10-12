package com.telran.tests.fw;

import com.telran.tests.model.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase {
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void openProfile() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        click(By.xpath("//li[@class='_1pCh-d8Vg1eITK']//*[@data-test-id='header-member-menu-settings']"));
    }

    public void changePassword(Profile profile) {
        click(By.xpath("//a[contains(@class,'change-password')]"));
        type(By.xpath("//input[@name='oldpassword']"), profile.getOldPassword());
        type(By.xpath("//input[@name='password']"), profile.getNewPassword());
        type(By.xpath("//input[@name='password2']"), profile.getNewPassword());
        click(By.xpath("//input[contains(@class,'save-changes')]"));
    }

    public void changeEmailFrequency(String option) {
        click(By.xpath("//ul[@class='pop-over-list']" + option + ""));
    }


    public void switchToAtlassianAccWindow() {
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        click(By.cssSelector("a[href$=manage-profile]"));

        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()){
            wd.switchTo().window(availableWindows.get(1));
        }

        //now selenium on Atlassian page
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);
    }

    public void changeAvatar() {
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//button[contains(text(),'Change Avatar…')]"))).perform();
        click(By.cssSelector(""));
    }
}
