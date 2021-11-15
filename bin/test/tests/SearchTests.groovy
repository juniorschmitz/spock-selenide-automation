package tests

import common.BaseTest

class SearchTests extends BaseTest {
    def "should_search_for_valid_product"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                    .execSearch(product);

        then:
            searchPage.resultsCount(true) >= 1
    }

    def "should_not_return_non_existent_products"() {
        expect:
            homePage.load()
                    .execSearch(searchTerm)
                    .resultsCount(false) == 0;

        where:
            searchTerm | _
            'potato'   | _
            'blusa'    | _
            'nothing'  | _
    }
}
