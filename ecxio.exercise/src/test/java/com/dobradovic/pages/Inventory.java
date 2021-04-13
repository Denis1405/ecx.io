package com.dobradovic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Inventory {

    private SelenideElement title= $("span.title");
    private SelenideElement peekImg= $("div.peek");
    private ElementsCollection itemImages = $$("img.inventory_item_img");
    private SelenideElement productSortContainer = $("select.product_sort_container");
    private SelenideElement shoppingCartBadge = $("span.shopping_cart_badge");
    public int itemCounter = 0;
    private ElementsCollection itemNames = $$("div.inventory_item_name");
    private ElementsCollection priceTags = $$("div.inventory_item_price");
    private List<String> headlines = itemNames.texts();
    private List<String> pricesWithDollarSign = priceTags.texts();
    private List<Double> prices = new ArrayList<Double>();


    public void sortProducts(String value) {
        // options: az, za, lohi, hilo
        switch (value) {
            case "az":
                $(productSortContainer).click();
                $("select.product_sort_container > option:nth-child(1)").click();
                headlines.sort(Comparator.naturalOrder());
                System.out.println("Items are sorted in ascending order by name.");
                break;

            case "za":
                $(productSortContainer).click();
                $("select.product_sort_container > option:nth-child(2)").click();
                headlines.sort(Comparator.reverseOrder());
                System.out.println("Items are sorted in descending order by name.");
                break;

            case "lohi":
                $(productSortContainer).click();
                $("select.product_sort_container > option:nth-child(3)").click();
                for (String element : pricesWithDollarSign) {
                    prices.add(Double.parseDouble(element.substring(1)));
                }
                prices.sort(Comparator.naturalOrder());
                System.out.println("Items are sorted in ascending order by price.");
                break;

            case "hilo":
                $(productSortContainer).click();
                $("select.product_sort_container > option:nth-child(4)").click();
                for (String element : pricesWithDollarSign) {
                    prices.add(Double.parseDouble(element.substring(1)));
                }
                prices.sort(Comparator.reverseOrder());
                System.out.println("Items are sorted in descending order by price.");
                break;

            default:
                System.out.println("The entered value: " + value + " is not a sorting option");
                break;
        }
    }
    public void assertValidSortedItems(ElementsCollection elements) {
        if (elements.texts().equals(headlines)) {
            System.out.println("Items are sorted according to their headlines: ");
            for (int i = 0; i < itemNames.size(); i++) {
                if (elements.get(i).getText().equals(headlines.get(i))) {
                    elements.get(i).getText();
                }
            }
        }
        else {
            System.out.println("Items are sorted according to their prices:");
            for (int j = 0; j < prices.size(); j++) {
                if (elements.get(j).getText().substring(1).equals(prices.get(j).toString())) {
                    System.out.println(elements.get(j).getText());
                }
            }
        }
    }
    public SelenideElement addToCart(String item) {
        //BackPack, Bike, Bolt, Fleece, Onesie, Things, Backpack will be returned if nothing matches
        switch (item) {
            case "Backpack":
                $("#add-to-cart-sauce-labs-backpack").click();
                itemCounter++;
                System.out.println("Button was changed to Remove Button");
                return $("#remove-sauce-labs-backpack");

            case "Bike":
                $("#add-to-cart-sauce-labs-bike-light").click();
                itemCounter++;
                System.out.println("Button was changed to Remove Button");
                return $("#remove-sauce-labs-bike-light");

            case "Bolt":
                $("#add-to-cart-sauce-labs-bolt-t-shirt").click();
                itemCounter++;
                System.out.println("Button was changed to Remove Button");
                return $("#remove-sauce-labs-bolt-t-shirt");

            case "Fleece":
                $("#add-to-cart-sauce-labs-fleece-jacket").click();
                itemCounter++;
                System.out.println("Button was changed to Remove Button");
                return $("#remove-sauce-labs-fleece-jacket");

            case "Onesie":
                $("#add-to-cart-sauce-labs-onesie").click();
                itemCounter++;
                System.out.println("Button was changed to Remove Button");
                return $("#remove-sauce-labs-onesie");

            case "Things":
                $("#add-to-cart-test.allthethings()-t-shirt-(red)").click();
                itemCounter++;
                System.out.println("Button was changed to Remove Button");
                return $("#remove-test.allthethings()-t-shirt-(red)");

            default:
                System.out.println("The entered item: " + item + " is not on the list");
        }
        return null;
    }
    public SelenideElement removeFromCart(String item) {
        //BackPack, Bike, Bolt, Fleece, Onesie, Things, Backpack will be returned if nothing matches
        switch (item) {
            case "Backpack":
                $("#remove-sauce-labs-backpack").click();
                itemCounter--;
                System.out.println("Button was changed to Add Button");
                return $("#add-to-cart-sauce-labs-backpack");

            case "Bike":
                $("#remove-sauce-labs-bike-light").click();
                itemCounter--;
                System.out.println("Button was changed to Add Button");
                return $("#add-to-cart-sauce-labs-bike-light");

            case "Bolt":
                $("#remove-sauce-labs-bolt-t-shirt").click();
                itemCounter--;
                System.out.println("Button was changed to Add Button");
                return $("#add-to-cart-sauce-labs-bolt-t-shirt");

            case "Fleece":
                $("#remove-sauce-labs-fleece-jacket").click();
                itemCounter--;
                System.out.println("Button was changed to Add Button");
                return $("#add-to-cart-sauce-labs-fleece-jacket");

            case "Onesie":
                $("#remove-sauce-labs-onesie").click();
                itemCounter--;
                System.out.println("Button was changed to Add Button");
                return $("#add-to-cart-sauce-labs-onesie");

            case "Things":
                $("#remove-test.allthethings()-t-shirt-(red)").click();
                itemCounter--;
                System.out.println("Button was changed to Add Button");
                return $("#add-to-cart-test.allthethings()-t-shirt-(red)");

            default:
                System.out.println("The entered item: " + item + " is not on the list");
        }
        return null;
    }
    public void assertButtonChange(SelenideElement button) {
        if (button.getText().equals("REMOVE")) {
            button.shouldHave(Condition.text("REMOVE"));
        }
        if (button.getText().equals("ADD TO CART")) {
            button.shouldHave(Condition.text("ADD TO CART"));
        }
    }
    public void assertShoppingCartCount() {
        if(shoppingCartBadge.exists()) {
            shoppingCartBadge.shouldHave(Condition.text("" + itemCounter));
            System.out.println("There is/are " + itemCounter + " item(s) in the cart" );
        }
        else {
            System.out.println("There are 0 Items in shopping Cart: Badge is not visible!");
        }
    }
    public void goToCartPage() {
        $("a.shopping_cart_link").click();
    }
    public void checkVisibleObjects() {
        title.should(Condition.visible).shouldHave(Condition.text("Products"));
        peekImg.should(Condition.visible);
        for (SelenideElement img : itemImages){
            img.shouldBe(Condition.visible);
        }
    }
}
