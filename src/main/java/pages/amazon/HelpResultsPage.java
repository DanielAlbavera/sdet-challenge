package pages.amazon;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HelpResultsPage extends BasePage {

    @FindBy(xpath = "(//*[@class='a-link-normal'])[1]")
    private WebElement resultLink;

    public HelpResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getResultLink() {
        return resultLink;
    }

}
