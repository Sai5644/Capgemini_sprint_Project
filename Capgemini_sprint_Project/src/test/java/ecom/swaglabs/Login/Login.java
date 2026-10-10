package ecom.swaglabs.Login;

import org.testng.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClassUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.ScreenShot;
import swagPom.LOGINPOM;

public class Login extends BaseClass {

    ExcelUtility eu = new ExcelUtility();


    @Test(groups = {"pos","smoke"})
    public void standardUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 1, 0);
        String password = eu.getData("Sheet1", 1, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        boolean result =driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result, "Standard user login failed");

        Reporter.log(username + " --> LOGIN IS PASSED",true);
        
    }


    @Test(groups = "neg")
    public void lockedOutUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 2, 0);
        String password = eu.getData("Sheet1", 2, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        boolean result =driver.getCurrentUrl().contains("inventory.html");

        Assert.assertFalse(result, "Locked out user was able to login");

        Reporter.log(username + " --> LOGIN IS PASSED",true);
        
        System.out.println("Error message = "+ login.getErrorMessage());
      //TakesScreenshot
        ScreenShot.takeScreenshot(driver);
        
    }


    @Test(groups = {"pos","functionality"})
    public void problemUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 3, 0);
        String password = eu.getData("Sheet1", 3, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        boolean result =driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result,"Problem user login failed");

        Reporter.log(username + " --> LOGIN IS PASSED",true);
        
    }


    @Test(groups = {"pos","integration"})
    public void performanceGlitchUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 4, 0);
        String password = eu.getData("Sheet1", 4, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        boolean result =driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result,"Performance glitch user login failed");

        Reporter.log(username + " --> LOGIN IS PASSED",true);
       
    }


    @Test(groups = {"pos","systemTesting"})
    public void errorUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 5, 0);
        String password = eu.getData("Sheet1", 5, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        boolean result =driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result,"Error user login failed");

        Reporter.log(username + " --> LOGIN IS PASSED",true);
       
    }


    @Test(groups = {"pos","systemTesting"})
    public void visualUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 6, 0);
        String password = eu.getData("Sheet1", 6, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        boolean result =driver.getCurrentUrl().contains("inventory.html");

        Assert.assertTrue(result,"Visual user login failed");

        Reporter.log(username + " --> LOGIN IS PASSED",true);
       
    }
}
