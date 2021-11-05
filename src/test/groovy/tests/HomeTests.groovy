package tests

import pages.*
import spock.lang.Specification

class HomeTests extends Specification {
    private HomePage homePage;
    private SearchPage searchPage;
    private AuthenticationPage authenticationPage;

    def setup() {
        homePage = new HomePage();
        searchPage = new SearchPage();
        authenticationPage = new AuthenticationPage();
    }
    def "access_home"() {
        when: homePage.load();
        then: homePage.hasDisplayed() == true;
    }

    def "search_for_product"() {
        when: homePage.load().execSearch('dress');
        then: searchPage.resultsCount() >= 1
    }

    def "access_authentication_page"() {
        when: homePage.load().accessAuthenticationPage();
        then: authenticationPage.hasDisplayed() == true
    }
}
