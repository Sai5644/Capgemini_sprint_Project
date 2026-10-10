package GenericUtility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

    public static void takeScreenshot(WebDriver driver) throws Exception {

        TakesScreenshot tks = (TakesScreenshot) driver;

        File src = tks.getScreenshotAs(OutputType.FILE);

        File dest = new File("./ss/saucedemo4.png");

        FileHandler.copy(src, dest);
    }
}