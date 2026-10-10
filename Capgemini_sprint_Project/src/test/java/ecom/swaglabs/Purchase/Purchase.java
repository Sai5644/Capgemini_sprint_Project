package ecom.swaglabs.Purchase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass1;
import GenericUtility.ExcelUtility;
import swagPom.CartPage;
import swagPom.CheckoutPage;

public class Purchase extends BaseClass1 {

    ExcelUtility eu = new ExcelUtility();

    // SMOKE TESTING
    @Test(groups = {"pos", "smoke"})
    public void completePurchase() throws Exception {

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
        checkout.getFinish();

        boolean result = driver.getPageSource()
                .contains("Thank you for your order!");

        Assert.assertTrue(result, "Purchase was not completed");

        Reporter.log("COMPLETE PURCHASE --> PASSED", true);
    }


    // FUNCTIONAL TESTING
    @Test(groups = {"pos", "functionality"})
    public void verifyOrderConfirmation() throws Exception {

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
        checkout.getFinish();

        boolean result = driver.getPageSource()
                .contains("Thank you for your order!");

        Assert.assertTrue(result,
                "Order confirmation message was not displayed");

        Reporter.log("VERIFY ORDER CONFIRMATION --> PASSED", true);
    }


    // INTEGRATION TESTING
    @Test(groups = {"pos", "integration"})
    public void checkoutToPurchaseIntegration() throws Exception {

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

        boolean checkoutResult =
                driver.getCurrentUrl().contains("checkout-step-two.html");

        Assert.assertTrue(checkoutResult,
                "Checkout details were not accepted");

        checkout.getFinish();

        boolean purchaseResult = driver.getPageSource()
                .contains("Thank you for your order!");

        Assert.assertTrue(purchaseResult,
                "Checkout to Purchase integration failed");

        Reporter.log("CHECKOUT TO PURCHASE INTEGRATION --> PASSED", true);
    }


    // SYSTEM TESTING
    @Test(groups = {"pos", "systemTesting"})
    public void completePurchaseSystemFlow() throws Exception {

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
        checkout.getFinish();

        boolean result = driver.getPageSource()
                .contains("Thank you for your order!");

        Assert.assertTrue(result,
                "Complete purchase system flow failed");

        Reporter.log("COMPLETE PURCHASE SYSTEM FLOW --> PASSED", true);
    }
}
