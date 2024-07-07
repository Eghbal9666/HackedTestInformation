package tests.flavorfetchTestProje;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.FacebookPage;
import pages.FlavorfetchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class merchantTest {
    FlavorfetchPage flavorfetchPage=new FlavorfetchPage();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    //Admin olarak, Merchant Kayıtlarına erişebilmeliyim
    @Test
    public void MerchantKayıtlarınaErişebilmek(){
        Driver.getDriver().get(ConfigReader.getProperty("flavorLoginUrl"));
     //actions.moveToElement(flavorfetchPage.acceptCoockiee).sendKeys(Keys.ENTER).perform();
       // actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        flavorfetchPage.partner.click();
        flavorfetchPage.loginHere.click();
        flavorfetchPage.userNameMerchantLogin.sendKeys(ConfigReader.getProperty("flvUserName"));
        flavorfetchPage.passwordMerchantLogin.sendKeys(ConfigReader.getProperty("flvPassword"));
        flavorfetchPage.rememberMerchantLogin.click();
        flavorfetchPage.signInMerchantLogin.click();
        ReusableMethods.bekle(3);
Driver.quitDriver();
    }

}
