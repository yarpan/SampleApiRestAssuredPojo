package controllers;

import com.github.javafaker.Faker;
import data.Endpoints;
import io.restassured.response.Response;
import models.OwnerCreatePojo;

public class OwnerController extends BaseController {


    public Response createOwner(OwnerCreatePojo body) {
        return basicApiClient()
                .body(body)
                .when()
                .post(Endpoints.ENDPOINT_OWNERS);
    }


    public OwnerCreatePojo createRandomDataForOwner() {
        Faker faker = new Faker();
        return OwnerCreatePojo.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();
    }


}
