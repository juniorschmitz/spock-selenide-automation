package pages

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

class SearchPage {
    private ElementsCollection productResults = $$('.ajax_block_product');

    def resultsCount() {
        return productResults.size()
    }
}
