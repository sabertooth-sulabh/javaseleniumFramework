import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumTest {
    @Test
    public void browserAutomation(){
        System.out.println("BrowserAuto");
        Assert.assertTrue(true);
    }

    @Test
    public void browseOpen(){
        System.out.println("OpenBrowser");
        Assert.assertTrue(true);
    }
}

