package com.dobradovic.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dobradovic.pages.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class StraightThrough {
    Login loginPage;
    Inventory productPage;
    Cart cartPage;
    Checkout1 userInformation;
    Checkout2 overview;
    Checkout3 orderComplete;


    @Test
    public void StraightThrough() {
        int itemsInCart = 0;
        loginPage = new Login();
        loginPage.with("standard_user", "secret_sauce");
        loginPage.assertValidLogin();
        productPage = new Inventory();
        productPage.sortProducts("lohi");
        productPage.assertValidSortedItems($$("div.inventory_item_price"));
        productPage.assertButtonChange(productPage.addToCart("Backpack"));
        itemsInCart++;
        productPage.assertShoppingCartCount();
        productPage.goToCartPage();
        cartPage = new Cart();
        cartPage.checkQuantity(itemsInCart);
        cartPage.assertCorrectItemInCart(); // Muss noch gemacht werden
        cartPage.checkOut();
        userInformation = new Checkout1();
        userInformation.insertUserInformation("Hans", "Huber", "1234");
        userInformation.goToNextPage();
        overview = new Checkout2();
        overview.checkQuantity(itemsInCart);
        overview.finishCheckout();
        orderComplete = new Checkout3();
        orderComplete.assertCheckoutComplete();
        orderComplete.goBackToInventoryPage();
        productPage.checkVisibleObjects();

    }

}