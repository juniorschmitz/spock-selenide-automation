package tests

import common.BaseTest

class CartLoggedInTests extends BaseTest {
    def setup() {
        homePage.load()
                .accessAuthenticationPage()
                .loginWith('potato@testezap.com', '123456&');
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

    def "should_be_able_to_increase_product_quantity"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .increaseQuantity();

        then:
            cartPage.hasChangedQuantity("2") == true;
    }

    def "should_be_able_to_decrease_product_quantity"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .increaseQuantity()
                .decreaseQuantity();

        then:
            cartPage.hasChangedQuantity("1") == true;
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
            cartPage.hasDeletedProduct() == true;
    }
}
