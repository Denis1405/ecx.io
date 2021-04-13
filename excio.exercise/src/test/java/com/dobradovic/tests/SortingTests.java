package com.dobradovic.tests;

import com.dobradovic.pages.Inventory;
import com.dobradovic.pages.Login;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$$;

public class SortingTests {
    Login login;
    Inventory products;

    @Before
    public void setup() {
        login = new Login();
        login.with("standard_user", "secret_sauce");
        login.assertValidLogin();
    }

    @Test
    public void validSortTests() {
        products = new Inventory();
        products.sortProducts("za");
        products.assertValidSortedItems($$("div.inventory_item_name"));
        products.sortProducts("hilo");
        products.assertValidSortedItems($$("div.inventory_item_price"));
        products.sortProducts("az");
        products.assertValidSortedItems($$("div.inventory_item_name"));
        products.sortProducts("lohi");
        products.assertValidSortedItems($$("div.inventory_item_price"));
    }


}