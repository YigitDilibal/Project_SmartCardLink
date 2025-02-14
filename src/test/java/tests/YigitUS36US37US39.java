package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

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

    // US36 - Test Case 03
    // Impersonate modunda yetki kontrolü testi.(negatif)

    @Test
    public void US36TC03ImpersonateModundaYetkiKontroluTesti(){
        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "User" sekmesine tıklar.
        adminPages.dashboardSolPanelUsersButonu.click();

        //"Impersonate" butonuna tıklar.

        adminPages.usersSekmesiImpersonateButonlariListesi.get(0).click();

        //Impersonate edilen kullanıcı ile yetkisi olmayan bir URL'e gitmeyi ve hata alindigini test eder.
        Driver.getDriver().get("https://qa.smartcardlink.com/sadmin/dashboard");
        Assert.assertTrue(adminPages.userDoesNotHaveTheRightRolesYazisi.isDisplayed());

        //Tarayıcıda geri butonuna tıklar.
        Driver.getDriver().navigate().back();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US36 - Test Case 04
    // Impersonate modundan çıkış testi.

    @Test
    public void US36TC04ImpersonateModundanCikisTesti(){
        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "User" sekmesine tıklar.
        adminPages.dashboardSolPanelUsersButonu.click();
        String impersonateOncesiIsim = adminPages.avatarDropdownMenuButonu.getText();

        //"Impersonate" butonuna tıklar.

        adminPages.usersSekmesiImpersonateButonlariListesi.get(0).click();

        //Ekranın sağ üstünde "Impersonate-leave" simgesinin görüntülendiğini test eder.
        Assert.assertTrue(adminPages.impersonateLeaveButonu.isDisplayed());

        //Dashboard'da "VCards" sekmesine tıklar.
        userPages.solPanelVcardsButonu.click();

        //"VCards" sekmesinde hala "Impersonate-leave" simgesinin görüntülendiğini test eder.
        Assert.assertTrue(adminPages.impersonateLeaveButonu.isDisplayed());

        //"Impersonate-leave" simgesine tıklar.
        adminPages.impersonateLeaveButonu.click();

        //Sağ üstte kendi admin bilgilerinin görüntülendiğini test eder.
        String impersonateSonrasiIsim = adminPages.avatarDropdownMenuButonu.getText();

        Assert.assertEquals(impersonateOncesiIsim,impersonateSonrasiIsim);


        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US36 - Test Case 05
    // Impersonate modunda veri güncelleme ve silme testi.

    @Test
    public void US36TC05ImpersonateModundaVeriGuncellemeVeSilmeTesti(){
        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "User" sekmesine tıklar.
        adminPages.dashboardSolPanelUsersButonu.click();
        String impersonateOncesiIsim = adminPages.avatarDropdownMenuButonu.getText();

        //"Impersonate" butonuna tıklar.

        adminPages.usersSekmesiImpersonateButonlariListesi.get(0).click();

        //Dashboard'da "VCards" sekmesine tıklar.
        userPages.solPanelVcardsButonu.click();

        //"New VCard" butonuna tıklar.
        userPages.vCardsSayfasiNewVcardButonu.click();

        //URL ve isim belirleyip kaydet butonuna tıklar ve VCardın oluştuğunu test eder.
        userPages.newVcardSayfasiUrlAliasKutusu.sendKeys("vcardurltest");
        userPages.newVcardSayfasiVcardNameKutusu.sendKeys("vcardtest");

        userPages.newVcardSayfasiKaydetButonu.click();

        Assert.assertTrue(userPages.vCardOlusturulduUyarisi.isDisplayed());

        //Edit sayfasında ismi değiştirir.

        userPages.newVcardSayfasiVcardNameKutusu.clear();
        userPages.newVcardSayfasiVcardNameKutusu.sendKeys("vcardtest2");

        //"First name" kutusunu doldurur.
        userPages.newVcardSayfasiFirstNameKutusu.sendKeys("yigit");

        //"Last name" kutusunu doldurur.
        userPages.newVcardSayfasiLastNameKutusu.sendKeys("test");

        //Kaydet butonuna basar ve yapılan değişikliklerin kaydedildiğini test eder.

        JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",userPages.newVcardSayfasiKaydetButonu);
        ReusableMethods.bekle(1);

        userPages.newVcardSayfasiKaydetButonu.click();


        Assert.assertTrue(userPages.vCardOlusturulduUyarisi.isDisplayed());

        //Sağ üssteki "Back" butonuna basar.
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",userPages.newVcardSayfasiBackButonu);
        ReusableMethods.bekle(1);

        userPages.newVcardSayfasiBackButonu.click();

        //Oluşturduğu VCard'ın yanındaki delete butonuna basar ve "Yes, Delete!" butonuna tıklar.
        userPages.vCardsSayfasiDeleteButonlariListesi.get(0).click();
        userPages.vCardsSayfasiYesDeleteButonu.click();

        //VCardın silindiğini doğrular.
        Assert.assertTrue(userPages.vCardsSayfasiDeletedUyarisi.isDisplayed());
        ReusableMethods.bekle(2);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }



}
