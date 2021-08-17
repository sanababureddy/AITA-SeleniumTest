package GmailObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {
    public WebDriver driver;
    public LoginObjects(WebDriver driver){
        this.driver = driver;
    }

    private  By SignInBtn = By.cssSelector("[data-action='sign in']");
    private By nextBtn = By.xpath("//span[normalize-space()='Next']");

    public WebElement SignIn(){
        return driver.findElement(SignInBtn);
    }
    public WebElement Next(){
        return driver.findElement(nextBtn);
    }
}
