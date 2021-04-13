package com.dobradovic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Checkout1 {
    private SelenideElement firstName= $("#first-name");
    private SelenideElement lastName = $("#last-name");
    private SelenideElement postalCode= $("#postal-code");
    private SelenideElement continueButton = $("#continue");
    private SelenideElement cancelButton = $("#cancel");

    public void insertUserInformation(String firstName, String lastName, String postalCode) {
        this.firstName.val(firstName);
        this.lastName.val(lastName);
        this.postalCode.val(postalCode);
    }

    public void goToNextPage() {
        continueButton.click();
    }

    public void cancelOrder() {
        cancelButton.click();
    }

}
