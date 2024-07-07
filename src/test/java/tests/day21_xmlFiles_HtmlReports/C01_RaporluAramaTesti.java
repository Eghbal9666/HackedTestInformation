package tests.day21_xmlFiles_HtmlReports;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;


public class C01_RaporluAramaTesti extends TestBaseReport {
    @Test
    public void aramaTesti() {

extentTest=extentReports.createTest("aramaTesti","belirlenen kelimenin bulundugunu test eder");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu anasayfaya gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchedWord_01")+Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");

Assert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>80);
extentTest.pass("arama sonucunda urun bula bildigini test eder");

    }
}


