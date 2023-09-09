package tests;

import controllers.OwnerController;
import models.OwnerCreatePojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class OwnerCrudTests extends BaseTest{


    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void createNewOwner() {
        var ownerController = new OwnerController();
        var sourceOwnerPojo = ownerController.createRandomDataForOwner();
        System.out.println("sourceOwnerPojo = " + sourceOwnerPojo.toString());

        var targetOwnerResponse = ownerController.createOwner(sourceOwnerPojo);
        var targetOwnerPojo = targetOwnerResponse.as(OwnerCreatePojo.class);
        System.out.println("targetOwnerPojo = " + targetOwnerResponse.asString());

        Assertions.assertEquals(201, targetOwnerResponse.statusCode());
        Assertions.assertEquals(sourceOwnerPojo.getFirstName(), targetOwnerPojo.getFirstName());
        Assertions.assertEquals(sourceOwnerPojo.getLastName(), targetOwnerPojo.getLastName());

        var newOwnerID = targetOwnerPojo.getId();
        System.out.println("newOwnerId = " + newOwnerID);
    }

    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void getOwnerById(){

    }

    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void getListOfOwners(){

    }

    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void putChangeToOwner(){


    }

    @Test
    @DisplayName("Creating Owner of a Pet via API")
    public void deleteOwner(){


    }





}
