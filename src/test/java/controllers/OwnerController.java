package controllers;

import com.github.javafaker.Faker;
import data.Endpoints;
import io.restassured.response.Response;
import models.OwnerDto;

public class OwnerController extends BaseController {

    public Response getByIdRequest(int id) {
        return basicApiClient()
                .get(Endpoints.ENDPOINT_OWNERS + "/{ownerId}", id);
    }

    public Response postRequest(OwnerDto body) {
        return basicApiClient()
                .body(body)
                .when()
                .post(Endpoints.ENDPOINT_OWNERS);
    }


    public Response putByIdRequest(OwnerDto body, int id) {
        return basicApiClient()
                .body(body)
                .when()
                .put(Endpoints.ENDPOINT_OWNERS + "/{ownerId}", id);
    }


    public Response deleteByIdRequest(int id) {
        return basicApiClient()
                .delete(Endpoints.ENDPOINT_OWNERS + "/{ownerId}", id);
    }


    public OwnerDto generateRandomOwnerDto() {
        Faker faker = new Faker();
        return OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();
    }


}
