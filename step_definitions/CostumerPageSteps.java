package com.gmibank.step_definitions;

import com.gmibank.pages.CreateNewCustomerPage;
import com.gmibank.utilities.CommonMethods;
import com.gmibank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CostumerPageSteps {
    CreateNewCustomerPage customerPage = new CreateNewCustomerPage();

    @When("Enter a Valid SSN")
    public void enter_a_Valid_SSN() {
        customerPage.ssnTextBox.sendKeys(ConfigurationReader.getProperty("user_ssn"));
        customerPage.ssnSearchButton.click();
    }

    @And("Clear the address box and enter a new {string} information")
    public void clearTheAddressBoxAndEnterANewInformation(String address) {
        CommonMethods.waitForClickablility(customerPage.addressBox, 3);
        customerPage.addressBox.clear();
        CommonMethods.waitForClickablility(customerPage.addressBox, 3);
        customerPage.addressBox.sendKeys(address);

    }

    @Then("Click City box and Verify {string} entered properly")
    public void clickCityBoxAndVerifyEnteredProperly(String address) {
        customerPage.cityBox.click();
        customerPage.addressBox.click();
        String actual = customerPage.addressBox.getAttribute("value");
        System.out.println("actual = " + actual);
        System.out.println("expected = " + address);
        Assert.assertEquals(actual, address, "There is no address info");
        customerPage.addressBox.clear();

    }

    @When("left blank in address box")
    public void leftBlankInAddressBox() {
        customerPage.addressBox.clear();
        CommonMethods.waitForClickablility(customerPage.addressBox, 3);
        customerPage.cityBox.click();
    }

    @Then("Verify that {string} message is displayed")
    public void verifyThatMessageIsDisplayed(String message) {
        CommonMethods.waitFor(2);
        customerPage.addressBox.click();
        String actual = customerPage.addressFeedback.getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + message);
        Assert.assertEquals(actual, message, "Text box is not empty");
    }

    @And("Clear the City box and enter a new {string} information")
    public void clearTheCityBoxAndEnterANewInformation(String city) {
        customerPage.cityBox.clear();
        CommonMethods.waitForVisibility(customerPage.cityBox, 3);
        customerPage.cityBox.sendKeys(city);

    }

    @Then("Click Country box and Verify {string} entered properly")
    public void clickCountryBoxAndVerifyEnteredProperly(String city) {
        customerPage.countryBox.click();
        CommonMethods.waitFor(2);
        customerPage.cityBox.click();
        String actual = customerPage.cityBox.getAttribute("value");
        System.out.println("expected = " + city);
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual, city, "There is no address info");
    }

    @When("left blank in city box")
    public void leftBlankInCityBox() {
        customerPage.cityBox.click();
    }

    @Then("Verify that {string} message")
    public void verifyThatMessage(String message) {
        CommonMethods.waitFor(2);
        customerPage.ssnTextBox2.click();
        String actual = customerPage.cityFeedback.getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + message);
        Assert.assertEquals(actual, message, "Text box is not empty");
    }
/*
    @And("Clear the Country box and enter a new {string} information")
    public void clearTheCountryBoxAndEnterANewInformation(String country) {
        customerPage.countryBox.click();

        Select select = new Select(Driver.getDriver().findElement(By.xpath("/select[@name='country.id']")));

    }

    @Then("Click State box and Verify {string} entered properly")
    public void clickStateBoxAndVerifyEnteredProperly(String country) {
        customerPage.stateBox.click();
        CommonMethods.waitFor(2);
        customerPage.countryBox.click();
        String actual =  customerPage.countryBox.getAttribute("value");
        System.out.println("actual = " + actual);
        System.out.println("expected = " + country);
        Assert.assertEquals(actual,country,"There is no address info");
    }
    */

 /*
    @When("left blank in country box")
    public void leftBlankInCountryBox() {
        customerPage.countryBox.click();

    }

    @Then("Verify that {string} message is not displayed")
    public void verifyThatMessageIsNotDisplayed(String message) {
        CommonMethods.waitFor(2);
        customerPage.stateBox.click();
        System.out.println("expected = " + message);
        WebElement warningMessage = Driver.getDriver().findElement()

    }
*/

    @And("Clear the State box and enter a new {string} information")
    public void clearTheStateBoxAndEnterANewInformation(String state) {
        customerPage.stateBox.clear();
        CommonMethods.waitForClickablility(customerPage.stateBox, 3);
        customerPage.stateBox.sendKeys(state);

    }

    @Then("Click zip code box and verify {string} entered properly")
    public void clickZipCodeBoxAndVerifyEnteredProperly(String state) {
        customerPage.ssnTextBox2.click();
        customerPage.stateBox.click();
        String actual = customerPage.stateBox.getAttribute("value");
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual, state, "There is no state info");
    }



/*
    @When("left blank in state box")
    public void leftBlankInStateBox() {
        customerPage.stateBox.sendKeys(" ", Keys.ENTER);
    }
*/

}
