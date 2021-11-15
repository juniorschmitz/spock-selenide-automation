package pages

import com.codeborne.selenide.*
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

class HomePage {
    private SelenideElement inputSearch = $('#search_query_top');
    private SelenideElement linkAccessLogin = $('a.login');

    def load() {
        open("/index.php");
        return this;
    }

    def execSearch(String query) {
        inputSearch.val(query).pressEnter();
        return new SearchPage();
    }

    def shouldBeDisplayed() {
        inputSearch.shouldBe(Condition.visible);
    }

    def accessAuthenticationPage() {
        linkAccessLogin.click();
        return new LoginPage();
    }
}
