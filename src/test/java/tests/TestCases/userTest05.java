package tests.TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class userTest05 {
    @Test
    public void test01() {
//1. Launch browser
Driver.getDriver().get("about:blank");
//2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        TestotomasyonuExercise testotomasyonuExercise=new TestotomasyonuExercise();
//3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();
        String expectedUrl=ConfigReader.getProperty("aeUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
//4. Click 'Products' button
        testotomasyonuExercise.productElement.click();
//5. Hover over first product and click 'Add to cart'
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        testotomasyonuExercise.firstProduct.click();
//6. Click 'Continue Shopping' button
        testotomasyonuExercise.contShopping.click();
//7. Hover over second product and click 'Add to cart'
        actions.moveToElement(testotomasyonuExercise.secoundProduct).click().perform();
//8. Click 'View Cart' button
        testotomasyonuExercise.viewCartElement.click();
//9. Verify both products are added to Cart
int expectedProduct=2;
int actualProduct=testotomasyonuExercise.satirSayisi.size();
softAssert.assertTrue(actualProduct==expectedProduct);
//10. Verify their prices, quantity and total price
        ReusableMethods.bekle(2);
        softAssert.assertAll();
        Driver.quitDriver();
    }

}