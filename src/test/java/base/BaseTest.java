package base;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverManager;
import utils.JDBCManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest  {

    protected WebDriver driver;
    protected JDBCManager jdbcManager;

    JSONParser jsonParser;
    FileReader reader;

    String browser = "chrome";

    @BeforeMethod()
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeClass()
    public void setUp() {
        driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
        //Initiate JDBC if needed
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
