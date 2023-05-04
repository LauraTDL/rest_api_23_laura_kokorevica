package rest_api_23_laura_kokorevica.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import rest_api_23_laura_kokorevica.helpers.TestCaseContext;

import static rest_api_23_laura_kokorevica.clients.ClickupClient.deletefolder;

public class Hooks {
    @Before
    public void beforeHook(Scenario scenarion) {
        TestCaseContext.init();
        TestCaseContext.setScenario(scenarion);
        System.out.println("The scenario has started");
    }
    @After
    public void afterHook() {
        deletefolder(TestCaseContext.getFolder().getId());
        System.out.println("The scenario has ended");

    }
}
