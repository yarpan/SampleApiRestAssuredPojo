package tests_vary;

import com.github.javafaker.Faker;
import controllers.OwnerController;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.OwnerCreatePojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestWithJsonPath {

    OwnerController ownerController = new OwnerController();
    Faker faker = new Faker();

    private OwnerCreatePojo createRandomDataForOwner() {
        return OwnerCreatePojo.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();
    }

    public static JsonPath rawToJson(Response response){
        return new JsonPath(String.valueOf(response.asString()));
    }


    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void createNewOwner() {

        var sourceOwnerPojo = createRandomDataForOwner();
        System.out.println("sourceOwnerPojo = " + sourceOwnerPojo.toString());

        var targetOwnerResponse = ownerController.createOwner(sourceOwnerPojo);
        System.out.println("targetOwnerResponse = " + targetOwnerResponse.asString());

        JsonPath jsonPath = rawToJson(targetOwnerResponse);
        int newOwnerId = jsonPath.getInt("id");
        System.out.println("newOwnerId = " + newOwnerId);

        Assertions.assertEquals(201, targetOwnerResponse.statusCode());

    }



}
