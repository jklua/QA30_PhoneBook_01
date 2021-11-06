import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{

}

public class RegistrationTest {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void registrationTestPositive(){

        int i=(int) (System.currentTimeMillis()/1000)%3600;
        String email = "nik"+i+"@gmail.com";
        String password = "Nik12345$";
        System.out.println("Email: "+email);

        openLoginRegistrationForm();
        fillLoginRegistratonForm(email,password);
        submitRegistration();

        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }

    private boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistratonForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void type(By locator, String text){
        if(text !=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
    }
    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    @Test
    public void registrationTestWrongEmail(){

        int i=(int) (System.currentTimeMillis()/1000)%3600;
        String email = "nik"+i+"gmail.com";
        String password = "Nik12345$";
        System.out.println("Email: "+email);
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
