package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuAccountPage {
   public TestotomasyonuAccountPage () {
       PageFactory.initElements(Driver.getDriver(), this);
   }
   @FindBy(xpath="(//*[@class='cart-bar'])[1]")
    public WebElement account;

   @FindBy(xpath = "(//*[@type='email'])[1]")
    public  WebElement emailBox;

   @FindBy(xpath = "(//*[@class='img-round mx-2'])[6]")
    public WebElement logOut;

   @FindBy(xpath ="//*[@class='text-white']")
    public WebElement wrongEmailPassword;
}
