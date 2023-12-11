package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.path.json.JsonPath;

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

    public JsonPath convertRawToJson(Object sourceObject) {
        return new JsonPath(String.valueOf(sourceObject.toString()));
    }

    public String convertToJson(Object sourceObject) {
        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return mapper.writeValueAsString(sourceObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertDtoToJson(Object sourceObject){
        ObjectMapper mapper = new JsonMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(sourceObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }




}
