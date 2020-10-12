package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    }
}
