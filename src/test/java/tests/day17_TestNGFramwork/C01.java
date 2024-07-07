package tests.day17_TestNGFramwork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C01 {
    @Test
    public void test01() throws InterruptedException {
        // testotomasyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        Thread.sleep(1000);
// phone icin arama yapin
       WebElement searchBox=Driver.getDriver().findElement(By.id("global-search"));
        searchBox.sendKeys("phone"+ Keys.ENTER);
// arama sonucunda urun bulunabildigini test edin
List<WebElement> searchNatice=Driver.getDriver().findElements(By.xpath("//*[@class='lazy']"));
int unExpectedUrun=0;
int actualUrun=searchNatice.size();
        Assert.assertNotEquals(actualUrun,unExpectedUrun);
// sayfayi kapatin
        Driver.quitDriver();
    }
}