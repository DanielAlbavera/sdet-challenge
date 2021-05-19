package pages.amazon;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "ap_customer_name")
    private WebElement name;

    @FindBy(id = "ap_email")
    private WebElement email;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "ap_password_check")
    private WebElement reenterPassword;

    @FindBy(className = "a-button-input")
    private WebElement createAccountButton;

    @FindBy(xpath = "(//a[@rel='noopener'])[1]")
    private WebElement conditionsLink;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getReenterPassword() {
        return reenterPassword;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public WebElement getConditionsLink() {
        return conditionsLink;
    }
}
