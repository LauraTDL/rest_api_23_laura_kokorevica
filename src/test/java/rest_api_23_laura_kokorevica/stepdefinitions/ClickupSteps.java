package rest_api_23_laura_kokorevica.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import rest_api_23_laura_kokorevica.domain.Folder;
import rest_api_23_laura_kokorevica.domain.List;
import rest_api_23_laura_kokorevica.domain.Task;
import rest_api_23_laura_kokorevica.helpers.RandomNameGenerator;
import rest_api_23_laura_kokorevica.helpers.TestCaseContext;

import java.util.Map;

import static rest_api_23_laura_kokorevica.clients.ClickupClient.*;
import static rest_api_23_laura_kokorevica.constants.ProjectConstants.*;

public class ClickupSteps {

    @Given("I create a ClickUp folder and verify that the name is correct")
    public void createFolder(){
        JSONObject obj = new JSONObject();
        obj.put("name", FOLDER_NAME);
        Response resp = createfolder(obj);
        Folder folder = resp.as(Folder.class);
        TestCaseContext.setFolder(folder);

        Assertions.assertThat(folder.getName())
                .as("Make sure that the folder name is correct")
                .isEqualTo(FOLDER_NAME);

        TestCaseContext.getScenario().log("The created folder name is " + folder.getName());
    }

    @Then("I create a new list in the folder")
    public void createNewList() {
        JSONObject obj = new JSONObject();
        obj.put("name", LIST_NAME);
        obj.put("content", CONTENT);
        Response resp = createlist(obj, TestCaseContext.getFolder().getId());
        List list = resp.as(List.class);
        TestCaseContext.setList(list);

        TestCaseContext.getScenario().log("The created list name is " + list.getName());
    }

    @And("I check that the list name is correct")
    public void verifyListName() {
        Assertions.assertThat(TestCaseContext.getList().getName())
                .as("Check that the list name is correct" + LIST_NAME)
                .isEqualTo(LIST_NAME);
    }

    @And("I check that the list is added to the correct folder")
    public void verifyListLocation() {
        JSONObject obj = new JSONObject((Map) TestCaseContext.getList().getListFolderInfo());
        String id = (String) obj.get("id");
        Assertions.assertThat(TestCaseContext.getFolder().getId())
                .as("Check that the list is added to correct folder " + TestCaseContext.getFolder().getId())
                .isEqualTo(id);

        TestCaseContext.getScenario().log("The list is added to correct folder with ID: " + id);
    }

    @Then("I create one Task in the list")
    public void createTask() {
        RandomNameGenerator randomName = new RandomNameGenerator();
        randomName.setName();
        TestCaseContext.setTaskName(randomName);
        JSONObject obj = new JSONObject();
        obj.put("name", randomName.getName());
        obj.put("description", TASK_DESCRIPTION);
        Response resp = createtask(obj, TestCaseContext.getList().getId());
        Task task = resp.as(Task.class);
        TestCaseContext.setTask(task);

        TestCaseContext.getScenario().log("The task name is " + task.getName());
    }

    @And("I check that the Task name is correct")
    public void verifyTaskName() {
        Assertions.assertThat(TestCaseContext.getTask().getName())
                .as("Check that the Task name is correct " + TestCaseContext.getTaskName().getName())
                .isEqualTo(TestCaseContext.getTaskName().getName());
    }

    @Then("I remove the Task from the list")
    public void removeTask() {
        JSONObject obj = new JSONObject();
        removetask(obj, TestCaseContext.getTask().getId());
    }

    @And("I fetch the List and verify that the Task can't be found there anymore")
    public void fetchList() {
        Response response = fetchlist(TestCaseContext.getTask().getId());

        Assertions.assertThat((response.statusCode()))
                .as("Verify Task is not found")
                .isEqualTo(404);
    }
}


