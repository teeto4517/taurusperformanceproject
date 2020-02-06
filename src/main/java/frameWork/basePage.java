package frameWork;

import Pages.homePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class basePage {

    static WebDriver driver;

    public static homePage executeDriver(String url) {
        driver.get (url);
        return new homePage ( driver );
    }

    @Before
    public void setDriver() {
        System.setProperty ( "webdriver.chrome.driver" , "C:/Users/User/eclipse-workspace/driver/chromedriver.exe" );
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( "headless" );

        driver = new ChromeDriver ( options );
        driver.manage ().deleteAllCookies ();
    }

    @After
    public void closeDriver() {
        driver.quit ();

    }

}
