package tests.day20_softAssertion_xmlDosyalari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C02_PositiveLoginTesti extends TestBaseCross {
    @Test
    public void positiveLoginTesti(){
        //1- https://www.testotomasyonu .com/anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        //2-account linkine basin
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        //3-kullanici emaili olarak gecerli email girin
        WebElement emailKutusu=driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");
        //4-kullanici sifresi olarak gecerli password girin
        WebElement sifreKutusu=driver.findElement(By.id("password"));
        sifreKutusu.sendKeys("12345");
        //5-login buttonuna basarak login olun
        WebElement loginButonu=driver.findElement(By.id("submitlogin"));
        loginButonu.click();
        //6-basarili olarak giris yapabildigini test edin
        WebElement logoutButtonu=driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logoutButtonu.isDisplayed());

        //7-sayfayi kapatin
    }

    }

