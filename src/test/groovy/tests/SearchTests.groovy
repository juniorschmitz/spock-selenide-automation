package tests

import factory.StaticData
import pages.HomePage
import pages.SearchPage
import spock.lang.Specification

class SearchTests extends Specification {
    private HomePage homePage;
    private SearchPage searchPage;
    private StaticData staticData;

    def setup() {
        homePage = new HomePage();
        searchPage = new SearchPage();
        staticData = new StaticData();
    }

    def "should_search_for_valid_product"() {
        given: def product = staticData.getData('search_product');
        when: homePage.load().execSearch(product);
        then: searchPage.resultsCount() >= 1
    }

    def "should_not_return_non_existent_products"() {
        expect:
            homePage.load().execSearch(searchTerm)
                    .resultsCount() == 0;

        where:
            searchTerm | _
            'potato'   | _
            'blusa'    | _
            'nothing'  | _
    }
}
