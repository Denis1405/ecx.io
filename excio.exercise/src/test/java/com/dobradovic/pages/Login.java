package com.dobradovic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class Login {
    private SelenideElement usernameLocator = $("#user-name");
    private SelenideElement passwordLocator = $("#password");
    private SelenideElement loginButton = $("#login-button");
    private SelenideElement shoppingCartLocator = $("#shopping_cart_container");
    private ElementsCollection dogImages = $$("@src='/static/media/sl-404.168b1cce.jpg'");
    private SelenideElement errorBox = $("div.error-message-container error");

    public Login () {
        open("https://www.saucedemo.com/");
    }

    public void with(String username, String password) {
        $(usernameLocator).val(username);
        $(passwordLocator).val(password);
        $(loginButton).click();
    }
    public void assertValidLogin() {
        $(shoppingCartLocator).should(Condition.visible, Duration.ofSeconds(4));
    }

    public void assertInValidLogin(String username) {
        switch (username) {
            case "locked_out_user":
                errorBox.shouldHave(Condition.text("Epic sadface: Sorry, this user has been locked out."));
                break;

            case "problem_user":
                for(SelenideElement img : dogImages)

                break;


        }
    }
}

