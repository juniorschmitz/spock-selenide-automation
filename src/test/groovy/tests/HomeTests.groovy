package tests

import factory.StaticData
import pages.*
import spock.lang.Specification

class HomeTests extends Specification {
    private HomePage homePage;
    private SearchPage searchPage;
    private AuthenticationPage authenticationPage;
    private StaticData staticData;

    def setup() {
        homePage = new HomePage();
        searchPage = new SearchPage();
        authenticationPage = new AuthenticationPage();
        staticData = new StaticData();
    }
    def "should_access_home"() {
        when: homePage.load();
        then: homePage.hasDisplayed() == true;
    }

    def "should_search_for_product"() {
        given: def product = staticData.getData('search_product');
        when: homePage.load().execSearch(product);
        then: searchPage.resultsCount() >= 1
    }

    def "should_access_authentication_page"() {
        when: homePage.load().accessAuthenticationPage();
        then: authenticationPage.hasDisplayed() == true
    }
}
