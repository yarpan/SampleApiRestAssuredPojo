package controllers;

import data.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.parsing.Parser;


public class BaseController {



    public static RequestSpecification basicApiClient() {
        //RestAssured.registerParser("text/plain", Parser.JSON);
        //RestAssured.registerParser("application/json", Parser.JSON);
        return RestAssured.given()
                .baseUri(Endpoints.BASE_URI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }






}
