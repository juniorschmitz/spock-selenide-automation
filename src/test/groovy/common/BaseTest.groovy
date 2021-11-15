package common

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.webdriver.ChromeDriverFactory
import factory.StaticData
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import pages.CartPage
import pages.CheckoutConfirmationPage
import pages.CheckoutPage;
import pages.HomePage
import pages.LoginPage
import pages.MyAccountPage
import pages.ProductPage
import pages.RegistrationPage
import pages.SearchPage
import spock.lang.Specification

class BaseTest extends Specification {
    protected static HomePage homePage;
    protected static SearchPage searchPage;
    protected static LoginPage loginPage;
    protected static RegistrationPage registrationPage;
    protected static MyAccountPage myAccountPage;
    protected static ProductPage productPage;
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;
    protected static CheckoutConfirmationPage checkoutConfirmationPage;
    protected static StaticData staticData;

    def setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.headless = false;
        Configuration.timeout = 10000;

        homePage = new HomePage();
        searchPage = new SearchPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        myAccountPage = new MyAccountPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        checkoutConfirmationPage = new CheckoutConfirmationPage();
        staticData = new StaticData();
    }

    def cleanup() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
