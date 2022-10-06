package com.gmibank.step_definitions;

import com.gmibank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class StateApiSteps {
   Response response;

    @Given("read all state data using api end point {string}")
    public void readAllStateDataUsingApiEndPoint(String state_endPoint) {
       response =
               given()
                        .auth().oauth2(ConfigurationReader.getProperty("token"))
                        .accept(ContentType.JSON)
               .when()
                        .get(state_endPoint)
               .then()
                         .contentType(ContentType.JSON)
                         .extract().response()
                         .prettyPeek();


    }

    @Then("validate state data")
    public void validateStateData() {

    }
}
