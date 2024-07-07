package tests.day17_TestNGFramwork;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.TestotomasyonuFormPage;
import utilities.Driver;

import java.util.List;

public class C044_otomasyonForm {
    @Test
    public void test01() throws InterruptedException {
//1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        Thread.sleep(2000);
        TestotomasyonuFormPage testotomasyonuFormPage=new TestotomasyonuFormPage();


        Select selectDay=new Select(testotomasyonuFormPage.dayDropDown);
        selectDay.selectByIndex(5);
        Select selectMonth=new Select(testotomasyonuFormPage.monthDropDown);
        selectMonth.selectByValue("nisan");
        Select selectYear=new Select(testotomasyonuFormPage.yearDropDown);
        selectYear.selectByVisibleText("1990");



//2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
//3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
//4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
//5- Secilen değerleri konsolda yazdirin
        System.out.println(selectDay.getFirstSelectedOption());
        System.out.println(selectMonth.getFirstSelectedOption());
        System.out.println(selectYear.getFirstSelectedOption());
//6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> monthList=selectMonth.getOptions();
        for(WebElement each:monthList){
            System.out.println(each.getText()+" - ");
        }
//7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Driver.quitDriver();
    }
}