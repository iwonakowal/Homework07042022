package pl.workshop.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

    @FindBy( id = "address-link")
    private WebElement addressLink;

    @FindBy(id = "addresses-link")
    private WebElement addressesLink;

    @FindBy(xpath = "//a/span[contains(text(),'Create new address')]")
    private WebElement createAddressLink;

    @FindBy(name = "alias")
    private WebElement aliasElement;

    @FindBy(name = "city")
    private WebElement cityElement;

    @FindBy(name = "postcode")
    private WebElement zipElement;

    @FindBy(name = "id_country")
    private WebElement countryElement;

    @FindBy(name = "phone")
    private WebElement phoneElement;

    @FindBy(name = "address1")
    private WebElement addressElement;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveElement;

    @FindBy(xpath = "//aside[@id='notifications']/div/article/ul/li")
    private WebElement messageElement;

    public AddressPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void newAddress() {
        if(elementExists(addressLink)) {
            addressLink.click();
        } else {
            addressesLink.click();
            createAddressLink.click();
        }
    }

    private boolean elementExists(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public void userEnteredAddressData(String alias, String address, String city, String zip, String country, String phone) {
        aliasElement.clear();
        aliasElement.sendKeys(alias);

        addressElement.clear();
        addressElement.sendKeys(address);

        cityElement.clear();
        cityElement.sendKeys(city);

        zipElement.clear();
        zipElement.sendKeys(zip);

        phoneElement.clear();
        phoneElement.sendKeys(phone);

        Select dropDown = new Select(countryElement);
        dropDown.selectByVisibleText(country);
    }

    public void userClickSave() {
        saveElement.click();
    }

    public String getMessage() {
        return messageElement.getText();
    }
}
