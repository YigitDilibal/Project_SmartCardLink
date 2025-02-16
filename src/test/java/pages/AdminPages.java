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


}