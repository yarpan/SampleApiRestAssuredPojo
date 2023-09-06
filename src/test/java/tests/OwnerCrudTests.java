package tests;

import com.github.javafaker.Faker;
import controllers.OwnerController;
import models.OwnerCreatePojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class OwnerCrudTests extends BaseTest{

    OwnerController ownerController = new OwnerController();
    Faker faker = new Faker();
    int newOwnerID;

    private OwnerCreatePojo createRandomDataForOwner() {
        return OwnerCreatePojo.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();
    }



    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void createNewOwner() {

        var sourceOwnerPojo = createRandomDataForOwner();
        System.out.println("sourceOwnerPojo = " + sourceOwnerPojo.toString());

        var targetOwnerResponse = ownerController.createOwner(sourceOwnerPojo);
        var targetOwnerPojo = targetOwnerResponse.as(OwnerCreatePojo.class);
        System.out.println("targetOwnerPojo = " + targetOwnerResponse.asString());

        Assertions.assertEquals(201, targetOwnerResponse.statusCode());
        Assertions.assertEquals(sourceOwnerPojo.getFirstName(), targetOwnerPojo.getFirstName());
        Assertions.assertEquals(sourceOwnerPojo.getLastName(), targetOwnerPojo.getLastName());

        newOwnerID = targetOwnerPojo.getId();
        System.out.println("newOwnerId = " + newOwnerID);
    }








}
