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


}
