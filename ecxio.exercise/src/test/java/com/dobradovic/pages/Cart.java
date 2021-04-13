package com.dobradovic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Cart {
    private String quantityCounter= $("div.cart_quantity").getText();
    private SelenideElement continueShoppingButton = $("#continue-shopping");

    public void checkQuantity(int numberOfItems) {
        quantityCounter.equals(""+numberOfItems);
    }

    public void checkOut() {
        $("#checkout").click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }

    public void assertCorrectItemInCart() {

    }
}
