package tests.TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestCase24 {
    @Test
    public void test01(){
       // Test Case 24: Download Invoice after purchase order
        //1. Launch browser
        Driver.getDriver().get("about:blank");
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        TestotomasyonuExercise testotomasyonuExercise=new TestotomasyonuExercise();
        //3. Verify that home page is visible successfully
        String expectedUrl=ConfigReader.getProperty("aeUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        ReusableMethods.bekle(2);
        //4. Add products to cart
        testotomasyonuExercise.productElement.click();
       //JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();

        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> productsList=new ArrayList<>();
        for(int i=0;i<20;i++){
            productsList.add(testotomasyonuExercise.addToCartElements.get(i));
        }
        for(WebElement each:productsList){
            each.click();
          actions.moveToElement(testotomasyonuExercise.contShopping).click();
        }
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeSelected(testotomasyonuExercise.contShopping));
        //5. Click 'Cart' button
        testotomasyonuExercise.cartIcone.click();
        //6. Verify that cart page is displayed
        WebElement actualElement=testotomasyonuExercise.shoppingCart;
        Assert.assertTrue(actualElement.isDisplayed());
        //7. Click Proceed To Checkout
        testotomasyonuExercise.proceedToCheckout.click();
        //8. Click 'Register / Login' button
        testotomasyonuExercise.rejisterLogin.click();
        //9. Fill all details in Signup and create account
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String emailAddress=faker.internet().emailAddress();
        String password=faker.internet().password();
        String bankNumber="12345678901112134";
        actions.moveToElement(testotomasyonuExercise.nameNewUserBox).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB).sendKeys(emailAddress).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
        actions.moveToElement(testotomasyonuExercise.mrsRadioBox).click().sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.ENTER)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.country().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).click();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        actualElement=testotomasyonuExercise.accountCreated;
        Assert.assertTrue(actualElement.isDisplayed());
        testotomasyonuExercise.continueButtonAfterRejister.click();

        //11. Verify ' Logged in as username' at top
        String actualText=Driver.getDriver().switchTo().frame(testotomasyonuExercise.iframeNameGoogle).getTitle();
        Assert.assertTrue(actualText.contains(firstName));
        Driver.getDriver().switchTo().frame(testotomasyonuExercise.iframeNameGoogle).close();
        Driver.getDriver().switchTo().frame(testotomasyonuExercise.iframeAddressGoogle).close();
        //12.Click 'Cart' button
        testotomasyonuExercise.cartIcone.click();
        //13. Click 'Proceed To Checkout' button
        testotomasyonuExercise.proceedToCheckout.click();
        //14. Verify Address Details and Review Your Order
Assert.assertTrue(testotomasyonuExercise.addressDetails.isDisplayed());
Assert.assertTrue(testotomasyonuExercise.reviewYourOrder.isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        actions.moveToElement(testotomasyonuExercise.commentBox).sendKeys("Hello , Then we are FREE ...")
                .moveToElement(testotomasyonuExercise.placeOrder).sendKeys(Keys.ENTER).perform();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        /*
        Random rand=new Random();
        int cvc=rand.nextInt(900)+100;

        actions.moveToElement(testotomasyonuExercise.paymentName)
                .sendKeys(firstName+Keys.TAB).sendKeys(faker.finance().iban()).sendKeys(Keys.TAB)
                .sendKeys("123").sendKeys(Keys.TAB).sendKeys(faker.business().creditCardExpiry().;

*/
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        //20. Click 'Continue' button
        //21. Click 'Delete Account' button
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Driver.quitDriver();
    }
}
