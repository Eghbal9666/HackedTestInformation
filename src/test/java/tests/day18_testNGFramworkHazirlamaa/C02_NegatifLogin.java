package tests.day18_testNGFramworkHazirlamaa;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifLogin {

    @Test
    public void negatifLoginTest01() {
//1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuAccountPage testotomasyonuAccountPage=new TestotomasyonuAccountPage();
        ReusableMethods.bekle(2);
//2- account linkine basin

        testotomasyonuAccountPage.account.click();
        //3- Kullanici email'i olarak gecerli email girinl

        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toValidEmail")+ Keys.TAB+ConfigReader.getProperty("toValidPassword")+Keys.TAB+Keys.ENTER);
//4- Kullanici sifresi olarak gecerli password girin
        //5- Login butonuna basarak login olun
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuAccountPage.logOut.isDisplayed());
        Driver.quitDriver();
    }
}
