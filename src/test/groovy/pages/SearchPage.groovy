package pages

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

class SearchPage {
    private ElementsCollection productResults = $$('.ajax_block_product');

    def resultsCount(expectResults) {
        if(expectResults) {
            productResults.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
        }
        return productResults.size();
    }

    def accessProductPage() {
        sleep(1000);
        productResults.first().click();
        return new ProductPage();
    }
}
