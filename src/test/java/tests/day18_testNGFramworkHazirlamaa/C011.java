package tests.day18_testNGFramworkHazirlamaa;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C011 {
    @Test
    public void test01(){
      //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
      // phone icin arama yapin
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchedWord_01")+ Keys.ENTER);
        ReusableMethods.bekle(200);
      // arama sonucu urun bulunabildigini test edin
        String expectedText="Products Found";
        String actualText=testotomasyonuPage.aramaSonucu.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        Driver.quitDriver();

      // sayfayi kapatin
    }
}
