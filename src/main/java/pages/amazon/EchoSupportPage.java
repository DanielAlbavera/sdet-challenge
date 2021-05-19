package pages.amazon;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EchoSupportPage extends BasePage {

    @FindAll(@FindBy(xpath = "//*[@class='help-content']/descendant::h4"))
    private List<WebElement> echoLabels;

    public EchoSupportPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getEchoLabels() {
        return echoLabels;
    }

}
