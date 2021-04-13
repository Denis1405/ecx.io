package com.dobradovic.tests;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.dobradovic.pages.Inventory;
import com.dobradovic.pages.Login;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class Meins {
    Login login;
    Inventory products;

    @Before
    public void setup() {
        login = new Login();
        login.with("problem_user", "secret_sauce");
        login.assertValidLogin();
        /*
        products = new Inventory();
        products.sortProducts("lohi");
        products.assertValidSortedItems($$("div.inventory_item_price"));
        products.assertButtonChange(products.addToCart("Backpack"));
        products.assertShoppingCartCount();

        $("a.shopping_cart_link").click();
        $("#checkout").click();
        $("#first-name").val("Eins");
        $("#last-name").val("Zwei");
        $("#postal-code").val("1234");
        $("#continue").click();
        $("#finish").click();
         */
    }

    @Test
    public void meins () {

        System.out.println($("@/static/media/sl-404.168b1cce.jpg").shouldHave(Condition.attribute("src")));


    }

}


