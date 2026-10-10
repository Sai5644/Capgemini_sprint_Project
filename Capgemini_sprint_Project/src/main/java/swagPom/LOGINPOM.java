package swagPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LOGINPOM {

    WebDriver driver;
    public LOGINPOM(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public void getun(String value) {
        username.sendKeys(value);
    }

    public void getpwd(String value) {
        password.sendKeys(value);
    }

    public void getlogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}