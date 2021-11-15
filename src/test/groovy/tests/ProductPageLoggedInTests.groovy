package tests

import common.BaseTest

public class ProductPageLoggedInTests extends BaseTest {
    def setup() {
        def user = staticData.getData('valid_product_user');
        homePage.load()
                .accessAuthenticationPage()
                .loginWith(user['email'], user['password']);
    }

    def "should_be_able_to_access_product_page"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage();

        then:
            productPage.shouldBeDisplayed();
    }

    def "should_be_able_to_add_product_to_cart"() {
        given:
            def product = staticData.getData('search_product_2');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart();

        then:
            productPage.hasAddedProductToCart();
    }
}
