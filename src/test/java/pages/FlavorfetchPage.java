package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FlavorfetchPage {
    public FlavorfetchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "(//*[@class='position-relative '])[4]")
    public WebElement partner;

    @FindBy(xpath = "(//*[@class='text-green'])[3]")
    public WebElement loginHere;

    @FindBy(xpath = "(//*[@class='required'])[1]")
    public WebElement userNameMerchantLogin;

    @FindBy(xpath = "(//*[@class='required'])[3]")
    public WebElement passwordMerchantLogin;

    @FindBy(xpath = "//*[@class='custom-control-input']")
    public WebElement rememberMerchantLogin;

    @FindBy(xpath = "//*[@value='Sign in']")
    public WebElement signInMerchantLogin;

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement acceptCoockiee;
}
