package com.telran.tests.framework;

import com.telran.tests.model.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
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

        //now selenium runs on Atlassian page
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);
    }

    public void uploadFile(By locator, File file) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void changeAvatar() throws InterruptedException {
        takeScreenshot();
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"));
        new Actions(wd).moveToElement(avatar).perform();
        click(By.cssSelector(".sc-iuJeZd"));
        Thread.sleep(2000);

        click(By.xpath("//*[@data-role='droplistContent']//*[@role='menuitem'][1]"));
        Thread.sleep(2000);
        //click(By.cssSelector("#'image-input'"));
        uploadFile(By.xpath("//*[@id='image-input']"), new File("C:/Users/Elena/Documents/GitHub/QA25TrelloSeleniumWebTests/src/test/resources/cat_small1.png"));
//confirm upload
        Thread.sleep(2000);
        click(By.xpath("//button[@class='css-1l4j2co']"));
        Thread.sleep(3000);

        takeScreenshot();
    }

}
