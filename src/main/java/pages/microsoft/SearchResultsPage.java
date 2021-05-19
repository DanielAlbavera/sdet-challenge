package pages.microsoft;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindAll(@FindBy(xpath = "(//span[contains(text(),'Software (')]/following::div)[1]/descendant::span[@itemprop='price']"))
    private List<WebElement> softwarePricesList;

    @FindAll(@FindBy(xpath = "(//span[contains(text(),'Software (')]/following::div)[1]/descendant::a"))
    private List<WebElement> softwareLinks;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSoftwarePricesList() {
        return softwarePricesList;
    }

    public List<WebElement> getSoftwareLinks() {
        return softwareLinks;
    }
}
