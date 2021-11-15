package pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class CheckoutPage {
    private SelenideElement btnProcessAddress = $('button[name="processAddress"]');
    private SelenideElement checkBoxTermsDelivery = $('input#cgv');
    private SelenideElement btnProcessCarrier = $('button[name="processCarrier"]');
    private SelenideElement linkFinishWithCheck = $('a.cheque');
    private SelenideElement linkFinishWithBankWire = $('a.bankwire');
    private SelenideElement btnConfirmOrder = $('button.button-medium');

    def chooseAddress() {
        btnProcessAddress.click();
        return this;
    }

    def chooseShipping() {
        checkBoxTermsDelivery.click();
        btnProcessCarrier.click();
        return this;
    }

    def finishWithCheck() {
        linkFinishWithCheck.click();
        btnConfirmOrder.click();
        return new CheckoutConfirmationPage();
    }

    def finishWitBankWire() {
        linkFinishWithBankWire.click();
        btnConfirmOrder.click();
        return new CheckoutConfirmationPage();
    }
}
