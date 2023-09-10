package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {

    public static final boolean IS_DEBUG_MODE = true;

    public void checkServerHealth() {

    }

    public void debugPrint(String stringToPrint) {
        if (IS_DEBUG_MODE)
            System.out.println(stringToPrint);
    }

    public void debugPrintV(String stringToPrint) {
        if (IS_DEBUG_MODE)
            System.out.println("stringToPrint = " + stringToPrint);
    }

    public static JsonPath rawToJson(Response response) {
        return new JsonPath(String.valueOf(response.asString()));
    }

    private String toJson(Object sourcePojo) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String jsonBody = ow.writeValueAsString(sourcePojo);
            System.out.println("jsonBody = " + jsonBody);
            return jsonBody;
        } catch (JsonProcessingException e) {
            //throw new RuntimeException(e);
            return null;
        }
    }

}
