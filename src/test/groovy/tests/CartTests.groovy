package tests

import factory.StaticData
import pages.*
import spock.lang.Specification

class CartTests extends Specification {
    private HomePage homePage;
    private CartPage cartPage;
    private StaticData staticData;

    def setup() {
        homePage = new HomePage();
        cartPage = new CartPage();
        staticData = new StaticData();
    }

    def "should_display_cart_with_products"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout();

        then:
            cartPage.hasDisplayed() == true;
    }

    def "should_be_able_to_remove_product_from_cart"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .removeProduct();

        then:
            cartPage.hasDeletedProduct() == true;
    }
}
