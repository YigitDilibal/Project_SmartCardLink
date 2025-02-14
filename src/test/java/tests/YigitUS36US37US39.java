package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;

public class YigitUS36US37US39 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();
    UserPages userPages = new UserPages();



    // US36 - Test Case 01
    // Yönetim panelinde kullanıcı listesinin görüntülenebilmesi testi

    @Test
    public void US36TC01KullaniciListesiGoruntulenmeTesti(){
        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "User" sekmesine tıklar.
        adminPages.dashboardSolPanelUsersButonu.click();

        //Kullanıcı listesinin görüntülendiğini test eder
        String currentUrl = Driver.getDriver().getCurrentUrl();
        String actualUrl = "https://qa.smartcardlink.com/sadmin/users";

        Assert.assertEquals(currentUrl,actualUrl);
        Assert.assertTrue(adminPages.usersSekmesiAddUserButonu.isDisplayed());

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US36 - Test Case 02
    // Impersonate moduna geçiş testi.

    @Test
    public void US36TC02ImpersonateModunaGecisTesti(){
        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "User" sekmesine tıklar.
        adminPages.dashboardSolPanelUsersButonu.click();

        //Her kullanıcı satırının yanında "Impersonate" butonunun olduğunu test eder.

        Assert.assertEquals(adminPages.usersSekmesiImpersonateButonlariListesi.size(), 10);

        //"Impersonate" butonuna tıklar.

        String listedekiIsim = adminPages.usersSekmesiKullaniciAdlariListesi.get(0).getText();
        adminPages.usersSekmesiImpersonateButonlariListesi.get(0).click();

        //Sağ üstte impersonate edilen kullanıcının profil bilgilerinin yazdığını doğrular.

        String impersonateModundakiIsim = adminPages.avatarDropdownMenuButonu.getText();

        Assert.assertEquals(listedekiIsim,impersonateModundakiIsim);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }



}
