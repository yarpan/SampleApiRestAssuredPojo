package tests_demo;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.OwnerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestAssuredBasicTest {


    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void createNewOwner() {
        Faker faker = new Faker();
        var sourceOwnerPojo = OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();

        System.out.println("sourceOwnerPojo = " + sourceOwnerPojo.toString());

        Response response = RestAssured
                .given()
                    .baseUri("http://localhost:9966/petclinic")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .body(sourceOwnerPojo)
                    .post("/api/owners")
                .then()
                    .extract().response();

        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        Assertions.assertEquals(201, response.statusCode());
    }
}
