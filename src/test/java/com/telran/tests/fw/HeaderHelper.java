package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void returnToHomepageFromBoard() {
        new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mod-list-add-button")));
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void returnOnHomePageFromTeam() {
        waitElementLocated(By.cssSelector(".tabbed-pane-header-content"));
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void backToMain() {
        click(By.xpath("//a[@data-test-id='header-home-button']"));
    }

    public void openProfile() {
        click(By.cssSelector("[data-test-id]"));
    }
}
