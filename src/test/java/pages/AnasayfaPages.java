package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

}
