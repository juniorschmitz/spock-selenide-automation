package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class RegistrationPage {
    private SelenideElement formCreateAccount = $('form#account-creation_form');

    def hasDisplayed() {
        formCreateAccount.shouldBe(Condition.visible);
        return formCreateAccount.is(Condition.visible);
    }
}
