package pl.workshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final String userName = "lfuggrddeamoijrhxw@nthrl.com";
    private final String password = "Tajne";

    @FindBy(name = "email")
    private WebElement emailElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(id = "submit-login")
    private WebElement submit;

    @FindBy(xpath = "//a[@class='account']//span[@class='hidden-sm-down']")
    private WebElement account;

    @FindBy(id="_desktop_logo")
    private WebElement myStore;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void enterUserData() {
        emailElement.sendKeys(userName);
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        submit.click();
    }

    public String getLoggedUser() {
        return account.getText();
    }

    public void myAccount() {
        account.click();
    }

    public void myStore() {
        myStore.click();
    }
}
