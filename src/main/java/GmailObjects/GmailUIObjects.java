package GmailObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailUIObjects {
    public WebDriver driver;
    public GmailUIObjects(WebDriver driver){
        this.driver = driver;
    }

    private  By searchBox = By.xpath("//input[@placeholder='Search mail']");
    private  By mailsList = By.xpath("//table[@role='grid'] /tbody /tr");

    public WebElement searchBox(){
        return driver.findElement(searchBox);
    }
    public List<WebElement> mailsList(){
        return driver.findElements(mailsList);
    }

}
