package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class CartPage {
    private SelenideElement btnProceedToCheckout = $('p.cart_navigation  a[title="Proceed to checkout"]');
    private SelenideElement iconDeleteProduct = $('a[title="Delete"]');
    private SelenideElement messageDeletedProduct = $('.alert-warning');
    private SelenideElement btnIncreaseQuantity = $('i.icon-plus');
    private SelenideElement btnDecreaseQuantity = $('i.icon-minus');
    private SelenideElement quantityProduct = $('.cart_quantity_input ');

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

    def increaseQuantity() {
        btnIncreaseQuantity.click();
        return this;
    }

    def decreaseQuantity() {
        btnDecreaseQuantity.click();
        return this;
    }

    def hasChangedQuantity(expectedQuantity) {
        sleep(1000);
        return quantityProduct.text().contains(expectedQuantity);
    }
}
