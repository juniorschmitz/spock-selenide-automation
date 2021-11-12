package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.conditions.ExactText

import static com.codeborne.selenide.Selenide.$

class CartPage {
    private SelenideElement btnProceedToCheckout = $('p.cart_navigation  a[title="Proceed to checkout"]');
    private SelenideElement iconDeleteProduct = $('a[title="Delete"]');
    private SelenideElement messageDeletedProduct = $('.alert-warning');
    private SelenideElement btnIncreaseQuantity = $('i.icon-plus');
    private SelenideElement btnDecreaseQuantity = $('i.icon-minus');
    private SelenideElement quantityProduct = $('.cart_quantity_input');

    def hasDisplayed() {
        btnProceedToCheckout.shouldBe(Condition.visible)
        return btnProceedToCheckout.is(Condition.visible);
    }

    def removeProduct() {
        iconDeleteProduct.click();
        return this;
    }

    def hasDeletedProduct() {
        messageDeletedProduct.shouldHave(Condition.exactText('Your shopping cart is empty.'));
        return messageDeletedProduct.text().contains('Your shopping cart is empty.');
    }

    def increaseQuantity() {
        def expectedQuantity = quantityProduct.val().toInteger() + 1;
        btnIncreaseQuantity.click();
        quantityProduct.shouldHave(Condition.exactValue(expectedQuantity.toString()));
        return this;
    }

    def decreaseQuantity() {
        def expectedQuantity = quantityProduct.value().toInteger() - 1;
        btnDecreaseQuantity.click();
        if(!messageDeletedProduct.is(Condition.visible)) {
            quantityProduct.shouldHave(Condition.exactValue(expectedQuantity.toString()));
        }
        return this;
    }

    def hasChangedQuantity(expectedQuantity) {
        quantityProduct.shouldHave(Condition.exactValue(expectedQuantity));
        return quantityProduct.text().contains(expectedQuantity);
    }
}
