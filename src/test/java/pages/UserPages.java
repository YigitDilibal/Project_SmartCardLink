package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserPages {

    public UserPages (){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy (id = "dropdownMenuButton1")
    public WebElement userAvatarDropdownMenuButonu ;

    @FindBy (xpath = "//*[@class='svg-inline--fa fa-money-bill']")
    public WebElement userDropdownMenuManageSubscription ;

    @FindBy (xpath = "//a[@class='btn btn-primary']")
    public WebElement userSubscriptionUpgradeButton ;

    @FindBy (xpath ="//*[@data-id='2']")
    public WebElement userSilverSwitchPlanButton ;

    @FindBy (xpath ="(//*[@role='combobox'])[1]")
    public WebElement userSubscriptionSelectPaymentDdwButton ;

    @FindBy (xpath="//li[@id='select2-paymentType-result-evjt-1']")
    public  WebElement userSubscriptionDropdownStripeButton;

    @FindBy (xpath="//*[@class='mt-5 stripePayment proceed-to-payment']")
    public WebElement paySwitchPlanButton ;

    @FindBy (id = "cardNumber")
    public WebElement subscriptionCardNumberInput ;

    @FindBy (id = "cardExpiry")
    public WebElement cardExpirationDateInput ;

    @FindBy (id = "cardCvc")
    public WebElement cardCvcInput ;

    @FindBy (id = "billingName")
    public WebElement cardHolderNameInput ;

    @FindBy (className = "SubmitButton-IconContainer") //*[@class="SubmitButton-IconContainer"]
    public WebElement userSubscriptionPayButton ;












}
