package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class CartPage {
    private SelenideElement btnProceedToCheckout = $('p.cart_navigation  a[title="Proceed to checkout"]');
    private SelenideElement iconDeleteProduct = $('a[title="Delete"]');
    private SelenideElement messageDeletedProduct = $('.alert-warning');

    def hasDisplayed() {
        return btnProceedToCheckout.is(Condition.visible);
    }

    def removeProduct() {
        iconDeleteProduct.click();
        return this;
    }

    def hasDeletedProduct() {
        return messageDeletedProduct.text().contains('Your shopping cart is empty.');
    }
}
