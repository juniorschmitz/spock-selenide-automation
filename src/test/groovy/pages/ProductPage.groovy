package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement btnAddToCart = $('p#add_to_cart button');
    private SelenideElement btnProceedToCheckout = $('a[title="Proceed to checkout"]')

    def shouldBeDisplayed() {
        btnAddToCart.shouldBe(Condition.visible);
    }

    def hasAddedProductToCart() {
        btnProceedToCheckout.shouldBe(Condition.visible);
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
