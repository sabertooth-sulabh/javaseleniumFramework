package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObj {

    public WebDriver driver;

    public LoginPageObj(WebDriver driver) {

        this.driver = driver;
    }

    By loginLink = By.xpath("(//*[@data-toggle = 'modal'])[1]");

    public WebElement getLoginLink() {

        return driver.findElement(loginLink);
    }

    By email = By.xpath("//*[@id  = 'login-username']");
    By password = By.xpath("//*[@id  = 'login-password']");
    By submitButton  = By.xpath("//*[@id  = 'login-button']");

    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getPassword(){
        return driver.findElement(password);
    }
    public WebElement getSubmitButton(){
        return driver.findElement(submitButton);
    }
}
