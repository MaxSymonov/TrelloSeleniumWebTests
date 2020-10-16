package com.telran.tests.framework;

import com.telran.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardForm(Board board) {
        //title
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), board.getBoardName());
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!!!!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }

        //public/private ("" + var + "")
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + board.getTeamVisible() + "']/../.."));


//        //confirmPublic
//        if(isElementPresent(By.cssSelector(".X6LMWvod566P68"))){
//            click(By.cssSelector(".X6LMWvod566P68 button"));
//        }

        if (board.getTeamVisible().equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }

    public boolean isBoardPresent() {

        return wd.findElements(By.xpath("//div[@title='TestBoard']")).size() > 0;
    }

    public void enterBoard() {
        waitClickable(By.xpath("//*[@id='content']//li[@class='boards-page-board-section-list-item']"));
        waitClickable(By.xpath("//*[@id='content']//a[contains(@class, 'js-open-more')]"));
    }

    public void closeBoard() {
        waitElementLocated(By.xpath("//*[@id='content']//a[contains(@class, 'js-close-board')]"));
        waitClickable(By.xpath("//*[@id=\"chrome-container\"]//*[@class='js-confirm full negate']"));
    }

    public boolean isOnBoardsPage() {
        String personalBoards = "//*[@class='icon-lg icon-member']/../../..//li" ;
        new WebDriverWait(wd, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(personalBoards)));
        return  isElementPresent(By.xpath(personalBoards));
    }

    public void returnToBoardsPage() {
        //click(By.cssSelector(".home-left-sidebar-container .icon-board"));
        waitElementLocated(By.cssSelector(".home-left-sidebar-container .icon-board"));
    }
}
