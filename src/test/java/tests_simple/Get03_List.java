package tests_simple;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class Get03_List {

    private static final String BASE_URI = "https://dev.emeli.in.ua/";
    private static final String POSTS_ENDPOINT = "/wp-json/wp/v2/posts";
    private static final int EXPECTED_STATUS_CODE = 200;
    private static final int postId = 11198;
    private static final int postQuantity = 10;
    private static final Boolean sticky = true;


    @BeforeAll
    public static void beforeTest() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void checkParamGetNew() {
        long startTime = System.currentTimeMillis();
        Response response = when()
                .get(POSTS_ENDPOINT);

        response.then()
                .statusCode(EXPECTED_STATUS_CODE)
                .body(not(empty()))                         // body {}
                .body("$", hasSize(postQuantity))
                .body("id", everyItem(notNullValue()))
                .body("id", everyItem(greaterThan(0)))
                .body("id", everyItem(instanceOf(Integer.class)));


        System.out.println(response.asString());


        long endTime = System.currentTimeMillis();
        System.out.println("responseTime: " + (endTime - startTime));

    }
}