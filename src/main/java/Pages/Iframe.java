package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Iframe {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div/form/div[2]/div[1]/div/div/input") WebElement inputCard;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div/form/div[2]/div[2]/div[1]/div/div/input") WebElement Expirydate;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div/form/div[2]/div[2]/div[2]/div/div/input") WebElement InputCVV;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div/form/div[2]/div[3]/div/button") WebElement pay;
    private By loadingIndicator = By.xpath ( "/html[1]/body[1]/iframe[1]" );

    public Iframe(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver , this );
    }

    public pinFrame setCardDetails(String card , String expiry , String cvv) throws InterruptedException {
        WebDriverWait wait;
        wait = new WebDriverWait ( driver , 25 );
        wait.until ( visibilityOf ( driver.findElement ( loadingIndicator ) ) );
        driver.switchTo ().frame ( 0 );
        Thread.sleep ( 5000 );
        inputCard.sendKeys ( card );
        Expirydate.sendKeys ( expiry );
        InputCVV.sendKeys ( cvv );
        pay.click ();
        return new pinFrame ( driver );
    }
}
