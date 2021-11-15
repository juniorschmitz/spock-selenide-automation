package tests

import common.BaseTest

class CartLoggedInTests extends BaseTest {
    def setup() {
        def user = staticData.getData('valid_cart_user');
        homePage.load()
                .accessAuthenticationPage()
                .loginWith(user['email'], user['password']);
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
            cartPage.shouldBeDisplayed();
    }

    def "should_be_able_to_remove_product_from_cart"() {
        given:
            def product = staticData.getData('search_product_2');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .removeProduct();

        then:
            cartPage.hasDeletedProduct();
    }

    def "should_be_able_to_increase_product_quantity"() {
        given:
            def product = staticData.getData('search_product_3');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .increaseQuantity();

        then:
            cartPage.hasChangedQuantity("2");
    }

    def "should_be_able_to_decrease_product_quantity"() {
        given:
            def product = staticData.getData('search_product_2');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .increaseQuantity()
                .decreaseQuantity();

        then:
            cartPage.hasChangedQuantity("1");
    }

    def "should_be_able_to_remove_product_by_decreasing_quantity"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .decreaseQuantity();

        then:
            cartPage.hasDeletedProduct();
    }
}
