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

    @FindBy (xpath="(//li[contains(@id, 'select2-paymentType-result')])[1]\n")
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

    @FindBy (className = "SubmitButton-IconContainer")
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

    @FindBy (id = "changePassword")
    public WebElement changePasswordButonu;

    @FindBy(xpath = "//*[@name='current_password']")
    public WebElement parolaDegistirmeFormuCurrentPasswordTextBox;

    @FindBy(xpath = "//*[@name='new_password']")
    public WebElement parolaDegistirmeFormuNewPasswordTextBox;

    @FindBy(xpath = "//*[@name='confirm_password']")
    public WebElement parolaDegistirmeFormuConfirmPasswordTextBox;

    @FindBy(id = "passwordChangeBtn")
    public WebElement parolaDegiştirmeFormuSaveButonu;

    @FindBy(xpath = "(//*[@type='button'])[13]")
    public WebElement parolaDegiştirmeFormuDiscardButonu;

    @FindBy(xpath = "(//*[@class='bi bi-eye-slash-fill'])")
    public List<WebElement> biEyeFillHide;

    @FindBy(xpath = "(//*[@class='bi bi-eye-fill'])")
    public List<WebElement> biEyeFillShow;

    @FindBy(xpath = "//*[@class='toast-message']")
    public WebElement parolaDeğişimMesajı;

    @FindBy (xpath ="//*[@class='toast-title']" )
    public WebElement parolaDeğişimBaşlığı;

    @FindBy (xpath = "(//*[@class='btn-close'])[2]")
    public WebElement parolaDeğişimFormuKapatmaXbutonu;

    @FindBy (id = "changePasswordForm")
    public WebElement parolaDegişimFormu;

    @FindBy (xpath = "//*[@class='btn btn-primary sendInviteBtn']")
    public WebElement affiliationsSayfasiSendInviteButonu;

    @FindBy (xpath = "//*[@name='email']")
    public WebElement affiliationsSayfasiSendInviteBolumuEmailKutusu;

    @FindBy (xpath = "//*[@class='btn btn-primary sendmailbtn']")
    public WebElement affiliationsSayfasiSendInviteBolumuSubmitButonu;

    @FindBy (xpath = "(//*[@class='btn btn-secondary'])[2]")
    public WebElement affiliationsSayfasiSendInviteBolumuCloseButonu;
  
      @FindBy (xpath = "//*[@class='payment-title mb-3']")
    public WebElement paymentSuccesfulMessage;

    @FindBy (xpath = "//*[@class='btn mt-5 btn-back']")
    public WebElement backToSubscriptionButton;

    @FindBy (xpath = "//a[@data-id='3']")
    public WebElement userSubscriptionGoldPlanButton;

    @FindBy (xpath = "//*[@style='opacity: 1; height: auto; margin-top: 4px;']")
    public WebElement subscriptionInvalidCardErrorMessage;

    @FindBy (xpath = "//*[@class='InlineSVG Icon Header-backArrow mr2 Icon--sm']")
    public WebElement subscriptionPurchaseBackButton;

    @FindBy (xpath = "//*[@class='payment-text']")
    public WebElement paymentCancelledMessage;

    @FindBy (xpath = "//*[@class='btn payment-btn']")
    public WebElement paymentFailureBackButton;

    @FindBy (xpath = "(//*[@class='nav-link'])[2]")
    public WebElement userSubscriptionUnlimitedTab;

    @FindBy (xpath = "//*[@data-id='4']")
    public WebElement userSubscriptionUnlimitedButton;

    @FindBy (xpath = "(//*[@class='mb-2'])[4]")//
    public WebElement subscriptionUnlimitedPlanPrice;

    @FindBy (xpath = "//*[@class='CurrencyAmount']")
    public WebElement purchaseUnlimitedPlanPrice;//*[@class="CurrencyAmount"]

    @FindBy (xpath = "//select[@class='form-control form-select select2-hidden-accessible']")
    public WebElement languageChangeSelectionModal;

    @FindBy (id = "languageChangeBtn")
    public WebElement languageChangeSaveButtonu;

    @FindBy (xpath = "//span[contains(text(), 'Austragen')]")
    public WebElement germanSıgnOutButton;

    @FindBy(xpath = "//*[@class='toast-title']")
    public WebElement dilDeğişimBaslıgı;

    @FindBy(xpath = "(//*[@type='button'])[11]")
    public WebElement dilDegişimDiscardButonu;


    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement manageSubscriptionUnlimitedSekmesi;

    @FindBy(xpath = "//a[@data-plan-price='149.99']")
    public WebElement unlimitedPlanSwitchPlanButonu;

    @FindBy (id = "withdrawal-tab")
    public WebElement affilationsWithdrawalTab;

    @FindBy(xpath = "//*[@data-bs-target='#withdrawAmountModal']")
    public WebElement affilationsWithdrawAmountButton;

    @FindBy (id = "withdrawAmount")
    public WebElement withdrawAmountKutusu;

    @FindBy (id = "paypalEmail")
    public WebElement withdrawPaypalEmailKutusu;

    @FindBy(xpath = "(//button[.='Save'])[1]")
    public WebElement withdrawSaveButton;

    ////////////////////////////////////////US15////////////////////////////////////////

    @FindBy(xpath = "(//li[@class='nav-item '][4])")
    public WebElement virtualBackgroundsSideBarButonu;

    @FindBy(xpath = "//img[@src='https://qa.smartcardlink.com/assets/img/ecards/H-Vcard/H-1/Back.png']")
    public WebElement virtualBackgroundsIlkKartTemplateResmi;

    @FindBy(xpath = "//h1[.='Add Virtual Background']")
    public WebElement virtualBackgroundsAddVirtualBackgroundYazisi;

    @FindBy(xpath = "//span[@aria-controls='select2-e-vcard-id-container']")
    public WebElement virtualBackgroundsVcardNameDropdownButonu;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement virtualBackgroundsVcardNameSearchInputAlani;

    @FindBy(id = "e-card-first-name")
    public WebElement virtualBackgroundsFirstnameInputAlani;

    @FindBy(id = "e-card-last-name")
    public WebElement virtualBackgroundsLastnameInputAlani;

    @FindBy(id = "e-card-email")
    public WebElement virtualBackgroundsEmailInputAlani;

    @FindBy(id = "e-card-occupation")
    public WebElement virtualBackgroundsOccupationInputAlani;

    @FindBy(id = "e-card-location")
    public WebElement virtualBackgroundsLocationInputAlani;

    @FindBy(id = "phoneNumber")
    public WebElement virtualBackgroundsTelefonNumarasiInputAlani;

    @FindBy(xpath = "//div[@class='iti__selected-flag']")
    public WebElement virtualBackgroundsUlkeBayragiSeciliAlan;

    @FindBy(id = "e-card-website")
    public WebElement virtualBackgroundsWebsiteInputAlani;

    @FindBy(xpath = "//a[.='Back']")
    public WebElement virtualBackgroundsBackButonu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement virtualBackgroundsSaveButonu;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    public WebElement virtualBackgroundsDiscardButonu;

    @FindBy(xpath = "//span[@class='picker-edit rounded-circle text-gray-500 fs-small']")
    public WebElement virtualBackgroundsResimSecmeButonu;

    @FindBy(xpath = "//*[.='The ecard-logo field is required.']")
    public WebElement virtualBackgroundsResimYuklenmeyinceVerilenUyariMesaji;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement virtualBackgroundsFileInput;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__message']")
    public WebElement virtualBackgroundsVcardNameNotFoundInputText;
  
    @FindBy(xpath = "(//*[.='Cancel'])[1]")
    public WebElement withdrawAmountPenceresiCancelButton;
 

}
