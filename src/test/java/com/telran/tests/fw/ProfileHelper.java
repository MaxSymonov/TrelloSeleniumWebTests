package com.telran.tests.fw;

import com.telran.tests.model.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
