import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

public class NavigationTest  extends base {
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
        WebElement about = driver.findElement(By.cssSelector("[href*='who-we-are/']"));
        actions.moveToElement(about).build().perform();
        WebDriverWait wait = new WebDriverWait(driver,5);
        By carreer = By.xpath("//a[text()='Careers']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(carreer));
        actions.moveToElement(driver.findElement(carreer)).build().perform();
        By openings = By.xpath("//a[text()='Current Openings']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(openings));
        actions.moveToElement(driver.findElement(openings)).click().build().perform();
    }

}
