package common

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.webdriver.ChromeDriverFactory
import factory.StaticData
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import pages.CartPage;
import pages.HomePage
import pages.LoginPage
import pages.MyAccountPage
import pages.ProductPage
import pages.RegistrationPage
import spock.lang.Specification

class BaseTest extends Specification {
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static RegistrationPage registrationPage;
    protected static MyAccountPage myAccountPage;
    protected static ProductPage productPage;
    protected static CartPage cartPage;
    protected static StaticData staticData;

    def setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.headless = true;
        Configuration.timeout = 10000;

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        myAccountPage = new MyAccountPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        staticData = new StaticData();
    }

    def cleanup() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
