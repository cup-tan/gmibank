package com.gmibank.step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmibank.pojos.Country1;
import com.gmibank.pojos.Customer1;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.ReadTxt;
import com.gmibank.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import sun.management.counter.StringCounter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static io.restassured.RestAssured.given;

public class CustomersApiSteps {
    Response response;

    @Given("read all customers data using api end point {string} bank61")
    public void read_all_customers_data_using_api_end_point_bank61(String api_endpoint) {
        response = given().headers("Authorization",
                        "Bearer " + ConfigurationReader.getProperty("token"),
                        "ContentType.Json", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();

    }

    @Then("validate customers data bank61")
    public void validate_customers_data_bank61() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer1[] customer1 = objectMapper.readValue(response.asString(), Customer1[].class);

        // ilk musterinin adi
        System.out.println(customer1[0].getFirstName());

        //6.musterinin ssn numarasi
        System.out.println("6. customer ssn info  = " + customer1[5].getSsn());

        //ilk 10 musterinin lastname yazdir

        for (int i = 0; i < 10; i++) {
            System.out.println("ilk 10 customers' lastname = " + customer1[i].getLastName());
        }
        System.out.println("============================================");
        // butun musterilerin icinde ismi s harfiyle baslayan hepsini cekin

        for (int i = 0; i < customer1.length; i++) {
            if (customer1[i].getFirstName().startsWith("M")) {
                System.out.println("customers = " + customer1[i].getFirstName() + ", email = " + customer1[i].getEmail());
            }
        }

        // ilk musterinin user icindeki firstname
        System.out.println(customer1[0].getUser().getFirstName());

        // all customers user icindeki all id
       // her musterin useri yok
        for (int i = 0; i < customer1.length; i++) {
            if (customer1[i].getUser() != null) {
                System.out.println("customer id = " + customer1[i].getUser().getId());

            }
        }


    }




//=================== read all countries =====================

    @Then("read all countries and write countries id to text using api {string} bank")
    public void readAllCountriesAndWriteCountriesIdToTextUsingApiBank(String countries_endpoint) throws IOException {

        response =
                given()
                        .auth().oauth2(ConfigurationReader.getProperty("token"))
                        .accept(ContentType.JSON)
                        .when()
                        .get(countries_endpoint)
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response()
                        .prettyPeek();

        // 1. asama country idlerini bir listenin icine atalim

        List<String> countryId = new ArrayList<>();

        // objectMapper kullanarak deserialization yapicaz ve country idlerini listin icine aticaz

        ObjectMapper objectMapper = new ObjectMapper(); // object mapperla pojo classtaki objectleri okudu
        Country1 [] country1 = objectMapper.readValue(response.asString(),Country1[].class); // bunlar integer olacak

        //for loop ile country idlerini list icine ekleyecez
        for (int i = 0; i < country1.length ; i++) {
            countryId.add(String.valueOf(country1[i].getId())); // valueOf kullandik int i string e cevirdi
        }

        // 2. asama country idlerini txt dosyasi olarak yazdiralim

        WriteToTxt.saveDataInFileWithCountry1Id("CountryIdBank61",country1);

        // 3. asama olusturulan txt dosyasindaki bilgileri okutalim

        List<String> readTxtCountryId = ReadTxt.returnCountry1IdList("CountryIdBank61"); // txt dosyasi onceden yapildigi icin tekrar uzerine eklememesi icin silmemiz lazim.ya da yeni bir isim

        // 4. asama ilk olusturulan list ile son olusturulan listin karsilastirilmasi - validation

        Assert.assertEquals("not match" , countryId , readTxtCountryId);

        System.out.println("=================================================");
        System.out.println("Validation is successful");

    }
//=================== create all countries =====================

}

