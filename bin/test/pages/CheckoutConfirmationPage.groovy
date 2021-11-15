package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class CheckoutConfirmationPage {
    private SelenideElement alertOrderConfirmation = $('.alert-success, .cheque-indent strong');

    def shouldCompletedOrder() {
        alertOrderConfirmation.shouldHave(Condition.exactText('Your order on My Store is complete.'));
    }
}
