package pl.workshop.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyStorePage {

    @FindBy(xpath = "//article/div/div/h3/a[contains(text(),'Hummingbird printed t-shirt')]")
    private WebElement hummingbird;

    @FindBy(className = "discount-percentage")
    private WebElement discountPercentage;

    @FindBy(xpath = "//div[@class='product-variants']/div/select")
    private WebElement sizeElement;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityElement;

    @FindBy(className = "bootstrap-touchspin-up")
    private WebElement quantityUpElement;

    @FindBy(className = "add-to-cart")
    private WebElement addToCartElement;

    @FindBy(className = "btn-primary")
    private WebElement checkoutButton;

    public MyStorePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void selectHummingbird() {
        hummingbird.click();
    }

    public String getHummingbirdDiscount() {
        return discountPercentage.getText();
    }

    public void selectSize(String size) {
        Select dropDown = new Select(sizeElement);
        dropDown.selectByVisibleText(size);
    }

    public void typedQuantity(Integer quantity) {
        while (Integer.parseInt(quantityElement.getAttribute("value")) < quantity) {
            quantityUpElement.click();
        }
    }

    public void addProductToCart() {
        addToCartElement.click();
    }

    public void checkoutOrder() {
        checkoutButton.submit();
    }
}
