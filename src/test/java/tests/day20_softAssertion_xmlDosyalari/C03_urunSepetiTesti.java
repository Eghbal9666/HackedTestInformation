package tests.day20_softAssertion_xmlDosyalari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class C03_urunSepetiTesti extends TestBaseCross {
    @Test
    public void urunSepetiTesti(){
        // testotomasyonu anasayfaya gidin
driver.get(ConfigReader.getProperty("toUrl"));
// belirlenen arama kelimesini aratin
WebElement aramaKutusu=driver.findElement(By.id("global-search"));
aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchedWord_01")+ Keys.ENTER);
// bulunan urunlerden ilkini tiklayin
driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();
// acilan urun sayfasinda urun ismini kaydedin
WebElement ilkUrunIsmiElement=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
String ilkUrunIsmi=ilkUrunIsmiElement.getText();
// urunu sepete ekleyin
driver.findElement(By.xpath("//*[@class='add-to-cart']")).click();
// sepete gidin
driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[3]")).click();
// sepetteki urun ismi ile, kaydettigimiz urun isminin ayni oldugunu test edin
        WebElement sepetekiIlkUrunElementi=driver.findElement(By.xpath("//*[@*='product-title text-center']"));
        String sepettekiUrunIsmi=sepetekiIlkUrunElementi.getText();
        Assert.assertEquals(ilkUrunIsmi,sepettekiUrunIsmi);

    }
}
