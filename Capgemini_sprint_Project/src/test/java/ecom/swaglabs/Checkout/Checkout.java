package ecom.swaglabs.Checkout;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;
import BaseClassUtility.BaseClass1;
import GenericUtility.ExcelUtility;
import swagPom.CartPage;
import swagPom.CheckoutPage;

public class Checkout extends BaseClass1 {

    ExcelUtility eu = new ExcelUtility();
    // SMOKE TESTING
    @Test(groups = {"pos", "smoke"})
    public void checkoutWithValidDetails() throws Exception {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();
        cart.getCheckout();

        String firstName = eu.getData("Sheet1", 1, 2);
        String lastName = eu.getData("Sheet1", 1, 3);
        String postalCode = eu.getData("Sheet1", 1, 4);

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.getFirstName(firstName);
        checkout.getLastName(lastName);
        checkout.getPostalCode(postalCode);
        checkout.getContinue();

        boolean result = driver.getCurrentUrl().contains("checkout-step-two.html");

        Assert.assertTrue(result,"Checkout with valid details failed");

        Reporter.log("CHECKOUT WITH VALID DETAILS --> PASSED",true);
    }


    // FUNCTIONAL TESTING
    @Test(groups = {"pos", "functionality"})
    public void verifyCheckoutDetails() throws Exception {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();
        cart.getCheckout();

        String firstName = eu.getData("Sheet1", 1, 2);
        String lastName = eu.getData("Sheet1", 1, 3);
        String postalCode = eu.getData("Sheet1", 1, 4);

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.getFirstName(firstName);
        checkout.getLastName(lastName);
        checkout.getPostalCode(postalCode);
        checkout.getContinue();

        boolean result = driver.getCurrentUrl().contains("checkout-step-two.html");

        Assert.assertTrue(result,"Checkout details were not accept");

        Reporter.log("VERIFY CHECKOUT DETAILS --> PASSED",true);
    }


    // INTEGRATION TESTING
    @Test(groups = {"pos", "integration"})
    public void cartToCheckoutIntegration() {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();

        boolean cartResult = cart.getCartItem().isDisplayed();

        Assert.assertTrue(cartResult,"Product is not available in cart");

        cart.getCheckout();

        boolean checkoutResult =
                driver.getCurrentUrl().contains("checkout-step-one.html");

        Assert.assertTrue(checkoutResult,"Cart to Checkout integration failed");

        Reporter.log("CART TO CHECKOUT INTEGRATION --> PASSED",true);
    }


    // SYSTEM TESTING
    @Test(groups = {"pos", "systemTesting"})
    public void checkoutSystemFlow() throws Exception {

        CartPage cart = new CartPage(driver);

        cart.addProduct();
        cart.getCart();
        cart.getCheckout();

        String firstName = eu.getData("Sheet1", 1, 2);
        String lastName = eu.getData("Sheet1", 1, 3);
        String postalCode = eu.getData("Sheet1", 1, 4);

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.getFirstName(firstName);
        checkout.getLastName(lastName);
        checkout.getPostalCode(postalCode);
        checkout.getContinue();

        boolean result = driver.getCurrentUrl().contains("checkout-step-two.html");

        Assert.assertTrue(result,"Complete checkout system flow failed");

        Reporter.log("CHECKOUT SYSTEM FLOW --> PASSED",true);
    }
}