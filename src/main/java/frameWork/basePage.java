package frameWork;

import Pages.homePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class basePage {

    static WebDriver driver;
    static Method method;
    static ITestResult result;

    public static homePage executeDriver(String url) {
        driver.get (url);
        return new homePage ( driver );
    }

    @BeforeClass
    public static void setDriver() throws MalformedURLException {
        String sauceUserName = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

//        System.setProperty ( "webdriver.chrome.driver" , "C:/Users/User/eclipse-workspace/driver/chromedriver.exe" );
//        ChromeOptions options = new ChromeOptions ();
//        options.addArguments ( "headless" );
//
//        driver = new ChromeDriver (options);
//        driver.manage ().deleteAllCookies ();
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("browserName", "Safari");
        capabilities.setCapability("platform", "macOS 10.13");
        capabilities.setCapability("version", "11.1");
//        capabilities.setCapability("name", method.getName());

        driver = new RemoteWebDriver (new URL ("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);
//        driver.navigate().to("https://paywithbank3d.com/test/");

    }

    @AfterClass
    public static void closeDriver( ) {
        ((JavascriptExecutor)driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        driver.quit();
    }

}
