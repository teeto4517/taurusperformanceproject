package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    WebDriver driver;

    @FindBy(id = "amount") WebElement Amount;
    @FindBy(name = "merchant") WebElement Merchant;
    @FindBy(id = "customerEmail") WebElement Email;
    @FindBy(id = "customerPhone") WebElement Phone;
    @FindBy(id = "container") WebElement Checkbox;
    @FindBy(xpath = "//button[contains(text(),'Pay')]") WebElement Pay;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver , this );
    }
    public Iframe inputPaymentDetails(String amount , String merchant , String email , String phone) {
        Amount.clear ();
        Amount.sendKeys ( amount );
        Merchant.clear ();
        Merchant.sendKeys ( merchant );
        Email.clear ();
        Email.sendKeys ( email );
        Phone.clear ();
        Phone.sendKeys ( phone );
        Checkbox.click ();
        Pay.click ();
        return new Iframe ( driver );
    }
}
