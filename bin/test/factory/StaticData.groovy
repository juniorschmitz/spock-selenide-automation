package factory
import groovy.yaml.YamlSlurper

class StaticData {
    def data;

    StaticData() {
        def environment = (System.getProperty("environment") == null) ? 'prd' : System.getProperty("environment")
        this.data = new YamlSlurper().parseText( new File("${System.getProperty('user.dir')}/src/test/resources/data/${environment}/data.yaml").getText())
    }

    def getData(key) {
        return data[key];
    }
}
