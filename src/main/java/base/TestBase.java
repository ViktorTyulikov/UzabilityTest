package base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by ViktorTyulikov on 5/5/2015.
 */
public class TestBase {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/spring/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
