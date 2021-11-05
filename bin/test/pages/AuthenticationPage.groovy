package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class AuthenticationPage {
    private SelenideElement inputLogin = $('#email');
    private SelenideElement inputPassword = $('#passwd');
    private SelenideElement btnLogin = $('#SubmitLogin');

    def hasDisplayed() {
        return inputLogin.is(Condition.visible) && inputPassword.is(Condition.visible) && btnLogin.is(Condition.visible);
    }
}
