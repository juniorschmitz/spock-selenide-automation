package tests

import common.BaseTest

class AuthenticationTests extends BaseTest {
    def "should_access_login_page"() {
        when:
            homePage.load()
                    .accessAuthenticationPage();

        then:
            loginPage.shouldBeDisplayed();
    }

    def "should_access_registration_page"() {
        when:
            homePage.load()
                    .accessAuthenticationPage()
                    .accessRegistrationPage();

        then:
            registrationPage.shouldBeDisplayed();
    }

    def "should_login"() {
        given:
            def user = staticData.getData('valid_user');

        when:
            homePage.load()
                    .accessAuthenticationPage()
                    .loginWith(user['email'], user['password']);

        then:
            myAccountPage.shouldBeLoggedIn();
    }
}
