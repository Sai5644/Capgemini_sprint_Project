package swagPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement orderConfirmation;


    public void getFirstName(String value) {
        firstName.sendKeys(value);
    }

    public void getLastName(String value) {
        lastName.sendKeys(value);
    }

    public void getPostalCode(String value) {
        postalCode.sendKeys(value);
    }

    public void getContinue() {
        continueButton.click();
    }

    public void getFinish() {
        finishButton.click();
    }

    public String getOrderConfirmation() {
        return orderConfirmation.getText();
    }
}