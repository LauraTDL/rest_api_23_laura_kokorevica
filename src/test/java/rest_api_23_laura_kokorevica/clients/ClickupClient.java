package rest_api_23_laura_kokorevica.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static rest_api_23_laura_kokorevica.constants.ProjectConstants.API_KEY;
import static rest_api_23_laura_kokorevica.constants.ProjectConstants.SPACE_ID;

public class ClickupClient {
    public static Response createfolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createlist(JSONObject obj, String folder_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + folder_id + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createtask(JSONObject obj, String list_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + list_id + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response removetask(JSONObject obj, String task_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + task_id)
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }
    public static Response fetchlist(String taskId) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .get("https://api.clickup.com/api/v2/task/" + taskId)
                .then().log().all()
                .statusCode(404)
                .extract().response();
    }
    public static Response deletefolder(String folderId) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + folderId)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
