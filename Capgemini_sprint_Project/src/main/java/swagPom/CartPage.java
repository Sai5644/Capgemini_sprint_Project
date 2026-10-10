package swagPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Add product
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    // Cart icon
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    // Product in cart
    @FindBy(className = "cart_item")
    private WebElement cartItem;

    // Remove product
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;

    // Continue shopping
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    // Checkout
    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public void addProduct() {
        addToCartButton.click();
    }

    public void getCart() {
        cartIcon.click();
    }

    public WebElement getCartItem() {
        return cartItem;
    }

    public void removeProduct() {
        removeButton.click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }

    public void getCheckout() {
        checkoutButton.click();
    }
}