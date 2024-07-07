package tests.day21_xmlFiles_HtmlReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import static utilities.Driver.driver;

public class C02_RaporluPositiveLoginTesti extends TestBaseReport {
    @Test
    public void positiveLoginTesti(){
        extentTest=extentReports.createTest("Raporlama Arama testi","Kullanici gecerli bilgilerle login olabilir ");
        //1- https://www.testotomasyonu .com/anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyon Anasayfaya gider");

        //2-account linkine basin
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        extentTest.info("Kullanici account linkine basar");

        //3-kullanici emaili olarak gecerli email girin
        WebElement emailKutusu=driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");
        extentTest.info("kullanici emaili olarak gecerli email gider");


        //4-kullanici sifresi olarak gecerli password girin
        WebElement sifreKutusu=driver.findElement(By.id("password"));
        sifreKutusu.sendKeys("12345");
        extentTest.info("kullanici sifresi olarak gecerli password gider");

        //5-login buttonuna basarak login olun
        WebElement loginButonu=driver.findElement(By.id("submitlogin"));
        loginButonu.click();
        extentTest.info("Kullanici login buttonuna basarak login olur ");

        //6-basarili olarak giris yapabildigini test edin
        WebElement logoutButtonu=driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logoutButtonu.isDisplayed());
        extentTest.pass("Kullanici basarili olarak giris yapabildigini test eder ");

        //7-sayfayi kapatin
    }
}
