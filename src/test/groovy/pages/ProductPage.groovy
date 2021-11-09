package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement btnAddToCart = $('p#add_to_cart button');

    def hasDisplayed() {
        return btnAddToCart.is(Condition.visible);
    }
}
