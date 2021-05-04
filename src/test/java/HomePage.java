
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPageObj;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class HomePage extends Base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initilize() throws IOException {
        driver = initilizeDriver();
        driver.get(prop.getProperty("url"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Driver is initilize");
    }

    @Test(dataProvider = "getData")
    public void basePageNav(String email, String password){

        LoginPageObj logObj = new LoginPageObj(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logObj.getLoginLink().click();
        log.info("Clicked on login link");
        System.out.println(email + " " +password);
        logObj.getEmail().sendKeys(email);
        log.info("Email Sent");
        logObj.getPassword().sendKeys(password);
        log.info("password sent ");
        logObj.getSubmitButton().click();
        log.info("Clicked on login button");
        assert logObj.getLoginLink().isDisplayed();
        //Assert.assertTrue(true);

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @DataProvider
    public Object[][] getData(){
        //row stand for how many diffrent data
        //coloumn stands for no's of values
        Object[][] data = new Object[1][2];
        data[0][0] = "testingagent2@yopmail.com";
        data[0][1] = "A@a12345";
        //2nd Set of Data
        //data[0][0] = "testingagent3@gmail.com";
        //data[0][1] = "A@a12345";
        return data;
    }
}
