package tests.day18_testNGFramworkHazirlamaa;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_ValidInvalid {

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        //2- account linkine basin
        //3- 3 farkli test method’u olusturun.
        //- gecerli email, gecersiz password

    @Test
    public void validEmailTest01() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuAccountPage testotomasyonuAccountPage = new TestotomasyonuAccountPage();
        testotomasyonuAccountPage.account.click();
        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toValidEmail")
                                                + Keys.TAB + ConfigReader.getProperty("toInvalidPasswrd")
                                                + Keys.TAB + Keys.ENTER);
        ReusableMethods.bekle(2);
        Assert.assertTrue(testotomasyonuAccountPage.wrongEmailPassword.isDisplayed());
        Driver.quitDriver();
    }
    @Test
    public void validPasswordTest02() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuAccountPage testotomasyonuAccountPage = new TestotomasyonuAccountPage();
        testotomasyonuAccountPage.account.click();
        //      - gecersiz email, gecerli password
        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail")
                + Keys.TAB + ConfigReader.getProperty("toValidPasswrd") + Keys.TAB + Keys.ENTER);
        Assert.assertTrue(testotomasyonuAccountPage.wrongEmailPassword.isDisplayed());
        Driver.quitDriver();
    }
    @Test
    public void invalidTwiceTest03(){
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuAccountPage testotomasyonuAccountPage = new TestotomasyonuAccountPage();
        testotomasyonuAccountPage.account.click();
            //    - gecersiz email, gecersiz password.
        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail")
                + Keys.TAB+ConfigReader.getProperty("toInvalidPasswrd")+Keys.TAB+Keys.ENTER);
        Assert.assertTrue(testotomasyonuAccountPage.wrongEmailPassword.isDisplayed());
        //4- Login butonuna basarak login olmayi deneyin
        //5- Basarili olarak giris yapilamadigini test edin
        Driver.quitDriver();
    }
}
