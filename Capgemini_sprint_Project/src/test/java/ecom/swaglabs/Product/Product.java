package ecom.swaglabs.Product;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import BaseClassUtility.BaseClass1;
import swagPom.ProductPOM;

public class Product extends BaseClass1 {

    @Test(groups = {"pos", "smoke"})
    public void nameAToZ()throws Exception {

        ProductPOM product = new ProductPOM(driver);

        product.sortBy("Name (A to Z)");
        Thread.sleep(2000);

        boolean result = driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result, "Name A-Z sorting failed");

        Reporter.log("Name A-Z --> PRODUCT SORTING IS PASSED",true);
    }

    @Test(groups = {"pos", "functionality"})
    public void nameZToA()throws Exception  {
        
        ProductPOM product = new ProductPOM(driver);

        product.sortBy("Name (Z to A)");
        Thread.sleep(2000);

        boolean result = driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result, "Name Z-A sorting failed");

        Reporter.log("Name Z-A --> PRODUCT SORTING IS PASSED",true);
    }

    @Test(groups = {"pos", "integration"})
    public void priceLowToHigh()throws Exception  {

        ProductPOM product = new ProductPOM(driver);

        product.sortBy("Price (low to high)");
        Thread.sleep(2000);

        boolean result = driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result, "Price low to high sorting failed");

        Reporter.log("Price Low to High --> PRODUCT SORTING IS PASSED",true);
    }

    @Test(groups = {"pos", "systemTesting"})
    public void priceHighToLow()throws Exception  {
    	
        ProductPOM product = new ProductPOM(driver);

        product.sortBy("Price (high to low)");
        Thread.sleep(2000);

        boolean result = driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result, "Price high to low sorting failed");

        Reporter.log("Price High to Low --> PRODUCT SORTING IS PASSED",true);
    }
}