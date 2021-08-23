package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public String projectPath = System.getProperty("user.dir");

    public WebDriver initializeDriver() {
        //System.setProperty("webdriver.chrome.driver", projectPath + "//src//main//resources//chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", projectPath + "//src//main//resources//chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
}
