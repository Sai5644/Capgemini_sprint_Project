package swagPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuPage {

    WebDriver driver;

    public HamburgerMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems;

    @FindBy(id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    public void getMenu() {
        menuButton.click();
    }

    public void getAllItems() {
        allItems.click();
    }

    public void getAbout() {
        about.click();
    }

    public void getResetAppState() {
        resetAppState.click();
    }

    public void getLogout() {
        logout.click();
    }
}