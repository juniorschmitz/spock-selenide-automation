package tests


import pages.LoginPage
import pages.HomePage
import pages.MyAccountPage
import pages.RegistrationPage
import spock.lang.Specification

class AuthenticationTests extends Specification {
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;

    def setup() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        myAccountPage = new MyAccountPage();
    }

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
