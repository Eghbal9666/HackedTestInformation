package tests.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class TestCase14 {
    @Test
    public void test01(){
        //Test Case 14: Place Order: Register while Checkout
        //1. Launch browser
        Driver.getDriver().get("about:blank");
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().navigate().to(ConfigReader.getProperty("aeUrl"));
        TestotomasyonuExercise testotomasyonuExercise=new TestotomasyonuExercise();
        //3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();
        String expectedUrl=Driver.getDriver().getTitle();
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        //4. Add products to cart
        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",testotomasyonuExercise.addToCart);


        for(int i=1;i<=4;i++){
           actions.moveToElement(testotomasyonuExercise.addToCart.get(i)).click().perform();
           actions.moveToElement(testotomasyonuExercise.contShopping).click().perform();



}

        //5. Click 'Cart' button
        testotomasyonuExercise.cartIcone.click();
        //6. Verify that cart page is displayed
        softAssert.assertTrue(testotomasyonuExercise.quantityValue.isDisplayed());
        //7. Click Proceed To Checkout
        testotomasyonuExercise.proceedToCheckout.click();
        //8. Click 'Register / Login' button
        testotomasyonuExercise.paymentName.sendKeys("pouneh");
        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //11. Verify ' Logged in as username' at top
        //12.Click 'Cart' button
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        softAssert.assertAll();
        Driver.getDriver();
    }
}
