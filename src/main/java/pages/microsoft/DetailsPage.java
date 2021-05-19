package pages.microsoft;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends BasePage {

    @FindBy(xpath = "//*[@class='pi-price-text']/span")
    private WebElement detailsPrice;

    @FindBy(id = "buttonPanel_AddToCartButton")
    private WebElement addToCartButton;

    @FindBy(className = "sfw-dialog")
    private WebElement popUp;

    @FindBy(xpath = "(//*[@class='sfw-dialog']/div)[1]")
    private WebElement closePopupButton;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getPopUp() {
        return popUp;
    }

    public WebElement getClosePopupButton() {
        return closePopupButton;
    }

    public WebElement getDetailsPrice() {
        return detailsPrice;
    }
}
