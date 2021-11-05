package factory
import groovy.yaml.YamlSlurper

class StaticData {
    def data;

    StaticData() {
        this.data = new YamlSlurper().parseText( new File(System.getProperty("user.dir") + "/src/test/resources/data/prd/data.yaml").getText())
    }

    def getData(key) {
        return data[key]
    }
}
