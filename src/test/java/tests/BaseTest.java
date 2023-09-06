package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.path.json.JsonPath;

public class BaseTest {


    public void checkServerHealth(){

    }

    public void debugPrint (String stringToPrint){
        System.out.println(stringToPrint);
    }

    public void debugPrintV (String stringToPrint){
        System.out.println("stringToPrint = " + stringToPrint);
    }


    public static JsonPath rawToJson(String response) {
        return new JsonPath(String.valueOf(response));
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
