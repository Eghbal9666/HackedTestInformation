package tests.day19_TestNGFramwork;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_DataProvider extends TestBaseReport {
    @DataProvider
    public static Object[][] aranacakKelimelerYolla() {
        String[][]  aranacakKelimlerArray={{"phone"},{"dress"},{"java,iphone"},{"samsung"},{"nutella"},{"cokokrem"}};
        return aranacakKelimlerArray;
    }

    //تست زیر را جداگانه برای جستجوی کلمات phone,dress,java,iphone,samsung,nutella,cokokrem بکار اندازید
    @Test(dataProvider = "aranacakKelimelerYolla")
    public void cokluAramaTesti(String aranacakKelime){
        extentTest =extentReports.createTest("cokluAramaTesti","Verilen tum kelimelere AYri Ayri arama");
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        //verilen kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);
        extentTest.info("Kullanici verilen kelime icin arama yapar");
        //arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.aramaSonucUrunList.size()>0);
        extentTest.pass("Kullanici arama sonucunda urun bulunabildigini test eder");
        //saysayi kapatin

    }
}
