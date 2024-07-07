package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestotomasyonuPage {
    public TestotomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="global-search")
   public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucu;
    @FindBy(xpath = "//span[text()='Account']")
    public WebElement accountLinki;
 @FindBy(xpath = "//span[text()='Logout']")
 public WebElement logoutButtonu;
    @FindBy(id = "email")
    public WebElement loginEmailKutusu;
    @FindBy(id = "submitlogin")
    public WebElement loginSiginButonu;

    @FindBy(id = "password")
    public WebElement loginPasswordKutusu;
    @FindBy(id = "shopping-list")
    public List<WebElement> aramaSonucUrunList;
    @FindBy(className = "prod-img")
    public List<WebElement> sonucElementleriList;
    @FindBy(xpath = "(//*[@class='e-cart'])[2]")
    public WebElement yourCart;
    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindaUrunIsimElementi;

    @FindBy(xpath = "//*[@class='add-to-cart']")
    public WebElement addToCartButonu;

    @FindBy(xpath = "(//span[@class='menu-icon-text'])[3]")
    public WebElement yourCartLinki;

    @FindBy(xpath = "//*[@*='product-title text-center']")
    public WebElement sepettekiUrunIsimElementi;


}
