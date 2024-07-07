package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class TestotomasyonuExercise {
   public TestotomasyonuExercise(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@style='color: orange;']")
     public WebElement homePageSimbol;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscriptionButton;

    @FindBy(xpath = "//*[@class='fa fa-angle-up']")
    public WebElement scrollUpButton;

    @FindBy(xpath = "//*[text()='Full-Fledged practice website for Automation Engineers']")
    public  WebElement FullFledged;

    @FindBy(xpath = "//*[@class='material-icons card_travel']")
    public WebElement productElement;

    @FindBy(xpath = "//*[@class='fa fa-shopping-cart']")
    public List<WebElement> productsList;
 @FindBy(xpath = "//*[@class='fa fa-plus-square']")
 public List<WebElement> productList;
    @FindBy (xpath = "//*[@class='btn btn-default add-to-cart']")
    public List<WebElement> addToCart;
    @FindBy(xpath = "//*[@data-dismiss='modal']")
    public WebElement contShopping;
 @FindBy(xpath = " //*[@class='productinfo text-center']")
 public  List<WebElement> listOfProduct;
 @FindBy(xpath = " //*[@class='product-image-wrapper']")
 public  WebElement listOfProducts;
    @FindBy(xpath = "//*[text()='View Cart']")
    public  WebElement viewCartElement;

    @FindBy(xpath = "//*[text()='Continue Shopping']")
     public WebElement continueShoping;




    @FindBy(xpath = "//*[text()='Add to cart']")
    public  List<WebElement>  addToCartElements;

    @FindBy(xpath = "//*[@class='active']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//*[text()=' Cart']")
    public WebElement cartIcone;

    @FindBy(xpath = "//*[@id='checkoutModal']")
    public WebElement checkOutModal;

    @FindBy(xpath ="//*[@class='btn btn-default check_out']" )
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//*[@class='fa fa-lock']")
    public  WebElement signUpLogIn;
    @FindBy(xpath = "//*[text()='Register / Login']")
    public  WebElement rejisterLogin;
    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public  WebElement nameNewUserBox;
    @FindBy(xpath = "//*[@id='id_gender2']")
    public  WebElement mrsRadioBox;
    @FindBy(xpath = "//*[@type='password']")
    public  WebElement passwordBox;
    @FindBy(xpath = "//*[@class='title text-center']")
    public  WebElement accountCreated;
    @FindBy(xpath = "//*[@data-qa='continue-button']")
    public  WebElement continueButtonAfterRejister;
    @FindBy(xpath = "//*[@name='googlefcPresent']")
    public  WebElement iframeNameGoogle;
    @FindBy(xpath = "//*[@class='google-auto-placed']")
    public  WebElement iframeAddressGoogle;
    @FindBy(xpath = "(//*[@class='heading'])[1]")
    public  WebElement addressDetails;
    @FindBy(xpath = "(//*[@class='heading'])[2]")
    public  WebElement reviewYourOrder;
    @FindBy(xpath = "//*[@class='form-control']")
    public  WebElement commentBox;
    @FindBy(xpath = "//*[@class='btn btn-default check_out']")
    public  WebElement placeOrder;
    @FindBy(xpath = "//*[@class='form-control']")
    public  WebElement paymentName;

@FindBy(xpath = "(//*[@data-product-id='1'])[1]")
public WebElement firstProduct;
@FindBy(xpath = "(//*[@data-product-id='2'])[1]")
public WebElement secoundProduct;

@FindBy(xpath = "//tbody//tr")
 public  List<WebElement> satirSayisi;
@FindBy(xpath = "//*[@href='/product_details/1']")
 public WebElement viewProductElement;

@FindBy(xpath = "//*[@name='product_id']")
 public  WebElement increaseQuantity;

@FindBy(xpath = "//*[@id='quantity']")
 public WebElement quantity;
@FindBy(xpath = "//*[@class='btn btn-default cart']")
 public WebElement addToCartElement;
@FindBy(xpath = "//tbody/tr[1]/td[4]")
 public WebElement checkQuantity;
@FindBy(xpath = "//*[@value='1']")
 public WebElement quantityValue;

@FindBy(xpath = "//*[@name='googlefcInactive']")
 public WebElement iframMozahem;
}
