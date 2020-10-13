package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CardsHelper extends HelperBase{
    public CardsHelper(WebDriver wd) {
        super(wd);
    }

    public void enterFirstBoard(){
        click(By.xpath("//ul[@class=\"boards-page-board-section-list\"]//li[1]"));
    }

    public void addList(){
        click(By.xpath("//div[@class='js-add-list list-wrapper mod-add is-idle']"));
        type(By.xpath("//input[@class='list-name-input']"), "Card1");
        click(By.xpath("//input[@value='Add List']"));
        type(By.xpath("//input[@class='list-name-input']"), "Card2");
        click(By.xpath("//input[@value='Add List']"));
    }

    public void addCard(){
        click(By.xpath("//a[@class=\"open-card-composer js-open-card-composer\"]"));
        type(By.xpath("//textarea[@class=\"list-card-composer-textarea js-card-title\"]"), "TestCard");
        click(By.xpath("//input[@class=\"primary confirm mod-compact js-add-card\"]"));
        click(By.xpath("//a[@class=\"icon-lg icon-close dark-hover js-cancel\"]"));
    }

    public void dragCard(){
        WebElement list1 = wd.findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a[1]"));
        WebElement list2 = wd.findElement(By.xpath("//*[@id=\"board\"]/div[2]/div/div[3]/a"));
        new Actions(wd).clickAndHold(list1).moveToElement(list2).release().perform();
    }
}
