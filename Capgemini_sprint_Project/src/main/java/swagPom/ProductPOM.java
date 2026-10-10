package swagPom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPOM {

    WebDriver driver;

    public ProductPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Product sorting dropdown
    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    // Product names
    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    // Product prices
    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;


    // Select sorting option
    public void sortBy(String option) {

        Select s = new Select(sortDropdown);
        s.selectByVisibleText(option);
    }


    // Get product names
    public List<WebElement> getProductNames() {
        return productNames;
    }


    // Get product prices
    public List<WebElement> getProductPrices() {
        return productPrices;
    }
}