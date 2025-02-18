package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SaadatUS20US26US27 {

    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup(){
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();
    }

    @Test
    public void dashbordDilsecmeTesti () {
        //Kullanıcı url ile siteye erişir ve sign ın sayfasına ulaşır.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersaadatmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        //Login tusuna basar ve kendi sayfasına erişim saglar.git
        anasayfaPages.signInLoginButonu.click();
        //Avatar dashbord dan dil seçim alanına tıklar
        userPages.avatarDropdownMenuButonu.click();
        userPages.userDashboardLanguageChangeButton.click();
        //Dashboard sayfası yüklendiğinde, sistemin varsayılan dili otomatik olarak belirlediğini kontrol eder.
        Select select = new Select(userPages.languageChangeSelectionModal);
        select.selectByValue("de");
        userPages.languageChangeSaveButtonu.click();
        //Dili almanca olarak değiştiğini doğrular.
        String expectedTitle = "Success";
        ReusableMethods.bekle(3);
        //sıgn out olur ve sayfayı kapatır
        userPages.avatarDropdownMenuButonu.click();
        userPages.germanSıgnOutButton.click();
        Driver.quitDriver();

    }
}
