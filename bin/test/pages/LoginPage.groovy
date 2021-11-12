package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class LoginPage {
    private SelenideElement inputLogin = $('#email');
    private SelenideElement inputPassword = $('#passwd');
    private SelenideElement btnLogin = $('#SubmitLogin');
    private SelenideElement inputNewClientEmail = $('#email_create');
    private SelenideElement btnNewClient = $('#SubmitCreate');

    def hasDisplayed() {
        btnLogin.shouldBe(Condition.visible);
        boolean is_visible = inputLogin.is(Condition.visible) && inputPassword.is(Condition.visible) && btnLogin.is(Condition.visible)
        return is_visible;
    }

    def accessRegistrationPage() {
        def email = 'testenao@existe.com'
        inputNewClientEmail.val(email);
        btnNewClient.click();
        return new RegistrationPage();
    }

    def loginWith(email, password) {
        inputLogin.val(email);
        inputPassword.val(password);
        btnLogin.click();
        return new MyAccountPage();
    }
}
