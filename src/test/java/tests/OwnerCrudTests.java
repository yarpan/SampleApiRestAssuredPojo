package tests;

import controllers.OwnerController;
import models.OwnerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class OwnerCrudTests extends BaseTest{

    @Test
    @DisplayName("CreateNewOwnerTest")
    public void CreateNewOwnerTest() {
    //arrange
        var ownerController = new OwnerController();
        var requestPostDto = ownerController.generateRandomOwnerDto();

    //act
        //make POST request to create new Owner
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

    //assert
        Assertions.assertNotNull(responsePostRaw);
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals("application/json", responsePostRaw.contentType());

        Assertions.assertEquals(responsePostDto.getLastName(), requestPostDto.getLastName());
        Assertions.assertEquals(responsePostDto.getFirstName(), requestPostDto.getFirstName());
    }


    @Test
    @DisplayName("CreateNewOwnerAndGetHimByIdTest")
    public void CreateNewOwnerAndGetHimByIdTest(){
    //arrange
        var ownerController = new OwnerController();
        var requestPostDto = ownerController.generateRandomOwnerDto();
        //make POST request to create new Owner
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);
        //extracting ID of just created Owner
        var newCreatedId = responsePostDto.getId();

    //act
        //make Get request to receive details of Owner with specified ID
        var responseGetByIdRaw = ownerController.getByIdRequest(newCreatedId);
        var responseGetByIdDto = responseGetByIdRaw.as(OwnerDto.class);

    //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(200, responseGetByIdRaw.statusCode());

        Assertions.assertEquals(responsePostDto.getId(), responseGetByIdDto.getId());
        Assertions.assertEquals(responsePostDto.getFirstName(), responseGetByIdDto.getFirstName());
        Assertions.assertEquals(responsePostDto.getLastName(), responseGetByIdDto.getLastName());
    }


    @Test
    @DisplayName("CreateNewOwnerPutUpdateAndGetHimByIdTest")
    public void CreateNewOwnerPutUpdateAndGetHimByIdTest(){
    //arrange
        var ownerController = new OwnerController();
        var requestPostDto = ownerController.generateRandomOwnerDto();
        //make POST request to create new Owner
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);
        //extracting ID of just created Owner
        var newCreatedId = responsePostDto.getId();
        //creating new data for update owner
        var requestPutDto = ownerController.generateRandomOwnerDto();

    //act
        //make PUT request to update details of Owner with specified ID
        var responsePutRaw = ownerController.putByIdRequest(requestPutDto, newCreatedId);
        var responseGetByIdRaw = ownerController.getByIdRequest(newCreatedId);
        var responseGetByIdDto = responseGetByIdRaw.as(OwnerDto.class);

    //assert
        Assertions.assertEquals(204, responsePutRaw.statusCode());
        Assertions.assertEquals(200, responseGetByIdRaw.statusCode());

        Assertions.assertEquals(responsePostDto.getId(), responseGetByIdDto.getId());
        Assertions.assertEquals(requestPutDto.getFirstName(), responseGetByIdDto.getFirstName());
        Assertions.assertEquals(requestPutDto.getLastName(), responseGetByIdDto.getLastName());
    }


    @Test
    @DisplayName("CreateNewOwnerDeleteHimAndTryGetByIdTest")
    public void CreateNewOwnerDeleteHimAndTryGetByIdTest(){
    //arrange
        var ownerController = new OwnerController();
        var requestPostDto = ownerController.generateRandomOwnerDto();
        //make POST request to create new Owner
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);
        //extracting ID of just created Owner
        var newCreatedId = responsePostDto.getId();

    //act
        //make Delete request
        var responseDeleteRaw = ownerController.deleteByIdRequest(newCreatedId);
        var responseGetByIdRaw = ownerController.getByIdRequest(newCreatedId);

    //assert
        Assertions.assertEquals(204, responseDeleteRaw.statusCode());
        Assertions.assertEquals(404, responseGetByIdRaw.statusCode());
    }




}
