package com.dobradovic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPageOverview {
    private SelenideElement quantityBox= $("div.cart_quantity");
    private ElementsCollection itemheader= $$("div.inventory_item_name");
    private ElementsCollection priceTags = $$("div.inventory_item_price");
    ElementsCollection sauces = $$("div.summary_value_label");
    private SelenideElement itemTotal = $("div.summary_subtotal_label");
    private SelenideElement tax = $("div.summary_tax_label");
    private SelenideElement total = $("div.summary_total_label");
    private SelenideElement finishButton = $("#finish");
    private SelenideElement cancelButton = $("#cancel");

}
