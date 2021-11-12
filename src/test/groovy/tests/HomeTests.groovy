package tests

import common.BaseTest

class HomeTests extends BaseTest {
    def "should_access_home"() {
        when:
            homePage.load();

        then:
            homePage.hasDisplayed() == true;
    }
}
