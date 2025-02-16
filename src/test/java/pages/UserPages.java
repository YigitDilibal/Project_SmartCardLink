package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UserPages {

    public UserPages (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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

    @FindBy (id = "dropdownMenuButton1")
    public WebElement avatarDropdownMenuButonu ;

    @FindBy (xpath = "//span[contains(text(), 'Sign Out')]")
    public WebElement signOutButonu;

    @FindBy (xpath = "(//*[.='Enquiries'])[1]")
    public WebElement dahbordPanelEnguiriesButonu;

    @FindBy (xpath = "(//*[.='VCards'])[1]")
    public WebElement solPanelVcardsButonu;

    @FindBy (xpath = "//*[.='New VCard']")
    public WebElement vCardsSayfasiNewVcardButonu;

    @FindBy (id = "vcard-url-alias")
    public WebElement newVcardSayfasiUrlAliasKutusu;

    @FindBy (id = "name")
    public WebElement newVcardSayfasiVcardNameKutusu;

    @FindBy (id = "vcardSaveBtn")
    public WebElement newVcardSayfasiKaydetButonu;

    @FindBy (xpath = "//*[@role='alert']")
    public WebElement vCardOlusturulduUyarisi;

    @FindBy (id = "first_name")
    public WebElement newVcardSayfasiFirstNameKutusu;

    @FindBy (id = "last_name")
    public WebElement newVcardSayfasiLastNameKutusu;

    @FindBy (xpath = "//*[@class='btn btn-outline-primary float-end']")
    public WebElement newVcardSayfasiBackButonu;

    @FindBy (xpath = "//*[@title='Delete']")
    public List<WebElement> vCardsSayfasiDeleteButonlariListesi;

    @FindBy (xpath = "//*[.='Yes, Delete!']")
    public WebElement vCardsSayfasiYesDeleteButonu;

    @FindBy (xpath = "//*[.='Deleted !']")
    public WebElement vCardsSayfasiDeletedUyarisi;

    @FindBy (id = "changePassword")
    public List<WebElement> changePasswordButonuListesi;

    @FindBy (xpath = "//span[.='Affiliations']")
    public WebElement solPanelAffiliationsButonu;

    @FindBy (xpath = "//h1[.='Affiliations']")
    public WebElement affiliationsSayfasiTitle;

    @FindBy (xpath = "//*[@class='fw-bolder text-white']")
    public List<WebElement> affiliationsSayfasiToplamVeGuncelBakiyeYazilariListesi;

    @FindBy (id = "urlLink")
    public WebElement affiliationsSayfasiDavetBaglantisiElementi;

    @FindBy (id = "copyLinkBtn")
    public WebElement affiliationsSayfasiDavetBaglantisiCopyButonu;

    @FindBy (xpath = "//*[.='Link copied successfully.']")
    public WebElement affiliationsSayfasiDavetKopyalandiOnayMesaji;

    @FindBy (xpath = "//*[@class='toast-close-button']")
    public WebElement affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu;

    @FindBy (id = "changeLanguage")
    public WebElement userDashboardLanguageChangeButton;

}
