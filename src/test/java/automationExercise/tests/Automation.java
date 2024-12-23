package automationExercise.tests;

import automationExercise.Pages.*;
import org.testng.annotations.BeforeSuite;
import utilities.JsonFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PageRefactory;
import utilities.PropertiesReader;


public class Automation {

    WebDriver driver;
    private JsonFileManager testData;



    @Test
    @Description("Sign up successfully and delete the account")
    @Severity(SeverityLevel.CRITICAL)
    public void Signup() {
        new HomePage(driver)
                .navigate()
                .clickOnsignupOrLoginButton();
        new SignupAndLoginPage(driver)
                .fillAccountInformation(testData.getjsonTestData("username"),testData.getjsonTestData("mail"));
        new SignupFormPage(driver)
                .SelectDateOfBirth(testData.getjsonTestData("AccountInformation.Day"),testData.getjsonTestData("AccountInformation.Month"),testData.getjsonTestData("AccountInformation.Year"))
                .fillAddressInformation(testData.getjsonTestData("AccountInformation.Year"), testData.getjsonTestData("AccountInformation.FirstName"), testData.getjsonTestData("AccountInformation.LastName"),testData.getjsonTestData("AccountInformation.Company"), testData.getjsonTestData("AccountInformation.Address1"), testData.getjsonTestData("AccountInformation.Address2"),testData.getjsonTestData("AccountInformation.Country"),testData.getjsonTestData("AccountInformation.State"), testData.getjsonTestData("AccountInformation.City"), testData.getjsonTestData("AccountInformation.ZipCode"), testData.getjsonTestData("AccountInformation.MobileNumber"));
        new AccountSuccessMessagePage(driver)
                .assertAccountCreatedMessageIsDisplayed()
                .clickContinueButton();
        new MainMenuPage(driver)
                .assertOnLoggedInAsUserName()
                .deleteAccount();
        new DeleteAccountPage(driver)
                .assertAccountDeletedMessageIsDisplayed();

    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\


    @BeforeMethod
    public void setup() {

        driver = PageRefactory.initiateDriver(System.getProperty("browserName"), true, Boolean.parseBoolean(System.getProperty("headless")));
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/TestData.json");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }


    @BeforeSuite
    public void Properties() {
        PropertiesReader.loadProperties();
    }

}
