package tests.day17_TestNGFramwork;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_TestNGilkTest {

    WebDriver driver;

        // tek test method'u oldugu icin @BeforeMethod veya @BeforeClass kullanabiliriz
        @BeforeClass
        public void setup(){
            // WebDriverManager.chromedriver().setup();
            // sirket bize bir WebDriver verirse onu kullaniriz
            // yoksa Selenium'un kendi WebDriver'ini kullanabiliriz
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterClass
        public void teardown(){
            driver.quit();
        }

        @Test
        public void test01(){

            // testotomasyonu anasayfaya gidelim
            driver.get("https://www.testotomasyonu.com");

            // phone icin arama yapalim
            WebElement aramaKutusu = driver.findElement(By.id("global-search"));
            aramaKutusu.sendKeys("dress" + Keys.ENTER);
            ReusableMethods.bekle(3);
            // arama sonucunda urun bulunabildigini test edelim
            WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
            ReusableMethods.bekle(3);
            String unExpectedSonuc = "0 Products Found";
            String actualSonuc = aramaSonucYaziElementi.getText();

            Assert.assertNotEquals(actualSonuc,unExpectedSonuc);

        }

}
