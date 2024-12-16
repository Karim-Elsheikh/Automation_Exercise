package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class PageRefactory {





    public class Factory {
        static WebDriver driver;

        public static WebDriver initiateDriver(String browserName, boolean maximize) {

//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                System.out.println("intializing Chrome Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.out.println("intializing firefox Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.out.println("intializing Edge Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
                driver = new EdgeDriver();
            }

            if (maximize) {
                driver.manage().window().maximize();
                System.out.println("window is maximized , and the window size is " + driver.manage().window().getSize());
            }
            return driver;
        }
    }
}