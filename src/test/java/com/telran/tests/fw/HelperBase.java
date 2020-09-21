package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    public WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void selectDropdown(By locator, int index){
        Select listbox = new Select(wd.findElement(locator));
        listbox.selectByIndex(index);
    }

    public void selectDropdownKeysDown(By locator){
        WebElement selectKeysDown = wd.findElement(locator);
        selectKeysDown.click();
        Actions keyDown = new Actions(wd);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
    }

    public void waitClickable(By locator) {
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.elementToBeClickable(locator));
        wait.click();
    }

    public void waitElementLocated(By locator) {
        WebElement wait = new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
}
