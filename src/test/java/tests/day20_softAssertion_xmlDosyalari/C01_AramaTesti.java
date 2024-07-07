package tests.day20_softAssertion_xmlDosyalari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_AramaTesti extends TestBaseCross {
    @Test
    public void aramaTesti(){
//testotomsyon anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        //belirlenmis aranacak kelime icin arama yapin
        WebElement aramakutusu=driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys(ConfigReader.getProperty("toSearchedWord_01")+ Keys.ENTER);
        //arama sonucunda urun bulunabildigini test edin
        WebElement aramasonucuElementi=driver.findElement(By.className("product-count-text"));
        ReusableMethods.bekle(2);
        String  unExpectedSonuc="0 Products Found";
        String  actualSonuc=aramasonucuElementi.getText();
        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);
        //sayfayi kapatin
    }
}
