package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup(){
      anasayfaPages = new AnasayfaPages();
      adminPages = new AdminPages();
      userPages = new UserPages();
    }


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
    public void US36TC06ImpersonateModundaSifreDegistirmeTesti(){

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

    // US37 - Test Case 05
    // E-posta davet maili testi.

    @Test
    public void US37TC05EpostaDavetMailiTesti() {

        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //"Send Invite" butonuna tıklar.
        userPages.affiliationsSayfasiSendInviteButonu.click();

        //Kullanıcı geçerli bir e-posta adresi girer.
        userPages.affiliationsSayfasiSendInviteBolumuEmailKutusu.sendKeys("archery10@outlook.com");
        ReusableMethods.bekle(1);

        //"Send Email" butonuna tıklar.
        userPages.affiliationsSayfasiSendInviteBolumuSubmitButonu.click();

        //Mailin gönderildiğine dair bir onay mesajı gösterildigini test eder.
        //sayfanin yapisinda onay mesaji olmadigi icin farkli bir onay mesaji locate'ini kullaniyorum.
        Duration mevcutImplicitWait = Driver.getDriver().manage().timeouts().getImplicitWaitTimeout();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        SoftAssert softAssert = new SoftAssert();

        try {
            softAssert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesaji.isDisplayed(),"Davet maili onay mesaji cikmadi");
        } catch (Exception e) {
            softAssert.fail("Davet maili onay mesaji cikmadi");
        }

        Driver.getDriver().manage().timeouts().implicitlyWait(mevcutImplicitWait);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();

        try {
            softAssert.assertAll();
        } finally {
            Driver.quitDriver();
        }
    }

    // US37 - Test Case 06
    // Geçersiz E-posta adresi ile davet maili testi.

    @Test
    public void US37TC06GecersizMailIleDavetTesti(){

        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //"Send Invite" butonuna tıklar.
        userPages.affiliationsSayfasiSendInviteButonu.click();

        //Kullanıcı geçersiz bir e-posta adresi girer.
        userPages.affiliationsSayfasiSendInviteBolumuEmailKutusu.sendKeys("asdasdasd");

        //"Send Email" butonuna tıklar.
        userPages.affiliationsSayfasiSendInviteBolumuSubmitButonu.click();

        //Geçersiz adres girildiğinde mail gitmediğini doğrular.
        Assert.assertTrue(userPages.affiliationsSayfasiSendInviteBolumuCloseButonu.isDisplayed());

        //Close tusuna basip kapatir
        ReusableMethods.bekle(1);
        userPages.affiliationsSayfasiSendInviteBolumuCloseButonu.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US37 - Test Case 07
    // Davet ile kaydolan kullanıcının panelde görünmesi testi.

    @Test
    public void US37TC07KaydolanKullanicininPaneldeGorunmesiTesti(){

        Faker faker = new Faker();

        //Davet edilen kullanıcı kayıt olur.

        Driver.getDriver().get(ConfigReader.getProperty("yigitDavetBaglantisi"));

        userPages.newVcardSayfasiFirstNameKutusu.sendKeys(faker.name().firstName());
        userPages.newVcardSayfasiLastNameKutusu.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        userPages.affiliationsSayfasiSendInviteBolumuEmailKutusu.sendKeys(email);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.kayitSayfasiConfirmPassword.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.kayitSayfasiTermsAndConditions.click();
        anasayfaPages.signInLoginButonu.click();

        // giris yapar

        anasayfaPages.signInEmailKutusu.sendKeys(email);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        // abonelik satin alir ve odeme yapar

        userPages.avatarDropdownMenuButonu.click();
        userPages.userDropdownMenuManageSubscription.click();
        userPages.userSubscriptionUpgradeButton.click();
        userPages.manageSubscriptionUnlimitedSekmesi.click();
        userPages.unlimitedPlanSwitchPlanButonu.click();
        userPages.userSubscriptionSelectPaymentDdwButton.click();
        userPages.userSubscriptionDropdownStripeButton.click();
        userPages.paySwitchPlanButton.click();

        userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("validCardNumber"));
        userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
        userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
        userPages.cardHolderNameInput.sendKeys(faker.name().fullName());
        userPages.userSubscriptionPayButton.click();

        userPages.backToSubscriptionButton.click();

        // çıkış yapar.-- Davet eden kullanıcı login sayfasına gider.

        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.

        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();


        //Dashboard'da "Affiliations" sekmesine tıklar.

        userPages.solPanelAffiliationsButonu.click();

        //Panelde davet edilen kullanıcının listelendiğini kontrol eder.
        String xPath= "//*[.='"+email+"']";
        WebElement referredUser = Driver.getDriver().findElement(By.xpath(xPath));

        Assert.assertTrue(referredUser.isDisplayed());

        //sign out olur ve sayfaları kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }


    // US37 - Test Case 08
    // Geçersiz E-posta adresi ile davet maili testi.

    @Test
    public void US37TC08AffilationCekimIslemiTesti(){

        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //Kullanıcı "Withdrawal" sekmesine tıklar.
        userPages.affilationsWithdrawalTab.click();

        //Kullanıcı "Withdraw Amount" butonuna tıklar.
        userPages.affilationsWithdrawAmountButton.click();

        //Çekmek istediği tutarı güncel bakiyeden düşük veya eşit olarak girer.
        userPages.withdrawAmountKutusu.sendKeys("10");

        //Sistemde kayıtlı olan Paypal e-posta adresini girer.
        userPages.withdrawPaypalEmailKutusu.sendKeys(ConfigReader.getProperty("yigitPaypal"));

        //"Save" butonuna tıklar.
        ReusableMethods.bekle(1);
        userPages.withdrawSaveButton.click();
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //Yönetici çekim talebini onaylar.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();


        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        adminPages.affilationTransactionsSekmesi.click();

        adminPages.approvalStatusList.get(0).click();
        adminPages.approveWithdrawalButton.click();
        ReusableMethods.bekle(1);
        adminPages.approveWithdrawalSaveButton.click();

        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();

        //User Para çekme işleminin başarıyla tamamlandığını test eder.

        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        userPages.solPanelAffiliationsButonu.click();
        userPages.affilationsWithdrawalTab.click();

        adminPages.withdrawalSayfasiViewButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        String actual = adminPages.withdrawalIsApproved.getText();
        String expected = "Approved";

        Assert.assertEquals(actual,expected);

        adminPages.withdrawalViewCloseButton.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US37 - Test Case 09
    // Affiliation sayfasında çekim işlemi testi.(negatif)

    @Test
    public void US37TC09NegatifCekimTesti(){

        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.

        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //Kullanıcı "Withdrawal" butonuna tıklar.
        userPages.affilationsWithdrawalTab.click();

        //Kullanıcı "Withdraw Amount" butonuna tıklar.
        userPages.affilationsWithdrawAmountButton.click();

        //Çekmek istediği tutarı güncel bakiyeden daha yüksek girer.
        userPages.withdrawAmountKutusu.sendKeys("1000");

        //Sistemde kayıtlı olan Paypal e-posta adresini girer.
        userPages.withdrawPaypalEmailKutusu.sendKeys(ConfigReader.getProperty("yigitPaypal"));

        //"Save" butonuna tıklar ve çekim talebi oluşmadığını test eder.
        ReusableMethods.bekle(1);
        userPages.withdrawSaveButton.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //"Amount" kutusundaki bakiyeyi güncel bakiyeden düşük veya eşit hale getirir.
        userPages.withdrawAmountKutusu.clear();
        userPages.withdrawAmountKutusu.sendKeys("10");

        //Sistemde kayıtlı olmayan bir Paypal e-posta adresi girer.
        userPages.withdrawPaypalEmailKutusu.clear();
        userPages.withdrawPaypalEmailKutusu.sendKeys("yigitdilibal@outlook.com");

        //"Save" butonuna tıklar ve çekim talebi oluşmadığını test eder.
        ReusableMethods.bekle(1);
        userPages.withdrawSaveButton.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        // Withdraw Amount penceresini kapatir

        ReusableMethods.bekle(1);
        userPages.withdrawAmountPenceresiCancelButton.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US37 - Test Case 10
    // Onaylanan ve reddedilen çekim taleplerini görüntüleme testi.

    @Test
    public void US37TC10GecmisCekimTalepleriniGoruntulemeTesti(){

        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'da "Affiliations" sekmesine tıklar.
        userPages.solPanelAffiliationsButonu.click();

        //Kullanıcı "Withdrawal" butonuna tıklar.
        userPages.affilationsWithdrawalTab.click();

        //Kullanıcı geçmişte gönderdiği çekim taleplerinin görüntülenebildiğini test eder.
        Assert.assertFalse(adminPages.withdrawalSayfasiViewButonlariList.isEmpty());

        //Çekim işleminin yanındaki "View" butonuna tıklar.
        adminPages.withdrawalSayfasiViewButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //Kullanıcı çekim işlemindeki detayların doğru bir şekilde görüntülenebildiğini test eder.

        String actual = adminPages.withdrawalIsApproved.getText();
        String expected = "Approved";

        Assert.assertEquals(actual,expected);

        adminPages.withdrawalViewCloseButton.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }


    // ================================================================================================


    // ========== US 39 ==========
    // Bir yönetici olarak giriş yaptıktan sonra
    // sitede işlemlerde kullanılan ülke, eyalet, şehir sayılarını görüntüleyebildiğimi
    // ve yeni ülke, eyalet, şehir ekleyebildiğimi doğrulayabilmeliyim


    // US39 - Test Case 01
    // Yönetim panelinde "Countries" sekmesine erişim ve sekmeler arası geçiş testi.

    @Test
    public void US39TC01CountriesSayfasiSekmelerArasiGecisTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar ve erişilebildiğini test eder.
        adminPages.anasayfaCountriesButonu.click();

        String expectedLink = "https://qa.smartcardlink.com/sadmin/countries";
        String actualLink = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualLink,expectedLink);

        //"States" sekmesine tıklar ve erişilebildiğini test eder.
        ReusableMethods.bekle(1);
        adminPages.countriesSayfasiStatesButonu.click();

        expectedLink = "https://qa.smartcardlink.com/sadmin/states";
        actualLink = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualLink,expectedLink);

        //"Cities" sekmesine tıklar ve erişilebildiğini test eder.
        ReusableMethods.bekle(1);
        adminPages.countriesSayfasiCitiesButonu.click();

        expectedLink = "https://qa.smartcardlink.com/sadmin/cities";
        actualLink = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualLink,expectedLink);
        ReusableMethods.bekle(1);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US39 - Test Case 02
    // Countries sayfasında arama fonksiyonu testi.

    @Test
    public void US39TC02CountriesSayfasiAramaTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar.
        adminPages.anasayfaCountriesButonu.click();

        //Arama kutusuna bir ülke ismi yazar ve uygun sonuçlar listelendiğini test eder.
        adminPages.countriesSayfasiSearchKutusu.sendKeys("Yiğitistan");
        ReusableMethods.bekle(1);
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),1);

        //"States" sekmesine tıklar.
        adminPages.countriesSayfasiStatesButonu.click();
        ReusableMethods.bekle(1);

        //Arama kutusuna bir eyalet ismi yazar ve uygun sonuçlar listelendiğini test eder.
        adminPages.countriesSayfasiSearchKutusu.sendKeys("Yiğitiye");
        ReusableMethods.bekle(1);
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),1);

        //"Cities" sekmesine tıklar.
        adminPages.countriesSayfasiCitiesButonu.click();
        ReusableMethods.bekle(1);

        //Arama kutusuna bir şehir ismi yazar ve uygun sonuçlar listelendiğini test eder.
        adminPages.countriesSayfasiSearchKutusu.sendKeys("Yiğitçeşme");
        ReusableMethods.bekle(1);

        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),1);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US39 - Test Case 03
    // Countries sayfasında öğe ekleme testi.

    @Test
    public void US39TC03CountriesSayfasindaOgeEklemeTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar.
        adminPages.anasayfaCountriesButonu.click();

        //"New Country" butonuna tıklar.
        adminPages.countriesSayfasiYeniBolgeButonu.click();

        //"Name" kutusunu doldurur.
        adminPages.newCountryNameKutusu.sendKeys("TestUlke");

        //"Short Code" kutusunu doldurur.
        adminPages.newCountryShortCodeKutusu.sendKeys("TU");

        //"Phone Code" kutusunu doldurur.
        adminPages.newCountryPhoneCodeKutusu.sendKeys("0008");

        //Save butonuna tıklar ve ulkenin kaydedildigini test eder.
        adminPages.newCountrySaveButonu.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //"States" sekmesine tıklar.
        adminPages.countriesSayfasiStatesButonu.click();
        ReusableMethods.bekle(1);

        //"New State" butonuna tıklar.
        adminPages.countriesSayfasiYeniBolgeButonu.click();

        //"Name" kutusunu doldurur.
        adminPages.newStateNameKutusu.sendKeys("TestEyalet");

        //"Country Name" kutusunda seçim yapar.
        Select selectUlke = new Select(adminPages.newStateDdmMenu);
        selectUlke.selectByVisibleText("TestUlke");

        //Save butonuna tıklar ve eyaletin kaydedildigini test eder.
        adminPages.newCountrySaveButonu.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //"Cities" sekmesine tıklar.
        adminPages.countriesSayfasiCitiesButonu.click();
        ReusableMethods.bekle(1);

        //"New City" butonuna tıklar.
        adminPages.countriesSayfasiYeniBolgeButonu.click();

        //"Name" kutusunu doldurur.
        adminPages.newStateNameKutusu.sendKeys("TestSehir");

        //"State Name" kutusunda seçim yapar.
        Select selectState = new Select(adminPages.newCityDdmMenu);
        selectState.selectByVisibleText("TestEyalet");

        //Save butonuna tıklar ve sehrin kaydedildigini test eder.
        adminPages.newCountrySaveButonu.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }


    // US39 - Test Case 04
    // Countries sayfasında listeden bir öğenin düzenlenip kaydedilmesi testi.

    @Test
    public void US39TC04CountriesSayfasindaDuzenlemeTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar.
        adminPages.anasayfaCountriesButonu.click();

        //listede arama yapar
        adminPages.countriesSayfasiSearchKutusu.sendKeys("TestUlke");
        ReusableMethods.bekle(1);

        //Arama sonucunda çıkan ülkenin yanındaki düzenleme butonuna tıklar.
        adminPages.countriesSayfasiEditButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //"Name" kutusunu düzenler.
        adminPages.editCountryNameKutusu.clear();
        adminPages.editCountryNameKutusu.sendKeys("TestUlke2");

        //"Short Code" kutusunu düzenler.
        adminPages.editCountryShortCodeKutusu.clear();
        adminPages.editCountryShortCodeKutusu.sendKeys("PP");

        //"Phone Code" kutusunu düzenler.
        adminPages.editCountryPhoneCodeKutusu.clear();
        adminPages.editCountryPhoneCodeKutusu.sendKeys("0007");

        //Save butonuna tıklar ve değişikliklerin kaydedildigini test eder.
        adminPages.editCountryCitySaveButonu.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //"States" sekmesine tıklar.
        adminPages.countriesSayfasiStatesButonu.click();
        ReusableMethods.bekle(1);

        //listede arama yapar
        adminPages.countriesSayfasiSearchKutusu.sendKeys("TestEyalet");
        ReusableMethods.bekle(1);

        //Arama sonucunda çıkan eyaletin yanındaki düzenleme butonuna tıklar.
        adminPages.countriesSayfasiEditButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //"Name" kutusunu düzenler.
        adminPages.editCountryNameKutusu.clear();
        adminPages.editCountryNameKutusu.sendKeys("TestEyalet2");

        //"Country Name" kutusunda seçim yapar.
        Select selectUlke = new Select(adminPages.editStateDdmMenu);
        selectUlke.selectByVisibleText("Yiğitistan");

        //Save butonuna tıklar ve değişikliklerin kaydedildigini test eder.
        adminPages.editCountryCitySaveButonu.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //"Cities" sekmesine tıklar.
        adminPages.countriesSayfasiCitiesButonu.click();
        ReusableMethods.bekle(1);

        //listede arama yapar
        adminPages.countriesSayfasiSearchKutusu.sendKeys("TestSehir");
        ReusableMethods.bekle(1);

        //Arama sonucunda çıkan şehrin yanındaki düzenleme butonuna tıklar.
        adminPages.countriesSayfasiEditButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //"Name" kutusunu düzenler.
        adminPages.editCountryNameKutusu.clear();
        adminPages.editCountryNameKutusu.sendKeys("TestSehir2");

        //"State Name" kutusunda seçim yapar.
        Select selectState = new Select(adminPages.editCityDdmMenu);
        selectState.selectByVisibleText("Yiğitiye");

        //Save butonuna tıklar ve değişikliklerin kaydedildigini test eder.
        adminPages.editCountryCitySaveButonu.click();

        Assert.assertTrue(userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.isDisplayed());
        userPages.affiliationsSayfasiDavetKopyalandiOnayMesajiKapatmaButonu.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US39 - Test Case 05
    // Countries sayfasında listeden öğe silme testi.

    @Test
    public void US39TC05CountriesSayfasindaSilmeTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar.
        adminPages.anasayfaCountriesButonu.click();

        //listede arama yapar
        adminPages.countriesSayfasiSearchKutusu.sendKeys("TestUlke2");
        ReusableMethods.bekle(1);

        //Arama sonucunda çıkan ülkenin yanındaki silme butonuna tıklar.
        adminPages.countriesSayfasiDeleteButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //Yes Delete butonuna tıklar ve silindiğini test eder.
        adminPages.countriesSayfasiYesDeleteButonu.click();

        Assert.assertTrue(adminPages.adminPlansDeletePopupOkButonu.isDisplayed());
        adminPages.adminPlansDeletePopupOkButonu.click();

        //"States" sekmesine tıklar.
        adminPages.countriesSayfasiStatesButonu.click();
        ReusableMethods.bekle(1);

        //listede arama yapar
        adminPages.countriesSayfasiSearchKutusu.sendKeys("TestEyalet2");
        ReusableMethods.bekle(1);

        //Arama sonucunda çıkan eyaletin yanındaki silme butonuna tıklar.
        adminPages.countriesSayfasiDeleteButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //Yes Delete butonuna tıklar ve silindiğini test eder.
        adminPages.countriesSayfasiYesDeleteButonu.click();

        Assert.assertTrue(adminPages.adminPlansDeletePopupOkButonu.isDisplayed());
        adminPages.adminPlansDeletePopupOkButonu.click();

        //"Cities" sekmesine tıklar.
        adminPages.countriesSayfasiCitiesButonu.click();
        ReusableMethods.bekle(1);

        //listede arama yapar
        adminPages.countriesSayfasiSearchKutusu.sendKeys("TestSehir2");
        ReusableMethods.bekle(1);

        //Arama sonucunda çıkan şehrin yanındaki silme butonuna tıklar.
        adminPages.countriesSayfasiDeleteButonlariList.get(0).click();
        ReusableMethods.bekle(1);

        //Yes Delete butonuna tıklar ve silindiğini test eder.
        adminPages.countriesSayfasiYesDeleteButonu.click();

        Assert.assertTrue(adminPages.adminPlansDeletePopupOkButonu.isDisplayed());
        adminPages.adminPlansDeletePopupOkButonu.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }


    // US39 - Test Case 06
    // Countries sayfasında liste görüntüleme ve sayfalandırma testi.

    @Test
    public void US39TC05CountriesSayfasiListeGoruntulemeTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar.
        adminPages.anasayfaCountriesButonu.click();

        //Listede 10 öğe görüntülendiğini test eder.
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),10);

        //2. sayfaya geçmek için "2" butonuna tıklar.

        JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",adminPages.ikinciSayfayaGecmeButonu);
        ReusableMethods.bekle(1);

        adminPages.ikinciSayfayaGecmeButonu.click();

        //"Show" dropdown menüsünde "25" seçeneğini seçer.
        Select selectOge = new Select(adminPages.sayfadakiOgeSayisiBelirlemeDdm);
        selectOge.selectByVisibleText("25");
        ReusableMethods.bekle(1);

        //Listede 25 öğe görüntülendiğini test eder.
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),25);

        //"States" sekmesine tıklar.
        adminPages.countriesSayfasiStatesButonu.click();
        ReusableMethods.bekle(1);

        //Listede 10 öğe görüntülendiğini test eder.
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),10);

        //2. sayfaya geçmek için "2" butonuna tıklar.

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",adminPages.ikinciSayfayaGecmeButonu);
        ReusableMethods.bekle(1);

        adminPages.ikinciSayfayaGecmeButonu.click();

        //"Show" dropdown menüsünde "50" seçeneğini seçer.
        Select selectOge2 = new Select(adminPages.sayfadakiOgeSayisiBelirlemeDdm);
        selectOge2.selectByVisibleText("50");
        ReusableMethods.bekle(1);

        //Listede 50 öğe görüntülendiğini test eder.
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),50);

        //"Cities" sekmesine tıklar.
        adminPages.countriesSayfasiCitiesButonu.click();
        ReusableMethods.bekle(1);

        //Listede 10 öğe görüntülendiğini test eder.
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),10);

        //2. sayfaya geçmek için "2" butonuna tıklar.

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",adminPages.ikinciSayfayaGecmeButonu);
        ReusableMethods.bekle(1);

        adminPages.ikinciSayfayaGecmeButonu.click();

        //"Show" dropdown menüsünde "50" seçeneğini seçer.
        Select selectOge3 = new Select(adminPages.sayfadakiOgeSayisiBelirlemeDdm);
        selectOge3.selectByVisibleText("50");
        ReusableMethods.bekle(1);

        //Listede 50 öğe görüntülendiğini test eder.
        Assert.assertEquals(adminPages.countriesSayfasiEditButonlariList.size(),50);

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US39 - Test Case 07
    // Countries sayfası yetkisiz kullanıcının sayfaya erişimi testi (negatif)

    @Test
    public void US39TC07CountriesSayfasiYetkisizErisimTesti(){

        //Kullanici login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();

        //Kullanıcı Countries sayfasının URL'ine gitmeyi dener.
        Driver.getDriver().get("https://qa.smartcardlink.com/sadmin/countries");
        ReusableMethods.bekle(1);

        // User does not have the right roles. hatasinin alindigini test eder.
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forbidden";

        Assert.assertEquals(actualTitle,expectedTitle);

        //Tarayıcıda geri tuşuna tıklar.
        Driver.getDriver().navigate().back();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }

    // US39 - Test Case 08
    // Countries sayfası geçersiz bilgilerle öğe oluşturma testi. (negatif)

    @Test
    public void US39TC08CountriesSayfasindaGecersizBilgilerleOgeOlusturmaTesti(){

        //Admin login sayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();

        //Super admin giriş bilgilerini girer ve logine basar.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        //Dashboard'daki "Countries" sekmesine tıklar.
        adminPages.anasayfaCountriesButonu.click();

        //"New Country" butonuna tıklar.
        adminPages.countriesSayfasiYeniBolgeButonu.click();

        //"Name" kutusunu boş bırakır.
        adminPages.newCountryNameKutusu.sendKeys("");

        //"Short Code" kutusuna sayı girmeyi dener.
        adminPages.newCountryShortCodeKutusu.sendKeys("55");

        //"Phone Code" kutusuna harf girmeyi dener.
        adminPages.newCountryPhoneCodeKutusu.sendKeys("ABC");

        //Save butonuna tıklar ve ulkenin oluşturulmadığını test eder.
        adminPages.newCountrySaveButonu.click();
        ReusableMethods.bekle(1);

        Assert.assertTrue(adminPages.newCountrySaveButonu.isDisplayed());

        //"Discard" butonuna tıklar.
        adminPages.newCountryDiscardButton.click();

        //"States" sekmesine tıklar.
        adminPages.countriesSayfasiStatesButonu.click();
        ReusableMethods.bekle(1);

        //"New State" butonuna tıklar.
        adminPages.countriesSayfasiYeniBolgeButonu.click();

        //"Name" kutusunu boş bırakır.
        adminPages.newStateNameKutusu.sendKeys("");

        //"Country Name" kutusunda seçim yapar.
        Select selectUlke = new Select(adminPages.newStateDdmMenu);
        selectUlke.selectByVisibleText("Afghanistan");

        //Save butonuna tıklar ve eyaletin kaydedilmedigini test eder.
        adminPages.newCountrySaveButonu.click();
        ReusableMethods.bekle(1);

        Assert.assertTrue(adminPages.newCountrySaveButonu.isDisplayed());

        //"Name" kutusunu doldurur.
        adminPages.newStateNameKutusu.sendKeys("TestEyalet1515");

        //"Country Name" kutusunda Select Country secer.
        selectUlke.selectByVisibleText("Select Country");

        //Save butonuna tıklar ve eyaletin kaydedilmedigini test eder.
        adminPages.newCountrySaveButonu.click();
        ReusableMethods.bekle(1);

        Assert.assertTrue(adminPages.newCountrySaveButonu.isDisplayed());

        //"Discard" butonuna tıklar.
        adminPages.newCountryDiscardButton.click();

        //"Cities" sekmesine tıklar.
        adminPages.countriesSayfasiCitiesButonu.click();
        ReusableMethods.bekle(1);

        //"New City" butonuna tıklar.
        adminPages.countriesSayfasiYeniBolgeButonu.click();

        //"Name" kutusunu bos birakir.
        adminPages.newStateNameKutusu.sendKeys("");

        //"State Name" kutusunda seçim yapar.
        Select selectState = new Select(adminPages.newCityDdmMenu);
        selectState.selectByVisibleText("A Coruna");

        //Save butonuna tıklar ve sehrin kaydedilmedigini test eder.
        adminPages.newCountrySaveButonu.click();
        ReusableMethods.bekle(1);

        Assert.assertTrue(adminPages.newCountrySaveButonu.isDisplayed());

        //"Name" kutusunu doldurur.
        adminPages.newStateNameKutusu.sendKeys("TestSehir1515");

        //"State Name" kutusunda Select State secer.
        selectState.selectByVisibleText("Select State");

        //Save butonuna tıklar ve sehrin kaydedilmedigini test eder.
        adminPages.newCountrySaveButonu.click();
        ReusableMethods.bekle(1);

        Assert.assertTrue(adminPages.newCountrySaveButonu.isDisplayed());

        //"Discard" butonuna tıklar.
        adminPages.newCountryDiscardButton.click();

        //sign out olur ve sayfayı kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        Driver.quitDriver();
    }



    // US36, US37, US39 ALL DONE. :D











}
