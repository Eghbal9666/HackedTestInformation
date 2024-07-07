package tests.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase13 {
    @Test
    public void test01(){
        //1. Launch browser
        Driver.getDriver().get("about:blank");
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().navigate().to(ConfigReader.getProperty("aeUrl"));
        TestotomasyonuExercise testotomasyonuExercise=new TestotomasyonuExercise();
        //3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(testotomasyonuExercise.homePageSimbol.isDisplayed());
        //4. Click 'View Product' for any product on home page
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
         jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",testotomasyonuExercise.viewProductElement);
         testotomasyonuExercise.viewProductElement.click();
        //5. Verify product detail is opened
        softAssert.assertTrue(testotomasyonuExercise.quantity.isDisplayed());
        //6. Increase quantity to 4
        Actions actions=new Actions(Driver.getDriver());
    //   actions.moveToElement(testotomasyonuExercise.increaseQuantity).click(testotomasyonuExercise.increaseQuantity)
    //           .click(testotomasyonuExercise.increaseQuantity).click(testotomasyonuExercise.increaseQuantity).perform();
        actions.moveToElement(testotomasyonuExercise.quantityValue).sendKeys(Keys.ENTER).perform();
        testotomasyonuExercise.quantity.clear();
        actions.sendKeys(testotomasyonuExercise.quantityValue,"4").perform();
        ReusableMethods.bekle(5);
        //7. Click 'Add to cart' button
        testotomasyonuExercise.addToCartElement.click();
        //8. Click 'View Cart' button
        testotomasyonuExercise.viewCartElement.click();
        //9. Verify that product is displayed in cart page with exact quantity
        String expectedChek=ConfigReader.getProperty("autoChekQuantity");
        String actualChek=testotomasyonuExercise.checkQuantity.getText();
        softAssert.assertEquals(actualChek,expectedChek);
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
