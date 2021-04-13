package com.dobradovic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPageComplete {
    private SelenideElement title= $("span.title");
    private SelenideElement completeHeader= $("h2.complete-header");
    private SelenideElement completeText = $("div.complete-text");
    private SelenideElement ponyImg = $("img.pony_express");
    private SelenideElement BackHomeButton = $("#back-to-products");

}
