package tests

import pages.*
import spock.lang.Specification

class HomeTests extends Specification {
    private HomePage homePage;

    def setup() {
        homePage = new HomePage();
    }

    def "should_access_home"() {
        when: homePage.load();
        then: homePage.hasDisplayed() == true;
    }
}
