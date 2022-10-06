package com.gmibank.step_definitions;

import com.github.javafaker.Faker;
import com.gmibank.pages.CommonPageElements;
import com.gmibank.pages.DateCreatePage;
import com.gmibank.utilities.CommonMethods;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DateCreateStepdefinitions {

    WebElement driver;
    CommonPageElements common=new CommonPageElements();
    DateCreatePage us011 = new DateCreatePage();
    Faker faker=new Faker();
    String ssn=faker.random().nextInt(100,999)
            +"-"+faker.random().nextInt(10,99)+"-"+faker.random().nextInt(1000,9999);


    @Given("Go to GMIBank page")
    public void go_to_GMIBank_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));
    }

    @Given("Sign in with valid employee user name and password")
    public void sign_in_with_valid_employee_user_name_and_password() throws InterruptedException {
        us011.loginModule.click();
        Thread.sleep(2000);
        us011.homePageSignIn.click();
        us011.userName.sendKeys(ConfigurationReader.getProperty("employee_username"));
        us011.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
        us011.signInButton.click();
    }

    @Given("Select My Operations Menu")
    public void select_My_Operations_Menu() {
       us011.myOperations.click();
    }

    @Given("Management Customers")
    public void management_Customers() {
       us011.manageCustomer.click();
    }

    @Given("Create New Customer")
    public void create_New_Customer() {
        us011.newCustomer.click();
    }

    @Given("Fill out valid SSN")
    public void fill_out_valid_SSN() throws InterruptedException {
        us011.user_ssn.sendKeys(ssn);
        Thread.sleep(2000);

    }

//    @Given("Click search button")
//    public void click_search_button() {
//        us011.searchbutton.click();
//    }

    @Given("Fill out valid firstname")
    public void fill_out_valid_firstname() {
        us011.firstname.sendKeys(faker.name().firstName());
    }

    @Given("Fill out valid surname")
    public void fill_out_valid_surname() {
        us011.surname.sendKeys(faker.name().lastName());
    }

    @Given("Fill out valid middle initial")
    public void fill_out_valid_middle_initial() {
        us011.middleinitial.sendKeys(faker.name().nameWithMiddle());
    }

    @Given("Fill out valid email")
    public void fill_out_valid_email(){us011.email.sendKeys(faker.internet().emailAddress());

    }
    @Given("Fill out valid mobile number")
    public void fill_out_valid_mobile_number() {
        us011.mobileNumber.sendKeys(faker.random().nextInt(100,999)
                +"-"+faker.random().nextInt(100,999)+"-"+faker.random().nextInt(1000,9999));
    }

    @Given("Fill out valid phone number")
    public void fill_out_valid_phone_number() {
        us011.phoneNumber.sendKeys(faker.random().nextInt(100,999)
                +"-"+faker.random().nextInt(100,999)+"-"+faker.random().nextInt(1000,9999));
    }

    @Given("Fill out valid zip code")
    public void fill_out_valid_zip_code() {
        us011.zipcode.sendKeys(faker.number().digit());
    }

    @Given("Fill out valid address")
    public void fill_out_valid_address() {
        us011.address.sendKeys(faker.address().streetAddress());
    }

    @Given("Fill out valid city")
    public void fill_out_valid_city() {
        us011.city.sendKeys(faker.address().city());
    }
    @Given("Fill out valid ssn")
    public void fill_out_valid_ssn(){
        us011.checkssn.sendKeys(ssn);
    }
    @Given("Fill out valid country")
    public void fill_out_valid_country() {
        Select ls=new Select(us011.country);
        ls.selectByIndex(faker.random().nextInt(999));
    }

    @Given("Fill out valid state")
    public void fill_out_valid_state() {
        us011.state.sendKeys(faker.address().state());
    }

    @Then("Not choose any account")
    public void not_choose_any_account() {
        Select ls=new Select(us011.account);
        ls.selectByIndex(0);
    }

    @Then("Not Select Zelle Enrolled")
    public void not_Select_Zelle_Enrolled() {
        if(us011.zelle.isSelected()){
            us011.zelle.click();
        }

    }

    @Then("Save it")
    public void save_it() {
        us011.save.click();
    }

    @Then("Tests that you are saved")
    public void tests_that_you_are_saved() {

        Assert.assertEquals(CommonMethods.jsGetInnerText(us011.toastMessage),
                "translation-not-found[gmiBankBackendApp.tPCustomer.created]");
    }

}
