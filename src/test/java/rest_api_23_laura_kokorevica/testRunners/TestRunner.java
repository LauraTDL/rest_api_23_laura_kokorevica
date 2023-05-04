package rest_api_23_laura_kokorevica.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"rest_api_23_laura_kokorevica/stepdefinitions"}
)
public class TestRunner {

}
