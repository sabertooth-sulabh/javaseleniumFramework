import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void saveData(){
        System.out.println("SaveData");
        Assert.assertTrue(true);
    }

    @Test
    public void postJira(){
        System.out.println("PostJiera");
        System.out.println("PostJiera2");
        Assert.assertTrue(true);
    }
}
