package controllers;

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





}
