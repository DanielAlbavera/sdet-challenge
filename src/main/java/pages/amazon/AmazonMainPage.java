package pages.amazon;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonMainPage extends BasePage {

    @FindBy(id = "nav-link-accountList")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Start here')]")
    private WebElement startHereLink;

    @FindBy(className = "aee-xop-tooltip nav-flyout")
    private WebElement popUp;

    @FindBy(xpath = "(//*[class='a-button-input')[1]")
    private WebElement closePopUpButton;

    public AmazonMainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getStartHereLink() {
        return startHereLink;
    }

    public WebElement getPopUp() {
        return popUp;
    }

    public WebElement getClosePopUpButton() {
        return closePopUpButton;
    }
}
