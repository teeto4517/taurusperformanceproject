package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pinFrame {
    WebDriver driver;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div/form/div[3]/div/input") WebElement Inputpin;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div/form/div[4]/button") WebElement Pay;

    public pinFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver , this );
    }
    public void setPin(String pin) throws InterruptedException {
        Thread.sleep ( 5000 );
        Inputpin.sendKeys ( pin );
        Pay.click ();
    }
}
