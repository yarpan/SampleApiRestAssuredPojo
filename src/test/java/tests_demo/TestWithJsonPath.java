package tests_demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestWithJsonPath {

    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void getUsersList() {
        var targetOwnerResponse = getListOfUsersResponse();

        JsonPath jsonPath = rawToJson(targetOwnerResponse);
        //extracting list of emails for each user
        List<String> listOfUsersEmails = jsonPath.getList("data.email");
        System.out.println("listOfUsersEmails = " + listOfUsersEmails.toString());

        Assertions.assertEquals(200, targetOwnerResponse.statusCode());
    }

    public Response getListOfUsersResponse() {
        return basicApiClient()
                .when()
                .get("/api/users?page=2");
    }

    public static RequestSpecification basicApiClient() {
        return RestAssured.given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public static JsonPath rawToJson(Response response){
        return new JsonPath(String.valueOf(response.asString()));
    }


}
