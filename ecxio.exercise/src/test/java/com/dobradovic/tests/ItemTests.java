package com.dobradovic.tests;

import com.codeborne.selenide.SelenideElement;
import com.dobradovic.pages.Inventory;
import com.dobradovic.pages.Login;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$$;

public class ItemTests {
    Login login;
    Inventory products;

    @Before
    public void setup() {
        login = new Login();
        login.with("standard_user", "secret_sauce");
        login.assertValidLogin();
    }

    @Test
    public void validCartTests() {
        //Add and remove an item to/from cart and check the item count
        products = new Inventory();
        SelenideElement cartbutton1 = products.addToCart("Backpack");
        products.assertButtonChange(cartbutton1);
        SelenideElement cartbutton2 = products.addToCart("Bike");
        products.assertButtonChange(cartbutton2);
        products.assertShoppingCartCount();
        cartbutton1 = products.removeFromCart("Backpack");
        products.assertButtonChange(cartbutton1);
        cartbutton2 = products.removeFromCart("Bike");
        products.assertButtonChange(cartbutton2);
        products.assertShoppingCartCount();
    }


}