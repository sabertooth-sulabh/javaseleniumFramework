import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Base {

    public WebDriver driver;
    Properties prop;

    public WebDriver initilizeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\data.properties");

        prop.load(fis);
        String  browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){

            System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
        else if (browserName == "firefoix") {
            driver = new FirefoxDriver();

            }
        else if (browserName == "IE") {
                //driver = new InternetExplorerDriver();
            }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

        }
        public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
            TakesScreenshot ts=(TakesScreenshot) driver;
            File source =ts.getScreenshotAs(OutputType.FILE);
            String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
            FileUtils.copyFile(source,new File(destinationFile));
            return destinationFile;

        }


    }


