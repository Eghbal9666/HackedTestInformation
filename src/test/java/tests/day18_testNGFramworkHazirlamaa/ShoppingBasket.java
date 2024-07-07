package tests.day18_testNGFramworkHazirlamaa;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ShoppingBasket {
    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        //2- phone icin arama yapin
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchedWord_01")+ Keys.ENTER);
        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.aramaSonucUrunList.get(0).click();
        //4- urun ismini kaydedin ve sepete ekleyin
        String actualUrun=testotomasyonuPage.aramaSonucUrunList.get(0).getText();
        testotomasyonuPage.aramaSonucUrunList.get(0).click();
        //5- your cart linkine tiklayin
        testotomasyonuPage.yourCart.click();
        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String expectedUrun=testotomasyonuPage.sepettekiUrunIsimElementi.getText();
        Assert.assertEquals(actualUrun,expectedUrun);
        //7- sayfayi kapatin
        Driver.quitDriver();
    }

}
