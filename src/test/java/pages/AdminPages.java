package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPages {

    public AdminPages (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "dropdownMenuButton1")
    public WebElement avatarDropdownMenuButonu ;

    @FindBy (xpath = "//span[contains(text(), 'Sign Out')]")
    public WebElement signOutButonu;

    @FindBy (xpath = "(//*[.='Users'])[1]")
    public WebElement dashboardSolPanelUsersButonu;

    @FindBy (xpath = "//a[.='Add User']")
    public WebElement usersSekmesiAddUserButonu;

    @FindBy (xpath = "//*[@class='btn btn-sm btn-info user-impersonate']")
    public List<WebElement> usersSekmesiImpersonateButonlariListesi;

    @FindBy (xpath = "//*[@class='mb-1 text-decoration-none fs-6']")
    public List<WebElement> usersSekmesiKullaniciAdlariListesi;

    @FindBy (xpath = "//*[@class='ml-4 text-lg text-gray-500 uppercase tracking-wider']")
    public WebElement userDoesNotHaveTheRightRolesYazisi;

    @FindBy (xpath = "//*[@class='svg-inline--fa fa-user-check fs-2']")
    public WebElement impersonateLeaveButonu;

    @FindBy (xpath = "//span[contains(text(), 'Bağlı Kullanıcılar')]")
    public WebElement adminSekmesiBagliKullanicilarButonu;

    @FindBy (xpath = "//span[contains(text(), 'Abone Olunan Kullanıcı Planları')]")
    public WebElement adminSekmesiSubscribedUserButonu;

    @FindBy (id = "logout-form")
    public WebElement adminOturumuKapatButonu;

    @FindBy (xpath = "(//*[.='Affiliation Transactions'])[1]")
    public WebElement affilationTransactionsSekmesi;

    @FindBy (id = "dropdownMenuLink")
    public List<WebElement> approvalStatusList ;

    @FindBy (id = "approveWithdrawalBtn")
    public WebElement approveWithdrawalButton;

    @FindBy (id = "approveWithdrawalStatus")
    public WebElement approveWithdrawalSaveButton;

    @FindBy (xpath = "//*[@data-icon='eye']")
    public List<WebElement> withdrawalSayfasiViewButonlariList;

    @FindBy (id = "withdrawalIsApproved")
    public WebElement withdrawalIsApproved;

    @FindBy (xpath = "(//*[@class='btn-close'])[5]")
    public WebElement withdrawalViewCloseButton;

    ////////////////////////////////////////US29////////////////////////////////////////

    @FindBy(xpath = "(//*[.='Plans'][1])")
    public WebElement adminPlansSidebarButonu;

    @FindBy(xpath = "//input[@class='form-control ps-8']")
    public WebElement adminPlansTabloSearchInputAlani;

    @FindBy(xpath = "(//span[@class='relative d-flex align-items-center'][1])")
    public WebElement adminPlansTabloNameSiralamaButonu;

    @FindBy(xpath = "(//span[@class='relative d-flex align-items-center'][2])")
    public WebElement adminPlansTabloPriceSiralamaButonu;

    @FindBy(xpath = "(//span[@class='relative d-flex align-items-center'][3])")
    public WebElement adminPlansTabloStatusSiralamaButonu;

    @FindBy(xpath = "(//span[@class='relative d-flex align-items-center'][4])")
    public WebElement adminPlansTabloDurationSiralamaButonu;

    @FindBy(xpath = "(//span[@class='relative d-flex align-items-center'][5])")
    public WebElement adminPlansTabloMakeDefaultSiralamaButonu;

    @FindBy(xpath = "(//a[.='Plans'][1])")
    public WebElement adminPlansSayfasiBaslikYazisi;

    @FindBy(xpath = "(//input[@name='status'][1])")
    public WebElement adminPlansStatusToggleButonu;

    @FindBy(xpath = "(//a[@title='Edit'][1])")
    public WebElement adminPlansEditButonu;

    @FindBy(xpath = "(//a[@title='Delete'][1])")
    public WebElement adminPlansDeleteButonu;

    @FindBy(id = "perPage")
    public WebElement adminPlansShowDropdownButonu;

    @FindBy(xpath = "//li[@class='page-item disabled']")
    public WebElement adminPlansPageBackButonu;

    @FindBy(xpath = "//button[.='›']")
    public WebElement adminPlansPageNextButonu;

    @FindBy(xpath = "(//a[.='New Plan'])[1]")
    public WebElement adminPlansNewPlanButonu;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement adminPlansNewPlanNameInputAlani;

    @FindBy(xpath = "//span[@aria-labelledby='select2-frequency-container']")
    public WebElement adminPlansFrequencyDropdownButonu;

    @FindBy(xpath = "//span[@aria-labelledby='select2-currency_id-container']")
    public WebElement adminPlansCurrencyDropdownButonu;

    @FindBy(xpath = "//input[@placeholder='Enter Price']")
    public WebElement adminPlansPriceInputAlani;

    @FindBy(xpath = "//*[@id='no_of_vcards']")
    public WebElement adminPlansKartNumarasiInputAlani;

    @FindBy(xpath = "//*[@id='trial_days']")
    public WebElement adminPlansTrialDaysInputAlani;

    @FindBy(xpath = "//div[@class='col-lg-3 img-box mb-2'][2]")
    public WebElement adminPlansTemplateSecmeAlani;

    @FindBy(id = "featureAll")
    public WebElement adminPlansSelectAllFeaturesCheckbox;

    @FindBy(xpath = "//input[@name='products_services']")
    public WebElement adminPlansFeatureSecmeAlani;

    @FindBy(id = "planFormSubmit")
    public WebElement adminPlansSaveButonu;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    public WebElement adminPlansDiscardButonu;

    @FindBy(xpath = "//h1[.='New Plan']")
    public WebElement adminPlansNewPlanYazisi;

    @FindBy(xpath = "//div[.='Select one or more Feature is required']")
    public WebElement adminPlansFeatureSecmeyinceToastMesaji;

    @FindBy(xpath = "//div[.='Multi templates is required']")
    public WebElement adminPlansTemplateSecmeyinceToastMesaji;

    @FindBy(xpath = "//input[@aria-controls='select2-frequency-results']")
    public WebElement adminPlansFrequencySearchInputAlani;

    @FindBy(xpath = "//ul[@id='select2-frequency-results']")
    public WebElement adminPlansFrequencyNoResultsFoundText;

    @FindBy(xpath = "//ul[@id='select2-currency_id-results']")
    public WebElement adminPlansCurrencyNoResultsFoundText;

    @FindBy(xpath = "//*[.='The name has already been taken.']")
    public WebElement adminPlansAyniIsimHatasi;

    @FindBy(xpath = "//*[.='Delete !']")
    public WebElement adminPlansDeletePopupTitle;

    @FindBy(xpath = "//*[.='Yes, Delete!']")
    public WebElement adminPlansDeletePopupYesButonu;

    @FindBy(xpath = "//*[.='No, Cancel']")
    public WebElement adminPlansDeletePopupNoButonu;

    @FindBy(xpath = "//*[.='Ok']")
    public WebElement adminPlansDeletePopupOkButonu;

    @FindBy(xpath = "//td[@class=\'text-center\']")
    public WebElement adminPlansNoDataAvailableYazisi;

    @FindBy(xpath = "(//td)[1]")
    public WebElement adminPlansBurakCell;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement adminPlansCurrencyInputAlani;

    @FindBy(xpath = "//li[@id='select2-currency_id-result-vcq6-1']")
    public WebElement adminPlasnCurrencySecimi;


    ////////////////////////////////////////US40////////////////////////////////////////

    @FindBy(xpath = "//button[@id='dropdownMenuButton1']")
    public WebElement menuButonu;

    @FindBy(xpath = "//a[@id='changeLanguage']")
    public WebElement changeLanguageButonu;

    @FindBy(xpath = "//h3[.='Change Language']")
    public WebElement changeLanguagePopupText;

    @FindBy(xpath = "//*[@id='changeLanguageModal']/div/div/div/button")
    public WebElement changeLanguagePopupXButonu;

    @FindBy(xpath = "//span[@id='select2-selectLanguage-container']")
    public WebElement changeLanguageDropdownButonu;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement changeLanguageInputAlani;

    @FindBy(xpath = "//li[@id='select2-selectLanguage-result-068j-tr']")
    public WebElement turkceDilSecimi;

    @FindBy(xpath = "//button[@id='languageChangeBtn']")
    public WebElement changeLanguagePopupKaydetButonu;

    @FindBy(xpath = "//*[@id='changeLanguageForm']/div[2]/button[2]")
    public WebElement changeLanguagePopupIptalButonu;

    @FindBy(xpath = "//a[@class='dropdown-item text-gray-900 d-flex']")
    public WebElement logoutButonu;



}