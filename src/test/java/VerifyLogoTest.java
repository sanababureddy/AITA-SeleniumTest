import GmailObjects.GmailUIObjects;
import GmailObjects.LoginObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.util.List;

public class VerifyLogoTest extends base {
    public WebDriver driver;

    @BeforeTest
    public void invokeBrowser(){
        driver = initializeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void LogoTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys("AITA consulting services").build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='AITACS']")).click();
        WebElement image = driver.findElement(By.xpath("//a[@class='logoimga']/img"));
        Assert.assertTrue((Boolean)((JavascriptExecutor)driver).executeScript(
                "return !!arguments[0].complete && arguments[0].naturalWidth > 0;"
                , image));
    }
    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
