package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Select select;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Explicit Wait
    public void explicitWait(WebDriver driver, WebElement element) {
        if (wait == null) wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Implicit Wait
    public void waitUntilPageLoads(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void insertText(WebElement element,String text) {
        element.sendKeys(text);
    }

    public Boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getTextByAttribute(WebElement element) {
        return element.getAttribute("text");
    }

    public void backToDefaultFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public float getFloatNumbers(String string) {
        return Float.parseFloat(string.replaceAll("[^\\d.]", ""));
    }

    public void selectByValue(WebElement element,String value) {
        if (select == null) select = new Select(element);
        select.selectByValue(value);
    }

    public void hoverOver(WebDriver driver,WebElement element) {
        if(actions == null) actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

}
