package automationExercise.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.JsonFileManager;
import utilities.ElementActions;

public class MainMenuPage {
    private WebDriver driver;
    private JsonFileManager testData;
    //locators
    private By signupOrLoginButton = By.xpath("//a[@href='/login']");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By loggedInAsUsername = By.cssSelector("a>b");


    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/TestData.json");

    }

    //Assertions
    public MainMenuPage assertOnLoggedInAsUserName() {
        Assert.assertEquals(driver.findElement(loggedInAsUsername).getText(), (testData.getTestData("username")), "userNameNotFound!");
        System.out.println("User name is displayed: " + driver.findElement(loggedInAsUsername).getText().contains(testData.getTestData("username")));
        return this;
    }
        //Actions

        public  MainMenuPage clickOnSignUpSignInLink () {
            ElementActions.click(driver, signupOrLoginButton);
            return this ;
        }


        public MainMenuPage deleteAccount() {
            ElementActions.click(driver, deleteAccountButton);
            return this ;
        }


    }
