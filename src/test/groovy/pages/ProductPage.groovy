package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement btnAddToCart = $('p#add_to_cart button');
    private SelenideElement btnProceedToCheckout = $('a[title="Proceed to checkout"]')

    def hasDisplayed() {
        btnAddToCart.shouldBe(Condition.visible);
        return btnAddToCart.is(Condition.visible);
    }

    def hasAddedProductToCart() {
        btnProceedToCheckout.shouldBe(Condition.visible);
        return btnProceedToCheckout.is(Condition.visible);
    }

    def addProductToCart() {
        btnAddToCart.click();
        return this;
    }

    def proceedToCheckout() {
        btnProceedToCheckout.click();
        return new CartPage();
    }
}
