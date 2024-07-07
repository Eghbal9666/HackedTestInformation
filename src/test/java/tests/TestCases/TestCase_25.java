package tests.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class TestCase_25 {
    @Test
    public void test01() {
        // Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
//1. Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("toUrl2"));
//2. Navigate to url 'http://automationexercise.com/'
        TestotomasyonuExercise testotomasyonuExercise=new TestotomasyonuExercise();
        ReusableMethods.bekle(2);
//3. Verify that home page is visible successfully
        WebElement actualElement=testotomasyonuExercise.homePageSimbol;

        Assert.assertTrue(actualElement.isDisplayed());
//4. Scroll down page to bottom
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",testotomasyonuExercise.subscriptionButton);
//5. Verify 'SUBSCRIPTION' is visible

        actualElement=testotomasyonuExercise.subscriptionButton;
        Assert.assertTrue(actualElement.isDisplayed());
//6. Scroll up page to top
         testotomasyonuExercise.scrollUpButton.click();

//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

        WebElement actualText=testotomasyonuExercise.FullFledged;
        Assert.assertTrue(actualElement.isDisplayed());
        Driver.quitDriver();
    }
}