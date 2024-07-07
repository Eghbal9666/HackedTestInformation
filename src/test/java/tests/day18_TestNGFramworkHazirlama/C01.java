package tests.day18_TestNGFramworkHazirlama;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C01 {
    @Test
    public void test01() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webApp"));
        //2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = ConfigReader.getProperty("webApp");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "No entry Pge");
        //3. Sign in butonuna basin
        WebAppPage webAppPage = new WebAppPage();
        webAppPage.ilkSayfaSigninLinki.click();
        ReusableMethods.bekle(2);
        //4. Login kutusuna “username” yazin
        Actions actions = new Actions(Driver.getDriver());
        webAppPage.loginUsernameKutusu.sendKeys(ConfigReader.getProperty("webAppUsername"));

        //5. Password kutusuna “password” yazin
        webAppPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("webAppPassword"));
        //6. Sign in tusuna basin
        webAppPage.logInSignInButton.click();

        //7. Back tusuna basin
        Driver.getDriver().navigate().back();
        //8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(webAppPage.onlineBankingLinki.isDisplayed(), "hai mei hui le");
        //9. Online banking menusunu tiklayin
        webAppPage.onlineBankingLinki.click();
        //10. Pay Bills sayfasina gidin
        webAppPage.payBillsLinki.click();
        //11. “Purchase Foreign Currency” tusuna basin
        webAppPage.purchaseCurrencyTab.click();
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin

        softAssert.assertTrue(webAppPage.pcCurrencyDropdownElementi.isEnabled(), "mei kanJing");
        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(webAppPage.purchaseCurrencyTab);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSelectedeuro=ConfigReader.getProperty("webAppSelectedCurrency");
        String actualSelectedEuro=select.getFirstSelectedOption().getText();
        softAssert.assertTrue(actualSelectedEuro.contains(expectedSelectedeuro));
        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        String expectedNumber = ConfigReader.getProperty("webAppDropDownSize");
        Integer actualNumber = select.getOptions().size();
        softAssert.assertEquals(actualNumber + "", expectedNumber, "bi shu ping tai");
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<WebElement> optionsList = select.getOptions();
        List<String> dropDownCurrencyList = new ArrayList<>();
        for (WebElement each : optionsList) {
            dropDownCurrencyList.add(each.getText());
        }
        softAssert.assertTrue(dropDownCurrencyList.contains(ConfigReader.getProperty("webAppDropDownCanadaPhrase")), "diu le");
        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
