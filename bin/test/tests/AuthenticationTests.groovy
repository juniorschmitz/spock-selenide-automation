package tests

import common.BaseTest

class AuthenticationTests extends BaseTest {
    def "should_access_login_page"() {
        when:
            homePage.load()
                    .accessAuthenticationPage();

        then:
            loginPage.hasDisplayed() == true
    }

    def "should_access_registration_page"() {
        when:
            homePage.load()
                    .accessAuthenticationPage()
                    .accessRegistrationPage();

        then:
            registrationPage.hasDisplayed() == true;
    }

    def "should_login"() {
        when:
            homePage.load()
                    .accessAuthenticationPage()
                    .loginWith('potato@testezap.com', '123456&');

        then:
            myAccountPage.isLoggedIn() == true;
    }
}
