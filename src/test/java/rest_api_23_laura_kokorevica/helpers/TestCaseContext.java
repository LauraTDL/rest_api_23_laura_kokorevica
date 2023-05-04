package rest_api_23_laura_kokorevica.helpers;

import io.cucumber.java.Scenario;
import rest_api_23_laura_kokorevica.domain.Folder;
import rest_api_23_laura_kokorevica.domain.List;
import rest_api_23_laura_kokorevica.domain.Task;

public class TestCaseContext {
    private static Folder folder;
    private static List list;
    private static Scenario scenario;
    private static RandomNameGenerator name;
    private static RandomNameGenerator task_name;
    private static Task task;

    public static void init() {
        folder = null;
        scenario = null;
        list = null;
        task = null;
        task_name = null;
    }

    public static void setFolder(Folder folder) {
        TestCaseContext.folder = folder;
    }

    public static Folder getFolder() {
        return folder;
    }

    public static void setList(List list) {
        TestCaseContext.list = list;
    }

    public static List getList() {
        return list;
    }

    public static void setTask(Task task) {
        TestCaseContext.task = task;
    }

    public static Task getTask() {
        return task;
    }

    public static void setTaskName(RandomNameGenerator task_name) {
        TestCaseContext.task_name = task_name;
    }

    public static RandomNameGenerator getTaskName() {
        return task_name;
    }

    public static void setName() {
        TestCaseContext.name = name;
    }

    public static RandomNameGenerator getName() {
        return name;
    }

    public static void setScenario(Scenario scenario) {
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }
}
