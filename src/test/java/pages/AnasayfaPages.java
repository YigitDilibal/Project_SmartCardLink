package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AnasayfaPages {
    public AnasayfaPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement homepageSıgnInButonu;

    @FindBy (id = "email")
    public WebElement signInEmailKutusu;

    @FindBy (id = "password")
    public WebElement signInPasswordKutusu;

    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement signInLoginButonu;

    @FindBy (xpath = "//*[@class='bi bi-eye-slash-fill']")
    public WebElement signInBieyeSlashFillpasswordHide;

    @FindBy (xpath = "//*[@class='bi bi-eye-fill']" )
    public WebElement signInBieyeSlashFillpasswordShow;

    @FindBy (id = "remember_me")
    public WebElement signInRemembermeBox;

    @FindBy(xpath = "//*[.='Sign In']")
    public WebElement signInFormu;

    @FindBy(xpath = "//footer//li/a")
    public List<WebElement> socialMediaIcons;

    @FindBy(xpath = "//*[@class='form-control bg-white']")
    public WebElement homepageSubscribeEnterEmailBox;

    @FindBy(xpath = "//*[.='Subscribe']")
    public WebElement homepageSubscribeButton;

    @FindBy(xpath = "//*[.='Success']")
    public WebElement homepageSubscribeSuccessAlert;

    @FindBy (id = "password_confirmation")
    public WebElement kayitSayfasiConfirmPassword;

    @FindBy (id = "privacyPolicyCheckbox")
    public WebElement kayitSayfasiTermsAndConditions;
    @FindBy (xpath = "//*[.='Terms & Conditions']")
    public WebElement TermsConditionsSayfasi;

    @FindBy (xpath = "//*[.='Privacy Policy']")
    public WebElement PrivacyPolicySayfasi;

    @FindBy (xpath = "//*[.='FAQ']")
    public WebElement FAQSayfasi;

    @FindBy (xpath = "//h1[.='Frequently Asked Questions (FAQ)']")
    public WebElement TitleFAQSayfasi;

    @FindBy (xpath = "//h1[.='Terms & Conditions']")
    public WebElement TitleTermsCondition;

    @FindBy (xpath = "//h1[.='Privacy Policy']")
    public WebElement TitlePrivacyPolicySayfasi;




}
