package automationExercise.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class SignupAndLoginPage {
private WebDriver driver ;
    private String url = "https://automationexercise.com/login ";
    private By nameField = By.cssSelector("input[name=name]");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupPutton = By.xpath("//button[@data-qa='signup-button']");




    public SignupAndLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void getUrl(){
        driver.get(url);
    }

@Step("Step 3 : fill in username,mail & click on signup button")
    public void fillAccountInformation(String name, String Mail) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(Mail);
         ElementActions.click(driver,signupPutton);


    }
}
