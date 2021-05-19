package pages.microsoft;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'NO')]")
    private WebElement noPopUpButton;

    @FindBy(xpath = "(//*[@itemprop='price'])[1]")
    private WebElement firstPrice;

    @FindBy(xpath = "(//*[@itemprop='price'])[2]")
    private WebElement secondPrice;

    @FindBy(xpath = "(//*[@itemprop='price'])[3]")
    private WebElement thirdPrice;

    @FindBy(xpath = "//span/strong[contains(text(),'Total')]/following::span/strong/span")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@class='item-quantity']/select")
    private WebElement itemQuantityDropDown;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstPrice() {
        return firstPrice;
    }

    public WebElement getSecondPrice() {
        return secondPrice;
    }

    public WebElement getThirdPrice() {
        return thirdPrice;
    }

    public WebElement getItemQuantityDropDown() {
        return itemQuantityDropDown;
    }

    public WebElement getNoPopUpButton() {
        return noPopUpButton;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }
}
