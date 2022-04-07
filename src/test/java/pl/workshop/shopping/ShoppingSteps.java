package pl.workshop.shopping;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.workshop.page.CartPage;
import pl.workshop.page.LoginPage;
import pl.workshop.page.MyStorePage;

public class ShoppingSteps {

    private WebDriver webDriver;

    private LoginPage loginPage;
    private MyStorePage storePage;
    private CartPage cartPage;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.webDriver = new ChromeDriver();

        loginPage = new LoginPage(webDriver);
        storePage = new MyStorePage(webDriver);
        cartPage = new CartPage(webDriver);
    }

    @After
    public void after(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) webDriver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        if (!scenario.isFailed()) {
            webDriver.close();
        }
    }

    @Given("^Page (.*) opened in browser")
    public void loginPageOpenedInBrowser(String url) {
        webDriver.get(url);
    }

    @When("^User sign$")
    public void clickSign() {
        loginPage.enterUserData();
        loginPage.clickLogin();
        loginPage.myAccount();
    }

    @Then("^User login: (.*)$")
    public void userLogin(String user) {
        Assertions.assertEquals(loginPage.getLoggedUser(), user);
    }

    @When("^User click my store")
    public void userClickMyStore() {
        loginPage.myStore();
    }

    @And("^User select Hummingbird printed t-shirt")
    public void userSelectHummingbird() {
        storePage.selectHummingbird();
    }

    @Then("^Discount is equal to (.*) percent$")
    public void checkHummingbirdDiscount(Integer discount) {
        Assertions.assertEquals(storePage.getHummingbirdDiscount(), "SAVE " + discount + "%");
    }

    @When("^User select size (.*) and typed quantity (.*)")
    public void userSelectSize(String size, Integer quantity) {
        storePage.selectSize(size);
        storePage.typedQuantity(quantity);
        storePage.addProductToCart();
        storePage.checkoutOrder();
    }

    @And("^Proceed order")
    public void proceedOrder() {
        cartPage.checkout();
        cartPage.continueToShipping();
        cartPage.selectPickupInStore();
        cartPage.confirmDelivery();
        cartPage.selectPayment();
        cartPage.agreeTerms();
        cartPage.orderToPay();
    }
}
