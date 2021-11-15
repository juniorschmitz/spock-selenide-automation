package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class MyAccountPage {
    private SelenideElement infoAccount = $('.info-account');

    def shouldBeLoggedIn() {
        infoAccount.shouldBe(Condition.visible);
    }
}
