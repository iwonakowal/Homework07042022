package pl.workshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(className = "btn-primary")
    private WebElement checkoutButton;

    @FindBy(className = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//span[contains(text(),'Pick up in-store')]")
    private WebElement pickupInStore;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDelivery;

    @FindBy(xpath = "//span[contains(text(),'Pay by Check')]")
    private WebElement payByCheck;

    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement termsElement;

    @FindBy(xpath = "//button[contains(text(),'Order with an obligation to pay')]")
    private WebElement orderToPayElement;

    public CartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void checkout() {
        checkoutButton.click();
    }

    public void continueToShipping() {
        continueButton.click();
    }

    public void selectPickupInStore() {
        pickupInStore.click();
    }

    public void confirmDelivery() {
        confirmDelivery.click();
    }

    public void selectPayment() {
        payByCheck.click();
    }

    public void agreeTerms() {
        termsElement.click();
    }

    public void orderToPay() {
        orderToPayElement.click();
    }
}
