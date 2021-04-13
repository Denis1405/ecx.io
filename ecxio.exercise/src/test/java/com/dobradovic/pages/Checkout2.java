package com.dobradovic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Checkout2 {
    private SelenideElement quantityBox= $("div.cart_quantity");
    private ElementsCollection itemheader= $$("div.inventory_item_name");
    private ElementsCollection priceTags = $$("div.inventory_item_price");
    ElementsCollection infoLabels = $$("div.summary_value_label");
    ElementsCollection valueLabels = $$("div.summary_value_label");
    List<String> prices= priceTags.texts();
    private SelenideElement itemTotal = $("div.summary_subtotal_label");
    private SelenideElement tax = $("div.summary_tax_label");
    private SelenideElement total = $("div.summary_total_label");
    private SelenideElement finishButton = $("#finish");
    private SelenideElement cancelButton = $("#cancel");


    public void checkQuantity(int numberOfItems) {
        quantityBox.equals(""+numberOfItems);
    }

    public void finishCheckout() {
        finishButton.click();
    }

    public void cancelCheckout() {
        cancelButton.click();
    }

    public void assertCorrectTotalAmount() {
        // muss noch überarbeitet werden (float problem)
        List<Float> rightPrices = new ArrayList<Float>();
        for (String price : prices) {
            rightPrices.add(Float.parseFloat(price.substring(1)));
        }

        float totalAmount = rightPrices.get(0);

        for(int i=0; i < rightPrices.size()-1; i++) {
            totalAmount += rightPrices.get(i);
        }

        itemTotal.shouldBe(Condition.text(""+totalAmount));
        totalAmount += Float.parseFloat(tax.getText().substring(1));
        total.shouldBe(Condition.text(""+totalAmount));
    }
}


