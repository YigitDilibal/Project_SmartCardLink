package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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


}
