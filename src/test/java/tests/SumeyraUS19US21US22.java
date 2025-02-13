package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SumeyraUS19US21US22 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();

    @Test
    public void gecerliLoginTesti (){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsumeyramail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        //Login tusuna basar ve kendi sayfasına erişim saglar.
        anasayfaPages.signInLoginButonu.click();
        //Sıgn out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        ReusableMethods.bekle(2);
        adminPages.signOutButonu.click();
        // Başarılı bir şekilde signin sayfasına geri döner.
       // Assert.assertTrue(anasayfaPages.signInLoginButonu.isDisplayed());
        Driver.quitDriver();
    }
}

