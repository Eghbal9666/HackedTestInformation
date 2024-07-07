package tests.day22_dataProvider;

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
    public static Object[][] aranacakKelimeleriYolla() {

        String[][] aranacakKelimelerArrayi={{"phone"},{"dress"},{"java"},{"iphone"},{"samsung"},{"nutella"},{"cokoKrem"}};

        return aranacakKelimelerArrayi;
    }

    //تست زیر را برای این کلمات انجام دهید   phone ,dress , java , iphone , samsung , nutella , cokokrem
    @Test(dataProvider = "aranacakKelimeleriYolla")
    public void cokluAramaTesti(String aranacakKelime){
    extentTest=extentReports.createTest("Aranacak Klimeler","Verilen tum kelimeler icin ayri ayri arama yapin");

        // testotomasyonu anasayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        // verilen kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);
        extentTest.info("Kullanici verilen kelime icin arama yapar");

        //arama sonucunda urun bulundugunu test edin
        Assert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>1);
        extentTest.pass("Kullanici arama sonucunda urun bulundugunu test eder");

        // sayfayi kapatin


    }
}
