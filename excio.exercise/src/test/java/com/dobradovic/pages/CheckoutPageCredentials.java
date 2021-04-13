package com.dobradovic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutPageCredentials {
    private SelenideElement quantityBox= $("div.cart_quantity");
    private ElementsCollection itemheader= $$("div.inventory_item_name");
    private SelenideElement postalCode= $("#postal-code");
    private SelenideElement continueButton = $("#continue");
    private SelenideElement cancelButton = $("#cancel");



}
