package com.dobradovic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Checkout3 {
    private SelenideElement title= $("span.title");
    private SelenideElement completeHeader= $("h2.complete-header");
    private SelenideElement completeText = $("div.complete-text");
    private SelenideElement ponyImg = $("img.pony_express");
    private SelenideElement backHomeButton = $("#back-to-products");

    public void assertCheckoutComplete() {
        completeHeader.shouldHave(Condition.text("THANK YOU FOR YOUR ORDER"));
        completeText.shouldBe(Condition.text("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        ponyImg.shouldHave(Condition.attribute("src", "https://www.saucedemo.com/static/media/pony-express.46394a5d.png")).should(Condition.visible);
        backHomeButton.shouldBe(Condition.visible);
    }

    public void goBackToInventoryPage () {
        backHomeButton.click();
    }
}
