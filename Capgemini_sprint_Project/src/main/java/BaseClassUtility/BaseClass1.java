package BaseClassUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import swagPom.LOGINPOM;

public class BaseClass1 {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
   public void launchBrowser(@Optional("chrome")String browser) throws Exception {

        FileInputStream fis = new FileInputStream("src/main/resources/DDT/commonOfProject.properties");

        Properties p = new Properties();
        p.load(fis);

        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            fis.close();
            throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);
        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();


        fis.close();

        System.out.println("Browser = " + browser);
        System.out.println("Browser launched");
        System.out.println("Application opened");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        System.out.println("Closing browser");

        if (driver != null) {
            driver.quit();
        }
    }
}
