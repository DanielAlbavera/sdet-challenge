package amazon;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.amazon.*;

import java.util.ArrayList;

public class AmazonTest extends BaseTest {

    String url = "https://www.amazon.com/";

    private AmazonMainPage amazonMainPage;
    private CreateAccountPage createAccountPage;
    private HelpPage helpPage;
    private HelpResultsPage helpResultsPage;
    private EchoSupportPage echoSupportPage;

    //Expected variables:
    String expected_url = "https://www.amazon.com/";
    String search_term = "Echo support\n";

    //Validation Variables
    String employee_name;
    String email_suffix = "@fake.com";
    String email_prefix;

    @Test(priority = 1,description = "Go to Amazon main page")
    public void goToAmazonPage() {
        amazonMainPage = new AmazonMainPage(driver);
        amazonMainPage.navigate(url);
        amazonMainPage.waitUntilPageLoads(driver);
        Assert.assertEquals(expected_url,amazonMainPage.getCurrentUrl(driver));
    }

    @Test(priority = 2,description = "Locate at the upper right corner the button: Hello, Sign In Account & lists")
    public void clickSignIn() {
        try {
            if (amazonMainPage.isDisplayed(amazonMainPage.getPopUp())) {
                amazonMainPage.click(amazonMainPage.getClosePopUpButton());
                amazonMainPage.backToDefaultFrame(driver);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        amazonMainPage.hoverOver(driver,amazonMainPage.getLoginButton());
        amazonMainPage.explicitWait(driver,amazonMainPage.getStartHereLink());
    }

    @Test(priority = 3,description = "Click on “New customer? Start right here")
    public void locateSignIn() {
        amazonMainPage.click(amazonMainPage.getStartHereLink());
        createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.getCurrentUrl(driver).contains("register"));
    }

    @Test(priority = 4,description = "Fill Name field with the response of API")
    public void fillNameWithAPIResponse() {
        employee_name = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("http://dummy.restapiexample.com/api/v1/employee/1")
                .then()
                .extract()
                .path("data.employee_name");
        email_prefix = employee_name.replace(" ",".");
    }

    @Test(priority = 5,description = "Fill Email field with the data from the API response")
    public void fillEmail() {
        createAccountPage.insertText(createAccountPage.getEmail(),email_prefix+ email_suffix);
        System.out.println("email: "+email_prefix+ email_suffix);
    }

    @Test(priority = 6,description = "Click on Condition of Use link")
    public void clickConditionOfUseLink() {
        createAccountPage.explicitWait(driver,createAccountPage.getConditionsLink());
        createAccountPage.explicitWait(driver, createAccountPage.getConditionsLink());
        createAccountPage.getConditionsLink().click();

    }
    @Test(priority = 7,description = "Locate the search bar and Search for Echo")
    public void search() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        helpPage = new HelpPage(driver);
        helpPage.insertText(helpPage.getHelpSearchBar(),search_term);
    }

    @Test(priority = 8,description = "Locate 'Echo support' options and click on it")
    public void locateEchoSupport() {
        helpResultsPage = new HelpResultsPage(driver);
        helpResultsPage.click(helpResultsPage.getResultLink());
    }

    @Test(priority = 9,description = "Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting")
    public void ValidateEchoLabels() {
        echoSupportPage = new EchoSupportPage(driver);
        for (WebElement label : echoSupportPage.getEchoLabels()) {
            echoSupportPage.explicitWait(driver,label);
            Assert.assertTrue(echoSupportPage.isDisplayed(label));
        }
    }

}
