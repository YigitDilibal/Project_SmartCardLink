package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class YigitUS36US37US39 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();
    UserPages userPages = new UserPages();


    // ========== US 36 ==========
    // Bir yönetici olarak Dashboard sayfamda sitedeki kayıtlı kullanıcıların kimliğine bürünerek
    // onlar adına işlem yapabilmek istiyorum.


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

    // US36 - Test Case 06
    // Impersonate modunda kullanıcı şifre değiştirme testi(negatif)

    @Test
    public void US36TC04ImpersonateModundaSifreDegistirmeTesti(){
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

        //Sağ üstteki profil adına tıklar.

        adminPages.avatarDropdownMenuButonu.click();

        //"Change Password" butonunun görüntülenmediğini test eder.

//  => ImplicitlyWait kaynakli 10 Saniye beklettigi icin yontem iptal.
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(0));
//        boolean elementYokmu = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("changePassword")));
//        Assert.assertTrue(elementYokmu);

//  => bu da 10 saniye bekletiyor
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
//        wait.pollingEvery(Duration.ofMillis(10));
//        wait.ignoring(NoSuchElementException.class);
//
//        boolean elementYokmu = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("changePassword")));
//        Assert.assertTrue(elementYokmu);

// change password icin element list olusturup isEmpty deyince yine implicitly waite takiliyor.
// implicitliyi gecici olarak sifirlayip islemden sonra eski hale getirecegim.

        Duration mevcutImplicitWait = Driver.getDriver().manage().timeouts().getImplicitWaitTimeout();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        Assert.assertTrue(userPages.changePasswordButonuListesi.isEmpty());

        Driver.getDriver().manage().timeouts().implicitlyWait(mevcutImplicitWait);


        //sign out olur ve sayfayı kapatır.
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // ================================================================================================


    // ========== US 37 ==========
    // Sınırsız özellikli kayıtlı kullanıcı olarak affilation menüsüne  ulaşabildiğimi,
    // toplam ve güncel tutarları görünütleyebilidğimi, davetiye gönderebildiğimi,
    // para çekme işlemi yapabildiğimi doğrulayabilmeliyim


    // US37 - Test Case 01
    // Affiliations sekmesine erişim testi

    @Test
    public void US37TC01AffiliationsSekmesineErisimTesti(){
        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //"Affiliations" sayfasının düzgün bir şekilde görüntülendiğini test eder.
        Assert.assertTrue(userPages.affiliationsSayfasiTitle.isDisplayed());

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US37 - Test Case 02
    // Toplam ve güncel bakiyeyi görüntüleme testi.

    @Test
    public void US37TC02ToplamVeGuncelBakiyeGoruntulemeTesti(){
        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        // Sayfada toplam ve güncel bakiyeyi kontrol eder.
        Assert.assertEquals(userPages.affiliationsSayfasiToplamVeGuncelBakiyeYazilariListesi.size(),2);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US37 - Test Case 03
    // Davet bağlantısını görüntüleme ve kopyalama testi.

    @Test
    public void US37TC03DavetBaglantisiTesti(){
        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //Davet bağlantısının görüntülendiğini kontrol eder.
        Assert.assertTrue(userPages.affiliationsSayfasiDavetBaglantisiElementi.isDisplayed());

        //"Copy" butonuna tıklar.
        userPages.affiliationsSayfasiDavetBaglantisiCopyButonu.click();

        //Bağlantının kopyalandığını doğrular
        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesaji.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }


    // US37 - Test Case 04
    // Davet Bağlantısı ile kayıt sayfasına yönlendirme testi.

    @Test
    public void US37TC04DavetBaglantisiIleKayitSayfasinaYonlendirmeTesti() throws IOException, UnsupportedFlavorException {
        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //"Copy" butonuna tıklar.
        userPages.affiliationsSayfasiDavetBaglantisiCopyButonu.click();

        // Kopyalanan bağlantıyı alır.
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String kopyalananBaglanti = (String) clipboard.getData(DataFlavor.stringFlavor);

        //Yeni bir gizli sekme açar ve bağlantıya gider.

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver gizliDriver = new ChromeDriver(options);

        gizliDriver.get(kopyalananBaglanti);

        //Acilan baglantinin kayit sayfasini actigini test eder.

        WebDriverWait wait = new WebDriverWait(gizliDriver, Duration.ofSeconds(10));
        WebElement kayitSayfasiTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Create an Account']")));

        Assert.assertTrue(kayitSayfasiTitle.isDisplayed());

        // driverleri kapatir.

        gizliDriver.quit();
        Driver.quitDriver();

    }








}
