package tests_pattern;

import data.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;


public class ApiPage {
    private static String USERNAME;
    private static String PASSWORD;
    private static final String BASE_URI = "https://dev.emeli.in.ua/wp-json/wp/v2/posts";


    public ApiPage(String baseUri, String userName, String password) {
        RestAssured.baseURI = baseUri;
        USERNAME = userName;
        PASSWORD = password;
        initialize();
    }


    private void initialize(){
        RestAssured.baseURI = BASE_URI;

    }

    public Response createNewPost(String title, String content){
        String requestBody = """
             {
                "title": "%s",
                "content": "%s"
            }
             """.formatted(title, content);
        String credentials = new String(Base64.encodeBase64((USERNAME + ":" + PASSWORD).getBytes()));

        return RestAssured.given()
                .header("Content-Type",ContentType.JSON)
                .header("Authorization", "Basic " + credentials)
                .body(requestBody)
                .post();
    }

    public Response updatePost(String updateTitle, String updateContent, int postId){
        String requestBody = """
             {
                "title": "%s",
                "content": "%s"
            }
             """.formatted(updateTitle, updateContent);
        //String credentials = new String(Base64.encodeBase64((USERNAME + ":" + PASSWORD).getBytes()));

        return RestAssured.given()
                .header("Content-Type",ContentType.JSON)
                .header("Authorization", "Basic " + credentials())
                .body(requestBody)
                .put("/" + postId);
    }

    private String credentials(){
        return new String(Base64.encodeBase64((TestData.USERNAME + ":" + TestData.PASSWORD).getBytes()));
    }

}
