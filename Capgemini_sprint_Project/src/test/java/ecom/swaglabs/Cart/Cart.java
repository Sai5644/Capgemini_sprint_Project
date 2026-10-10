package ecom.swaglabs.Cart;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClassUtility.BaseClass1;
import swagPom.CartPage;


public class Cart extends BaseClass1 {
	
    // SMOKE TESTING
    @Test(groups = {"pos", "smoke"})
    public void addProductToCart() {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();

        boolean result = cart.getCartItem().isDisplayed();

        Assert.assertTrue(result,"Product was not added to cart");

        Reporter.log("ADD PRODUCT TO CART --> PASSED",true);
    }


    // FUNCTIONAL TESTING
    @Test(groups = {"pos", "functionality"})
    public void verifyProductInCart() throws Exception{
        
        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();

        boolean result = cart.getCartItem().isDisplayed();
        Assert.assertTrue(result,"Product is not displayed in cart");

        Reporter.log("VERIFY PRODUCT IN CART --> PASSED",true);
    }


    // INTEGRATION TESTING
    @Test(groups = {"pos", "integration"})
    public void removeProductFromCart() {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();

        cart.removeProduct();

        boolean result = driver.findElements(By.className("cart_item")).isEmpty();

        Assert.assertTrue(result,"Product was not removed from cart");

        Reporter.log("REMOVE PRODUCT FROM CART --> PASSED",true);
    }


    // SYSTEM TESTING
    @Test(groups = {"pos", "systemTesting"})
    public void continueShoppingFromCart() {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();

        cart.continueShopping();

        boolean result = driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result,"Continue Shopping failed");

        Reporter.log("CONTINUE SHOPPING --> PASSED",true);
    }
}