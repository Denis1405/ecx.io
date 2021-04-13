package com.dobradovic.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dobradovic.pages.Inventory;
import com.dobradovic.pages.Login;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class StraightThrough {
    Login login;
    Inventory products;

    @Before
    public void setup() {
        login = new Login();
        login.with("standard_user", "secret_sauce");
        login.assertValidLogin();
    }

    @Test
    public void StraightThrough() {
        //Add and remove an item to the cart
        products = new Inventory();
        products.sortProducts("lohi");
        products.assertValidSortedItems($$("div.inventory_item_price"));
        products.assertButtonChange(products.addToCart("Backpack"));
        products.assertShoppingCartCount();
        $("a.shopping_cart_link").click();
        $("checkout").click();
        $("#checkout").click();
        $("#first-name").val("Eins");
        $("#last-name").val("Zwei");
        $("#postal-code").val("1234");
        $("#continue").click();
        $("#finish").click();
    }


}