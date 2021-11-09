package tests;

import factory.StaticData;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;
import spock.lang.Specification;

public class ProductPageTests extends Specification {
    private HomePage homePage;
    private SearchPage searchPage;
    private StaticData staticData;
    private ProductPage productPage;

    def setup() {
        homePage = new HomePage();
        staticData = new StaticData();
        productPage = new ProductPage();
    }

    def "should_search_for_valid_product"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage();

        then:
            productPage.hasDisplayed() == true;
    }
}
