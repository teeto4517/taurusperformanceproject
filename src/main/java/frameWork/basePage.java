package frameWork;

import Pages.homePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class basePage {

    static WebDriver driver;

    public static homePage executeDriver(String url) {
        driver.get (url);
        return new homePage ( driver );
    }

    @BeforeClass
    public static void setDriver() {
        System.setProperty ( "webdriver.chrome.driver" , "C:/Users/User/eclipse-workspace/driver/chromedriver.exe" );
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( "headless" );

        driver = new ChromeDriver (options);
        driver.manage ().deleteAllCookies ();
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit ();

    }

}
