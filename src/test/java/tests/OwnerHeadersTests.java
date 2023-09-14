package tests;

import controllers.OwnerController;
import models.OwnerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OwnerHeadersTests {

    @Test
    public void GetOwnersListWithHeaderContentTypeCapsTest(){
    //arrange
        var ownerController = new OwnerController();
    //act
        //make Get request with custom headers
        var responseGetOwnerListRaw = ownerController.getListCustomHeaderRequest("CONTENT-TYPE","APPLICATION/JSON");
        OwnerDto[] responseGetOwnerListDto = responseGetOwnerListRaw.as(OwnerDto[].class);

    //assert
        Assertions.assertEquals(200, responseGetOwnerListRaw.statusCode());
        Assertions.assertNotEquals(0, responseGetOwnerListDto.length);
    }


    @Test
    public void GetOwnersListWithHeaderContentTypeCamelCaseTest(){
    //arrange
        var ownerController = new OwnerController();
    //act
        //make Get request with custom headers
        var responseGetOwnerListRaw = ownerController.getListCustomHeaderRequest("cOnTeNt-tYpE","aPpLiCaTiOn/jSoN");
        OwnerDto[] responseGetOwnerListDto = responseGetOwnerListRaw.as(OwnerDto[].class);

    //assert
        Assertions.assertEquals(200, responseGetOwnerListRaw.statusCode());
        Assertions.assertNotEquals(0, responseGetOwnerListDto.length);
    }


    @Test
    public void GetOwnersListWithHeaderAcceptedCapsTest(){
    //arrange
        var ownerController = new OwnerController();
    //act
        //make Get request with custom headers
        var responseGetOwnerListRaw = ownerController.getListCustomHeaderRequest("ACCEPTED","APPLICATION/JSON");
        OwnerDto[] responseGetOwnerListDto = responseGetOwnerListRaw.as(OwnerDto[].class);

    //assert
        Assertions.assertEquals(200, responseGetOwnerListRaw.statusCode());
        Assertions.assertNotEquals(0, responseGetOwnerListDto.length);
    }


    @Test
    public void GetOwnersListWithHeaderAcceptedCamelCaseTest(){
    //arrange
        var ownerController = new OwnerController();
    //act
        //make Get request with custom headers
        var responseGetOwnerListRaw = ownerController.getListCustomHeaderRequest("aCcePtEd","aPpLiCaTiOn/jSoN");
        OwnerDto[] responseGetOwnerListDto = responseGetOwnerListRaw.as(OwnerDto[].class);

    //assert
        Assertions.assertEquals(200, responseGetOwnerListRaw.statusCode());
        Assertions.assertNotEquals(0, responseGetOwnerListDto.length);
    }

}
