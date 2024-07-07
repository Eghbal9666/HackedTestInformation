package tests.day17_TestNGFramwork;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C033_FaceBookForm {
    @Test
    public void test01() throws InterruptedException {

//1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        FacebookPage facebookPage=new FacebookPage();
        Thread.sleep(1000);
//2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
       // facebookPage.acceptCookies.click();


//3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.emailBox.sendKeys(faker.internet().emailAddress()+ Keys.TAB);
        facebookPage.passwordBox.sendKeys(faker.internet().password()+Keys.TAB);
        Thread.sleep(2000);
        facebookPage.logInBox.sendKeys(Keys.ENTER);

//4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.errorEntryAllarm.isDisplayed());
        Driver.quitDriver();
    }
}