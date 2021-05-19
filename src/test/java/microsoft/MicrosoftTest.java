package microsoft;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.microsoft.*;

public class MicrosoftTest extends BaseTest {

    String url = "https://www.microsoft.com/es-mx/";

    private MicrosoftHomePage microsoftHomePage;
    private WindowsPage windowsPage;
    private SearchResultsPage searchResultsPage;
    private DetailsPage detailsPage;
    private CartPage cartPage;

    //Expected variables
    private String expected_windows_page = "https://www.microsoft.com/es-mx/windows/";
    private String getExpected_search_page = "https://www.microsoft.com/es-mx/search";
    private String search_term = "Visual Studio";
    String items_quantity = "20";

    //Storage Variables
    String first_element_price = "";
    float expected_total;

    @Test(priority = 1, description = "Go to Microsoft Page")
    public void goToMicrosoftPage() {
        microsoftHomePage = new MicrosoftHomePage(driver);
        microsoftHomePage.navigate(url);
        microsoftHomePage.waitUntilPageLoads(driver);
        Assert.assertEquals(microsoftHomePage.getCurrentUrl(driver),url);
    }

    @Test(priority = 2, description = "Validate All Menu Items are present")
    public void validateMenus() {
        for (WebElement menuItem: microsoftHomePage.getMenuItems()) {
            microsoftHomePage.explicitWait(driver,menuItem);
            Assert.assertTrue(microsoftHomePage.isDisplayed(menuItem));
        }
    }

    @Test(priority = 3, description = "Go to Windows")
    public void goToWindows() {
        microsoftHomePage.click(microsoftHomePage.getWindowsButton());
        Assert.assertEquals(microsoftHomePage.getCurrentUrl(driver),expected_windows_page);
    }

    @Test(priority = 4, description = "Click Windows 10 Menu")
    public void clickWindows10() {
        windowsPage = new WindowsPage(driver);
        windowsPage.click(windowsPage.getWindowsDropdownButton());
        System.out.println("\nPrint Widows Options:\n");
        for (WebElement option : windowsPage.getWindows10Options()){
            windowsPage.explicitWait(driver,option);
            System.out.println(windowsPage.getTextByAttribute(option));
        }
    }

    @Test(priority = 5, description = "Go to Search next to the shopping cart")
    public void goToSearch(){
        windowsPage.explicitWait(driver,windowsPage.getSearchButton());
        windowsPage.click(windowsPage.getSearchButton());
        Assert.assertTrue(windowsPage.isDisplayed(windowsPage.getSearchBar()));
    }

    @Test(priority = 6,description = "Search for Visual Studio")
    public void search() {
        windowsPage.insertText(windowsPage.getSearchBar(),search_term);
        windowsPage.click(windowsPage.getSearchButton());
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.explicitWait(driver,searchResultsPage.getSoftwareLinks().get(0));
        Assert.assertTrue(searchResultsPage.getCurrentUrl(driver).contains(getExpected_search_page));
    }

    @Test(priority = 7,description = "Print the price for the 3 first elements listed in Software result list")
    public void printFirstThreeSoftwareItemsPrice() {
        System.out.println("\nPrint Prices:\n");
        for (int i = 0; i < 3; i++) {
            searchResultsPage.explicitWait(driver,searchResultsPage.getSoftwarePricesList().get(i));
            System.out.println(searchResultsPage.getText(searchResultsPage.getSoftwarePricesList().get(i)));
        }
    }

    @Test(priority = 8,description = "")
    public void getFirstElementPrice() {
        first_element_price = searchResultsPage.getText(searchResultsPage.getSoftwarePricesList().get(0));
    }

    @Test(priority = 9, description = "Click on the first one to go to the details page")
    public void clickFirstElement() {
        searchResultsPage.click(searchResultsPage.getSoftwareLinks().get(0));
    }

    @Test(priority = 10,description = "Once in the details page, validate both prices are the same")
    public void validatePrices() {
        detailsPage = new DetailsPage(driver);
        detailsPage.explicitWait(driver, detailsPage.getPopUp());
        if (detailsPage.getPopUp().isDisplayed()) {
            detailsPage.click(detailsPage.getClosePopupButton());
            detailsPage.backToDefaultFrame(driver);
        }
        Assert.assertEquals(first_element_price,detailsPage.getText(detailsPage.getDetailsPrice()));
    }

    @Test(priority = 11,description = "Click Add To Cart")
    public void addToCart() {
        detailsPage.click(detailsPage.getAddToCartButton());
    }

    @Test(priority = 12,description = "Verify all 3 price amounts are the same")
    public void validateCartPrices() {
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getText(cartPage.getFirstPrice()),
                            cartPage.getText(cartPage.getSecondPrice()),
                            cartPage.getText(cartPage.getThirdPrice()));
    }

    @Test(priority = 13,description = "On the # of items dropdown select 20 and validate the Total amount is Unit Price * 20")
    public void validateTotalAmount() {
        if(cartPage.getNoPopUpButton().isDisplayed()) {
            cartPage.click(cartPage.getNoPopUpButton());
            cartPage.backToDefaultFrame(driver);
        }
        cartPage.selectByValue(cartPage.getItemQuantityDropDown(), items_quantity);
        cartPage.click(cartPage.getTotalPrice());
        expected_total = cartPage.getFloatNumbers(cartPage.getText(cartPage.getFirstPrice())) * Integer.parseInt(items_quantity);
        System.out.println("\nPrint total prices:\n");
        System.out.println(expected_total);
        System.out.println(cartPage.getText(cartPage.getTotalPrice()));
        Assert.assertEquals(expected_total,cartPage.getFloatNumbers(cartPage.getText(cartPage.getTotalPrice())));
    }

}
