package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver getDriver(String browser) {

        if (browser == "chrome") {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        if (browser == "firefox" || browser == "mozilla") {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

        if (browser == "edge") {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }

        return null;
    }

}
