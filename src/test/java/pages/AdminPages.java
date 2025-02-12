package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPages {

    public AdminPages (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(xpath = "(//span[text()='Allow all cookies'])[2]")
    public WebElement cookiesKabulButonu;







}
