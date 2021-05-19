package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverManager;

import java.util.concurrent.TimeUnit;

public class BaseTest  {

    protected WebDriver driver;
    String browser = "chrome";

    @BeforeMethod()
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeClass()
    public void setUp() {
        driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
