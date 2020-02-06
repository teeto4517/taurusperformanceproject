package Runner;

import Pages.Iframe;
import Pages.homePage;
import Pages.pinFrame;
import frameWork.basePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class netpayTestPayment extends basePage {

    WebDriver driver;
    basePage basepage;
    homePage homepage;
    Iframe frame;
    pinFrame pin;
    public netpayTestPayment () {
        //noinspection ConstantConditions
        basepage = PageFactory.initElements ( driver , basePage.class );
    }

    @Test
    public void inputCardTest() throws InterruptedException {
        homepage = basePage.executeDriver ( "https://paywithbank3d.com/test/" );
        frame = homepage.inputPaymentDetails ( "100" , "The Main Men" , "test@gmail.com" , "0801234567889" );
        pin = frame.setCardDetails ( "6280511000000095" , "1226" , "123" );
        pin.setPin ( "0000" );
    }


}
