import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver wd;

    @BeforeMethod
    public void init(){
    wd=new ChromeDriver();
    wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test

    public void loginPositiveTest(){

    }
    @AfterMethod

    public void tearDown(){
        wd.quit();

    }

}
