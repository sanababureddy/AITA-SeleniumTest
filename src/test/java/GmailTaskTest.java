import GmailObjects.GmailUIObjects;
import GmailObjects.LoginObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

import java.util.List;

public class GmailTaskTest extends base{
    public WebDriver driver;

    @BeforeTest
    public void invokeBrowser(){
        driver = initializeDriver();
        driver.get("https://www.google.com/intl/en-GB/gmail/about/");
    }

    @Test
    public void gmailLogin() throws InterruptedException {
        Actions actions = new Actions(driver);
        //for login Enable Less Secure app access in Account Security Settings
        String email = "abc@gmail.com";
        String passwrod = "123456";
        LoginObjects l= new LoginObjects(driver);
        l.SignIn().click();
        actions.sendKeys(email).build().perform();
        l.Next().click();
        Thread.sleep(2000);
        actions.sendKeys(passwrod).build().perform();
        l.Next().click();
        Thread.sleep(3000);
        GmailUIObjects ui = new GmailUIObjects(driver);
        ui.searchBox().click();
        actions.sendKeys("Google Community ").click().build().perform();

        List<WebElement> mails = ui.mailsList();
        //if number of entries less than 1 then condition will fail
        Assert.assertTrue(mails.size()>=1);

    }
    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
