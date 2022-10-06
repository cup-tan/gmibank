package com.gmibank.step_definitions;

import com.gmibank.pages.CommonPageElements;
import com.gmibank.pages.CreateNewCustomerPage;
import com.gmibank.pages.ManageCustomersPage;
import com.gmibank.utilities.CommonMethods;
import com.gmibank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class CreateNewCustomerSteps {
    CommonPageElements commonModule = new CommonPageElements();
    ManageCustomersPage createButton = new ManageCustomersPage();
    CreateNewCustomerPage newCustomerPage = new CreateNewCustomerPage();

    @And("Employee clicks My operations module and Manage customers")
    public void employeeClicksMyOperationsModuleAndManageCustomers() {
        commonModule.myOperations.click();
        CommonMethods.waitForVisibility(commonModule.manageCostumers, 2);
        commonModule.manageCostumers.click();
    }

    @And("Employee clicks on Create a new Customer button")
    public void employeeClicksOnCreateANewCustomerButton() {
        createButton.createNewCustomer.click();
        CommonMethods.waitFor(2);
    }

    @When("Employee Search a new applicant by their SSN")
    public void employeeSearchANewApplicantByTheirSSN() {
        newCustomerPage.ssnTextBox.sendKeys(ConfigurationReader.getProperty("user_ssn"));
        newCustomerPage.ssnSearchButton.click();
    }

    @Then("Verify user information populated")
    public void verifyUserInformationPopulated(Map<String, String> userInfo) {
        CommonMethods.waitFor(3);
        String expectedFirstname = userInfo.get("firstname"); // asli
         String actualFirstname = newCustomerPage.firstnameBox.getAttribute("value");
        System.out.println("actualFirstname = " + actualFirstname);
        Assert.assertEquals(expectedFirstname, actualFirstname, "There is no element");

        String expectedLastname = userInfo.get("lastname");
        String actualLastname = newCustomerPage.lastnameBox.getAttribute("value");
        System.out.println("actualLastname = " + actualLastname);
        Assert.assertEquals(expectedLastname, actualLastname, "There is no element");

        String expectedMiddleName = userInfo.get("middleInitial");
        System.out.println("expectedMiddleName = " + expectedMiddleName);
        String actualMiddleName = newCustomerPage.middleNameBox.getAttribute("value");
        System.out.println("actualMiddleName = " + actualMiddleName);
        Assert.assertEquals(expectedMiddleName, actualMiddleName);

        String expectedEmail = userInfo.get("email");
        String actualEmail = newCustomerPage.emailBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        Assert.assertEquals(expectedEmail, actualEmail, "There is no element");

        String expectedMobilePhone = userInfo.get("mobilePhone");
        String actualMobilePhone = newCustomerPage.mobilePhoneBox.getAttribute("value");
        System.out.println("actualMobilePhone = " + actualMobilePhone);
        Assert.assertEquals(expectedMobilePhone, actualMobilePhone, "There is no element");

        String expectedPhoneNumber = userInfo.get("phoneNumber");
        System.out.println("expectedPhoneNumber = " + expectedPhoneNumber);
        String actualPhoneNumber = newCustomerPage.phoneNumberBox.getAttribute("value");
        System.out.println("actualPhoneNumber = " + actualPhoneNumber);
        Assert.assertEquals(expectedPhoneNumber, actualPhoneNumber);

        String expectedZipCode = userInfo.get("zipCode");
        System.out.println("expectedZipCode = " + expectedZipCode);
        String actualZipCode = newCustomerPage.zipCodeBox.getAttribute("value");
        System.out.println("actualZipCode = " + actualZipCode);
        Assert.assertEquals(expectedZipCode, actualZipCode);

        CommonMethods.waitForVisibility(newCustomerPage.addressBox, 5);
        String expectedAddress = userInfo.get("address");
        String actualAddress = newCustomerPage.addressBox.getAttribute("value");
        System.out.println("actualAddress = " + actualAddress);
        Assert.assertEquals(expectedAddress, actualAddress, "There is no element");

        String expectedCity = userInfo.get("city");
        System.out.println("expectedCity = " + expectedCity);
        String actualCity = newCustomerPage.cityBox.getAttribute("value");
        System.out.println("actualCity = " + actualCity);
        Assert.assertEquals(expectedCity, actualCity);

        String expectedSSN = userInfo.get("ssn");
        System.out.println("expectedSSN = " + expectedSSN);
        String actualSSN = newCustomerPage.ssnTextBox.getAttribute("value");
        System.out.println("actualSSN = " + actualSSN);
        Assert.assertEquals(expectedSSN, actualSSN, "There is no element");

        String expectedCountry = userInfo.get("country");
        System.out.println("expectedCountry = " + expectedCountry);
        String actualCountry = newCustomerPage.countryBox.getAttribute("value");
        System.out.println("actualCountry = " + actualCountry);
        Assert.assertEquals(expectedCountry, actualCountry);

        String expectedState = userInfo.get("state");
        System.out.println("expectedState = " + expectedState);
        String actualState = newCustomerPage.stateBox.getAttribute("value");
        System.out.println("actualState = " + actualState);
        Assert.assertEquals(expectedState, actualState);

        Select select = new Select(newCustomerPage.countryBox);
        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
        System.out.println("allSelectedOptions.size() = " + allSelectedOptions.size());
        System.out.println("allSelectedOptions = " + allSelectedOptions);
        System.out.println("allSelectedOptions.get(0) = " + allSelectedOptions.get(0).toString());

        String expectedUser = userInfo.get("user");
        System.out.println("expectedUser = " + expectedUser);
        String actualUser = newCustomerPage.userBox.getAttribute("value");
        System.out.println("actualUser = " + actualUser);
        Assert.assertEquals(expectedUser, actualUser);

        Select select1 = new Select(newCustomerPage.userBox);
        List<WebElement> allOptions = select1.getAllSelectedOptions();
        System.out.println("allOptions.size() = " + allOptions.size());
        System.out.println("allOptions.get(0).toString() = " + allOptions.get(0).toString());

        String expectedAccount = userInfo.get("account");
        System.out.println("expectedAccount = " + expectedAccount);
        String actualAccount = newCustomerPage.userBox.getAttribute("value");
        System.out.println("actualAccount = " + actualAccount);
        Assert.assertEquals(expectedAccount, actualAccount);

        Select select2 = new Select(newCustomerPage.AccountBox);
        List<WebElement> selectedOptions = select2.getAllSelectedOptions();
        System.out.println("selectedOptions = " + selectedOptions);
        System.out.println("selectedOptions.size() = " + selectedOptions.size());
    }
}


