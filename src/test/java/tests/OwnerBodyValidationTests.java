package tests;

import com.github.javafaker.Faker;
import controllers.OwnerController;
import models.OwnerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OwnerBodyValidationTests extends BaseTest {

    @Test
    public void CreateOwnerOneLetterFirstNameTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName("A")
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }


    @Test
    public void CreateOwnerOneLetterLastNameTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName("B")
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }


    @Test
    public void CreateOwnerLowerCaseFirstNameTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName("aaron")
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }


    @Test
    public void CreateOwnerLowerCaseLastNameTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName("smith")
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }



    @Test
    public void CreateOwnerAddressWithSpecialSymbolsTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address("#68 East Mack-shire !@#$%^&*()_+-=`~.,/<>;:' str")
                .city(faker.address().city())
                .telephone(faker.numerify("##########"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }


    @Test
    public void CreateOwnerAddressCityWithSpecialSymbolsTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city("!Chicago !@#$%^&*()_+-=`~,./<>;:'")
                .telephone(faker.numerify("##########"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }


    @Test
    public void CreateOwnerPhoneOneDigitTest() {
        //arrange
        var ownerController = new OwnerController();
        var faker = new Faker();
        var requestPostDto = OwnerDto.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .telephone(faker.numerify("#"))
                .build();

        //act
        var responsePostRaw = ownerController.postRequest(requestPostDto);
        var responsePostDto = responsePostRaw.as(OwnerDto.class);

        //assert
        Assertions.assertEquals(201, responsePostRaw.statusCode());
        Assertions.assertEquals(responsePostDto, requestPostDto);
        System.out.println("\n " + convertDtoToJson(requestPostDto));
        System.out.println("\n " + convertDtoToJson(responsePostDto));
    }





}
