package tests_pattern;

import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class ApiTests {
    private static final int EXPECTED_STATUS_CODE_POST = 201;
    private static final int EXPECTED_STATUS_CODE_PUT = 200;
    private static final String EXPECTED_TITLE = "New Post";
    private static final String UPDATED_TITLE = "Updated Put";
    private static final String EXPECTED_CONTENT = "New content for new POST";
    private static final String UPDATED_CONTENT = "Updated content by PUT";
    private ApiPage apiPage = new ApiPage();
    SoftAssertions softly = new SoftAssertions();
    public int postId = 11528;

//Class ApiPagePost

    @Test
    public void createNewPostTest() {
        Response response = apiPage.createNewPost(EXPECTED_TITLE, EXPECTED_CONTENT);
        List<Map<String, String>> gtTranslateKeys = response.jsonPath().getList("title.gt_translate_keys");
        int actualId = parseInt(response.jsonPath().getString("id"));
        Map<String, String> firstKey = gtTranslateKeys.get(0);

        softly.assertThat(response.getStatusCode()).as("status code").isEqualTo(EXPECTED_STATUS_CODE_POST);
        softly.assertThat(firstKey.get("key")).as("gt_translate_keys key").isEqualTo("rendered");
        softly.assertThat(firstKey.get("format")).as("gt_translate_keys format").isEqualTo("text");
        softly.assertThat(actualId).as("ID").isNotNull();
        softly.assertThat(actualId).as("ID should be an Integer").isInstanceOf(Integer.class);
        softly.assertThat((Object) response.path("date")).as("Date").isNotNull();
        softly.assertThat((Object) response.path("status")).as("Status").isEqualTo("draft");

        // Check content-type
        String contentType = response.getHeader("Content-Type");
        softly.assertThat(contentType).as("Content-Type").contains("application/json");

        System.out.println("Create Post finished");
        softly.assertAll();
        //postId = actualId;
        System.out.println("actualId = " + actualId);
    }

    @Test
    public void updatePostTest() {
        Response response = apiPage.updatePost(UPDATED_TITLE, UPDATED_CONTENT, postId);
        System.out.println("postId = " + postId);
        System.out.println(response.asString());
        List<Map<String, String>> gtTranslateKeys = response.jsonPath().getList("title.gt_translate_keys");
        String actualIds = response.jsonPath().getString("id");
        System.out.println("actualIds = " + actualIds);

        int actualId = parseInt(response.jsonPath().getString("id"));
        Map<String, String> firstKey = gtTranslateKeys.get(0);

        softly.assertThat(response.getStatusCode()).as("status code").isEqualTo(EXPECTED_STATUS_CODE_PUT);
        softly.assertThat(firstKey.get("key")).as("gt_translate_keys key").isEqualTo("rendered");
        softly.assertThat(firstKey.get("format")).as("gt_translate_keys format").isEqualTo("text");
        softly.assertThat(actualId).as("ID").isNotNull();
        softly.assertThat(actualId).as("ID should be an Integer").isInstanceOf(Integer.class);
        softly.assertThat((Object) response.path("date")).as("Date").isNotNull();
        softly.assertThat((Object) response.path("status")).as("Status").isEqualTo("drafttttt");

        // Check content-type
        String contentType = response.getHeader("Content-Type");
        softly.assertThat(contentType).as("Content-Type").contains("application/json");

        System.out.println("Update Post finished");
        softly.assertAll();

    }


}

