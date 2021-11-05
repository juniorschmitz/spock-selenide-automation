package pages

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

class HomePage {
    private SelenideElement inputSearch = $('#search_query_top');
    private SelenideElement linkAccessLogin = $('a.login');

    def load() {
        open("http://automationpractice.com/");
        return this;
    }

    def execSearch(String query) {
        inputSearch.val(query).pressEnter();
    }

    def hasDisplayed() {
        return inputSearch.is(Condition.visible);
    }

    def accessAuthenticationPage() {
        linkAccessLogin.click();
    }
}
