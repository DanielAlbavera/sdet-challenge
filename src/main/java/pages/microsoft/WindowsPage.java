package pages.microsoft;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WindowsPage extends BasePage {

    @FindBy(id = "c-shellmenu_44")
    private WebElement windowsDropdownButton;

    @FindAll(@FindBy(xpath = "//*[@id='c-shellmenu_44']/following-sibling::ul/child::li/a"))
    private List<WebElement> windows10Options;

    @FindBy(id = "search")
    private WebElement searchButton;

    @FindBy(id = "cli_shellHeaderSearchInput")
    private WebElement searchBar;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWindowsDropdownButton() {
        return windowsDropdownButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public List<WebElement> getWindows10Options() {
        return windows10Options;
    }
}
