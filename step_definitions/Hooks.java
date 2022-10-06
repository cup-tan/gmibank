//package com.gmibank.step_definitions;
//
//import com.gmibank.utilities.Driver;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//public class Hooks {
//
//    @Before
//   public void start(Scenario scenario) {
//        System.out.println("Setting up browser...");
//        System.out.println("Starting scenario : " + scenario.getName());
//        Driver.getDriver();
//    }
//
////    @Before(value = "@db", order = 1)
////    public void setUpDataBaseConnection() {
////        System.out.println("------>BEFORE ANNOTATION: DB CONNECTION CREATED <------");
////    }
//
//    @After(order = 1)
//    public void end(Scenario scenario) {
//        System.out.println("Ending scenario : " + scenario.getName());
//
//        if (scenario.isFailed()) {
//
//            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
//
//        Driver.closeDriver();
//    }
//}
//
