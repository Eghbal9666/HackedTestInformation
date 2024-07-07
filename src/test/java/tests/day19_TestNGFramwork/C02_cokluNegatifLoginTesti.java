package tests.day19_TestNGFramwork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_cokluNegatifLoginTesti {
    @DataProvider
    public static Object[][] KullaniciBilgileriGetir() {
        String[][]  bilgilerArray={{ "banu@gmail.com","898989"}
                                   ,{"sedat@yahoo.com","989887"}
                                   ,{"orkong@tmail.com","122334"}
                                   ,{"fatih@hotmail.com","454545"}
                                   ,{"arzu@senmail.com","676767"}
                                   ,{"mehmet@mynet.com","878987"}};
        //4. banu@gmail.com    898989
        //sedat@yahoo.com   989887
        //orkong@tmail.com  122334
        //fatih@hotmail.com 454545
        //arzu@senmail.com  676767
        //mehmet@mynet.com  878987
        return bilgilerArray;
    }

    @Test(dataProvider = "KullaniciBilgileriGetir")
    public void cokluNegatifLoginTesti(String email,String password){
        //1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2. Account linkine tiklayin
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        //3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        testotomasyonuPage.loginEmailKutusu.sendKeys(email);
        testotomasyonuPage.loginPasswordKutusu.sendKeys(password);
        testotomasyonuPage.loginSiginButonu.click();
        Assert.assertTrue(testotomasyonuPage.loginSiginButonu.isEnabled());
        //4. banu@gmail.com    898989
        //sedat@yahoo.com   989887
        //orkong@tmail.com  122334
        //fatih@hotmail.com 454545
        //arzu@senmail.com  676767
        //mehmet@mynet.com  878987
    }
}
