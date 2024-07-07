package tests.day21_xmlFiles_HtmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class RaporluNegativLoginTesti extends TestBaseReport {
    @Test
    public void validEmailTest01() {
        extentTest=extentReports.createTest("Gecersiz password","Kullanici gecersiz email'le system'e giris yapamaz");
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyon anasayfaya gider");

        TestotomasyonuAccountPage testotomasyonuAccountPage = new TestotomasyonuAccountPage();
        testotomasyonuAccountPage.account.click();
        extentTest.info("Kullanici account buttonuna basar");

        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toValidEmail")
                + Keys.TAB + ConfigReader.getProperty("toInvalidPasswrd")
                + Keys.TAB + Keys.ENTER);
        extentTest.info("Kullanici gecerli email ve gecersiz password girer");

        ReusableMethods.bekle(2);
        Assert.assertTrue(testotomasyonuAccountPage.wrongEmailPassword.isDisplayed());
        extentTest.pass("Kullanici gecersiz girisini test eder");

    }
    @Test
    public void validPasswordTest02() {
        extentTest=extentReports.createTest("gecersiz email","Kullanici gecersiz email le system'e giris yapamaz");
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
         extentTest.info("Kullanici testotomasyon anasayfaya gider");

        TestotomasyonuAccountPage testotomasyonuAccountPage = new TestotomasyonuAccountPage();
        testotomasyonuAccountPage.account.click();
        extentTest.info("Kullanici account linkine basar");

        //      - gecersiz email, gecerli password
        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail")
                + Keys.TAB + ConfigReader.getProperty("toValidPasswrd") + Keys.TAB + Keys.ENTER);
        extentTest.info("Kullanici gecersiz email ve gecerli password girer");

        Assert.assertTrue(testotomasyonuAccountPage.wrongEmailPassword.isDisplayed());
        extentTest.pass("Kullanici giris yapmadigini test eder");
    }
    @Test
    public void invalidTwiceTest03(){
        extentTest=extentReports.createTest("Gecersiz email ve password","Kullanici gecersiz email ve password'la giris yapamaz");
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya girer");

        TestotomasyonuAccountPage testotomasyonuAccountPage = new TestotomasyonuAccountPage();
        testotomasyonuAccountPage.account.click();
        extentTest.info("Kullanici account linkine basar");

        //    - gecersiz email, gecersiz password.
        testotomasyonuAccountPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail")
                + Keys.TAB+ConfigReader.getProperty("toInvalidPasswrd")+Keys.TAB+Keys.ENTER);
        extentTest.info("Kullanici gecersiz email ve gecersiz password girer");

        Assert.assertTrue(testotomasyonuAccountPage.wrongEmailPassword.isDisplayed());
        extentTest.pass("Kullanici Basarili olarak giris yapilamadigini test eder");
        //4- Login butonuna basarak login olmayi deneyin
        //5- Basarili olarak giris yapilamadigini test edin

    }
}
