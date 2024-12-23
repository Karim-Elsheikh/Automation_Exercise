package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PageRefactory {


    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize, boolean headless) {


        if (browserName.equalsIgnoreCase("chrome") && !headless) {
            System.out.println("intializing Chrome Browser on Operating System : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("edge") && !headless) {
            System.out.println("intializing Edge Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            driver = new EdgeDriver();


        } else if (browserName.equalsIgnoreCase("firefox") && !headless) {
            System.out.println("firefox Driver initialized");
            System.out.println("intializing firefox Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            driver = new FirefoxDriver();


        } else if (browserName.equalsIgnoreCase("chrome") && headless) {
            System.out.println("HeadLess Chrome Driver initialized");

            ChromeOptions headlessOption = new ChromeOptions();
            headlessOption.addArguments("headless");
            System.out.println("intializing Chrome Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            driver = new ChromeDriver(headlessOption);

            System.out.println("Title is: " + driver.getTitle());
            System.out.println("Headless Chrome Driver run started");
        }
        if (maximize) {
            System.out.println("Window maximized");
            driver.manage().window().maximize();

        } else {
            System.out.println("Window isn't maximized");
            System.out.println(driver.manage().window().getSize());
        }
        return driver;
    }
}
