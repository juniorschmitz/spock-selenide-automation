package tests

import common.BaseTest

class CheckoutTests extends BaseTest {
    def setup() {
        def user = staticData.getData('valid_checkout_user');
        homePage.load()
                .accessAuthenticationPage()
                .loginWith(user['email'], user['password']);
    }

    def "should_finish_checkout_with_check"() {
        given:
            def product = staticData.getData('search_product');

        when:
            homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .goToAddressSelect()
                .chooseAddress()
                .chooseShipping()
                .finishWithCheck();

        then:
            checkoutConfirmationPage.shouldCompletedOrder();
    }

    def "should_finish_checkout_with_bank_wire"() {
        given:
        def product = staticData.getData('search_product_2');

        when:
        homePage.load()
                .execSearch(product)
                .accessProductPage()
                .addProductToCart()
                .proceedToCheckout()
                .goToAddressSelect()
                .chooseAddress()
                .chooseShipping()
                .finishWitBankWire();

        then:
        checkoutConfirmationPage.shouldCompletedOrder();
    }
}
