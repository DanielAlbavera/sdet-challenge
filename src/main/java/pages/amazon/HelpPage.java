package pages.amazon;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage {

    @FindBy(id = "helpsearch")
    private WebElement helpSearchBar;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHelpSearchBar() {
        return helpSearchBar;
    }

}
