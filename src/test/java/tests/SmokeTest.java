package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class SmokeTest extends TestBaseRapor {
    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup(){
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();
    }

    @Test (priority = 1)
    public void US37TC07SiteyeKayitOlmaTesti(){

        Faker faker = new Faker();

        //kullanıcı kayıt olur.

        Driver.getDriver().get(ConfigReader.getProperty("yigitDavetBaglantisi"));

        userPages.newVcardSayfasiFirstNameKutusu.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        userPages.newVcardSayfasiLastNameKutusu.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        String email = faker.internet().emailAddress();
        userPages.affiliationsSayfasiSendInviteBolumuEmailKutusu.sendKeys(email);
        ReusableMethods.bekle(1);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.kayitSayfasiConfirmPassword.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.kayitSayfasiTermsAndConditions.click();
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();
        ReusableMethods.bekle(1);

        // giris yapar

        anasayfaPages.signInEmailKutusu.sendKeys(email);
        ReusableMethods.bekle(1);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();
        ReusableMethods.bekle(1);
    }

    @Test (priority = 2)
    public void loginPageLoadTest (){
        extentTest = extentReports.createTest("US22TC01PozitifLoginTesti",
                "Yönetici geçerli email ve password girerek login olabilmeli.");
        //Yönetici URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Yönetici URL ile siteye erişim sağlar");
        //Yönetici Sıgn ın sayfasına erişim sağlar.
        ReusableMethods.bekle(2);
        anasayfaPages.homepageSıgnInButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Yönetici Sıgn ın sayfasına erişim sağlar.");
        //Yönetici Sign in Formunu görüntüler.
        Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Yönetici Sign in Formunu görüntüler");
        //Yönetici email text box ını görünütler.
        Assert.assertTrue(anasayfaPages.signInEmailKutusu.isDisplayed());
        extentTest.pass("Yönetici email text box ını görünütler.");
        ReusableMethods.bekle(1);
        //Yönetici password text box ını görüntüler.
        Assert.assertTrue(anasayfaPages.signInPasswordKutusu.isDisplayed());
        extentTest.pass("Yönetici password text box ını görüntüler.");
        ReusableMethods.bekle(1);
        //Yönetici remember me checkbox ını görüntüler.
        Assert.assertTrue(anasayfaPages.signInRemembermeBox.isDisplayed());
        extentTest.pass("Yönetici remember me checkbox ını görüntüler.");
        ReusableMethods.bekle(1);
        //Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test (priority = 3)
    public void pozitifLoginTesti () {
        extentTest = extentReports.createTest("US22TC01PozitifLoginTesti",
                "Yönetici geçerli email ve password girerek login olabilmeli.");
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Yönetici URL ile siteye erişir");
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        extentTest.info("Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar");
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        Assert.assertTrue(anasayfaPages.signInEmailKutusu.isDisplayed());
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsumeyramail"));
        extentTest.pass("Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.");
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        Assert.assertTrue(anasayfaPages.signInPasswordKutusu.isDisplayed());
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        extentTest.pass("Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.");
        //Login tusuna basar ve kendi sayfasına erişim saglar.
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Login tusuna basar ve kendi sayfasına erişim saglar.");
        //Sıgn out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        ReusableMethods.bekle(2);
        adminPages.signOutButonu.click();
        extentTest.info("Sıgn out olur ve sayfayı kapatır.");

    }

    @Test (priority = 4)
    public void gecersizMailileLoginTesti () {
        extentTest = extentReports.createTest("US22TC01PozitifLoginTesti",
                "Yönetici geçersiz email ve geçerli password ile giriş yaptığında login olamamalı.");
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(1);
        extentTest.info("Yönetici URL ile siteye erişir");
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar");
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçersiz mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys("computer@gmail.com");
        ReusableMethods.bekle(1);
        extentTest.info("Sıgn ın sayfasında Email kutusuna geçersiz email girer.");
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        extentTest.info("Sıgn ın sayfasında  password kutusununa gecerli password girer.");
        //Login tusuna basar.
        anasayfaPages.signInLoginButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Login tusuna basar.");
        // Başarılı bir şekilde login olamadığını test edin.
        Assert.assertTrue(anasayfaPages.signInLoginButonu.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Başarılı bir şekilde login olamadığını test eder.");
        //sayfayı kapatır.
        extentTest.info("sayfayı kapatır.");
    }

    @Test (priority = 5)
    public void AdminGüvenliCikisIslemiTesti () {
        extentTest = extentReports.createTest("US22TC01PozitifLoginTesti",
                "Yönetici geçersiz email ve geçerli password ile giriş yaptığında login olamamalı.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Admin URL ile siteye erişir");


        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsedamail"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Kullanıcı giriş bilgilerini girer ve login olur.");


        // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağland

        adminPages.avatarDropdownMenuButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Kullanıcı avatar/isim alanındaki dahbord menüye  a tıklar.");
        adminPages.signOutButonu.click();
        ReusableMethods.bekle(1);
        extentTest.info("Dashbord menü deki \"Çıkış\" butonuna tıklar.");
        Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Sıgn ın sayfasına yönlendirildiğini doğrular.");
        //Sayfayı kapatır.
        extentTest.info("Sayfayı kapatır.");




    }

}

