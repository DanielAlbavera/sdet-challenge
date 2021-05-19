package pages.microsoft;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MicrosoftHomePage extends BasePage {

    @FindAll(@FindBy(xpath = "//nav[@id='uhf-g-nav']/descendant::a"))
    private List<WebElement> menuItems;

    @FindBy(xpath = "//nav[@id='uhf-g-nav']/descendant::a[contains(text(),'Windows')]")
    private WebElement windowsButton;

    public MicrosoftHomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMenuItems() {
        return menuItems;
    }

    public WebElement getWindowsButton() {
        return windowsButton;
    }

}
