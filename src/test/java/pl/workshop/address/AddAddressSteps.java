package pl.workshop.address;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.workshop.page.AddressPage;
import pl.workshop.page.LoginPage;

import java.time.Duration;

public class AddAddressSteps {

    private LoginPage loginPage;
    private AddressPage addressPage;
    private WebDriver webDriver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");
        this.webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
         loginPage = new LoginPage(webDriver);
         addressPage = new AddressPage(webDriver);
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

    @When("^User click new address")
    public void userClickNewAddress() {
        addressPage.newAddress();
    }

    @And("^User entered alias (.*) address (.*) city (.*) zip (.*) country (.*) phone (.*)$")
    public void userEnteredAddressData(String alias, String address, String city, String zip, String country, String phone) {
        addressPage.userEnteredAddressData(alias, address, city, zip, country, phone);
    }

    @And("^User click save$")
    public void userClickSave() {
        addressPage.userClickSave();
    }

    @Then("^Address successfully added$")
    public void addressAdded() {
        Assertions.assertEquals("Address successfully added!", addressPage.getMessage());
    }
}
