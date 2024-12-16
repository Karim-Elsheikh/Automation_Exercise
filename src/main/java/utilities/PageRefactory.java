package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class PageRefactory {

    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize, boolean headless) {
        String os = System.getProperty("os.name").toLowerCase();  // تحديد النظام (Windows أو Linux/Ubuntu)

        // تشيك على النظام واختيار المتصفح بناءً على ذلك
        if (os.contains("win")) {
            // في حال كان Windows، نستخدم متصفح Edge
            if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                System.out.println("Initializing Edge Browser on Windows");
            }
        } else if (os.contains("nix") || os.contains("nux")) {
            // في حال كان Ubuntu أو Linux، نستخدم متصفح Chrome مع وضع headless
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080");
                }
                driver = new ChromeDriver(options);
                System.out.println("Initializing Chrome Browser on Ubuntu");
            }
        }

        // في حال عدم تحديد OS أو متصفح لا يتوافق مع الـ system
        if (driver == null) {
            System.out.println("Unsupported OS or Browser configuration");
            return null;
        }

        // إذا تم تفعيل خيار maximize، نكبر النافذة
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("Window is maximized");
        }
        return driver;
    }
}
