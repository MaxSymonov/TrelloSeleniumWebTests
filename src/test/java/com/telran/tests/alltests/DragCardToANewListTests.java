package com.telran.tests.alltests;

import org.testng.annotations.Test;

public class DragCardToANewListTests extends TestBase{
    @Test
    public void dragTests(){
        app.getCards().enterFirstBoard();
        app.getCards().addList();
        app.getCards().addCard();
    }
}
