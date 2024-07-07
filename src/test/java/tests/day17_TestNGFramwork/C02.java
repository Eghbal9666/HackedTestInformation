package tests.day17_TestNGFramwork;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02 {
    @Test
    public void test01() throws InterruptedException {
        // testotomasyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
// phone icin arama yapin

        testotomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);
// arama sonucunda urun bulunabildigini test edin

      /*  List<WebElement> searchNatice=Driver.getDriver().findElements(By.xpath("//*[@class='lazy']"));
        int unExpectedUrun=0;
        int actualUrun=searchNatice.size();
        Assert.assertNotEquals(actualUrun,unExpectedUrun);*/

        String unExpectedUrun="0 Product Found";
        String actualUrun=testotomasyonuPage.aramaSonucu.getText();
        Assert.assertNotEquals(actualUrun,unExpectedUrun);

// sayfayi kapatin
        Driver.quitDriver();
    }
}
