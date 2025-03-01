package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

import java.time.Duration;

public class SumeyraUS19US21US22 extends TestBaseRapor {

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
        @Test
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
    @Test
    public void gecersizPasswordileLoginTesti () {
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklayın ve  Sıgn ın sayfasına erişim sağlayın
        ReusableMethods.bekle(2);
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsumeyramail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecersiz password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys("Smart.1203");
        //Login tusuna basarak login olmayı deneyin
        anasayfaPages.signInLoginButonu.click();
        // Başarılı bir şekilde login olamadığını test edin.
        Assert.assertTrue(anasayfaPages.signInLoginButonu.isDisplayed());
        //sayfayı kapatın.
        Driver.quitDriver();
    }

    @Test
    public void manditoryFieldTest(){
        //Yönetici URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        //Yönetici Sıgn ın linkini görüntüler ve Sıgn ın sayfasına erişim sağlar.
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun boş bırakır.
        anasayfaPages.signInEmailKutusu.sendKeys((""));
        //Sıgn ın sayfasında password kutusunun boş bırakır.
        anasayfaPages.signInPasswordKutusu.sendKeys("");
        //Login tusuna basar ve login olamadığını doğrular.
        anasayfaPages.signInLoginButonu.click();
        Assert.assertTrue(anasayfaPages.signInLoginButonu.isDisplayed());
        //Sayfayı kapatır.
        Driver.quitDriver();
    }
    @Test
    public void bieyeFillTest (){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsumeyramail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        //Bi-eye-fill ikonuna tıklamadan önce şifresinin maskelenmiş olarak  (••••••••) gösterildiğini doğrular.
        Assert.assertTrue(anasayfaPages.signInBieyeSlashFillpasswordHide.isEnabled());
        //Bi-eye-fill ikonuna tıkladıktan sonra ve be-eye-fill ikonun değiştiğini doğrular şifresini görüntüler.
        anasayfaPages.signInBieyeSlashFillpasswordHide.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(anasayfaPages.signInBieyeSlashFillpasswordShow.isEnabled());
        //Sayfayı kapatır.
        Driver.quitDriver();
    }
    @Test
    public void notAnAdminUserSıgnınTest (){  // NEGATİVE TEST
        extentTest = extentReports.createTest("notAnAdminUserSıgnınTest",
                "Admin olmayan bir Kullanıcının yanlızca kendi sayfasına erişebilmesi");
        //Yönetici URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Kullanici SmartcardLink anasayfasina gider");
        //Yönetici Sıgn ın sayfasına erişim sağlar.
        anasayfaPages.homepageSıgnInButonu.click();
        extentTest.info("Signin linkine basar");
        //Sıgn ın sayfasında Email kutusuna geçersiz mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");
        //Sıgn ın sayfasında password kutusununa gecersiz password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");
        //Login tusuna basar ve yönetici sayfasında olmayan enguires butonunu görüntülediğini doğrular.
        anasayfaPages.signInLoginButonu.click();
        Assert.assertTrue(userPages.dahbordPanelEnguiriesButonu.isDisplayed());
        extentTest.pass("Login tusuna basar ve yönetici sayfasında olmayan enguires butonunu görüntülediğini doğrular.");
        //Sıgnout olur ve Sayfayı kapatır.
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        extentTest.info("Sıgnout olur ve Sayfayı kapatır");

    }
    @Test
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
    // US- 21 Bir kullanıcı olarak Dashboard sayfamdan güvenli bir şekilde çıkış yapabilmek istiyorum. TC-01
    @Test
    public void pozitifLogoutTesti() {
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı giriş bilgilerini girer ve login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı avatar/isim alanındaki dahbord menüye  a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord menü deki "Çıkış" butonuna tıklar.
        userPages.signOutButonu.click();
        //Sıgn ın sayfasına yönlendirilir
        Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
        //Sayfayı kapatır.
        Driver.quitDriver();
    }
    // US- 21 Bir kullanıcı olarak Dashboard sayfamdan güvenli bir şekilde çıkış yapabilmek istiyorum. TC-02
    @Test
    public void F5tuşuLogoutTesti (){
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı giriş bilgilerini girer ve login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı F5 tuşuna basar ve sayfayı yeniler.
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.F5).perform();
        //Kullanıcı çıkış yapmadığını doğrular.
        Assert.assertTrue(userPages.avatarDropdownMenuButonu.isDisplayed());
        //Sayfayı kapatır.
        Driver.quitDriver();
    }

    // US- 21 Bir kullanıcı olarak Dashboard sayfamdan güvenli bir şekilde çıkış yapabilmek istiyorum. TC-04
    @Test
    public void afterLogoutDirectedtoLoginPageTest () {

        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı giriş bilgilerini girer ve login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı avatar/isim alanındaki dahbord menüye  a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord menü deki "Çıkış" butonuna tıklar.
        userPages.signOutButonu.click();
        //Kullanıcı başarılı bir şekilde ogin sayfasına yönlendirilir.
        String expectedURL = "https://qa.smartcardlink.com/login";
        String actualUrl = Driver.driver.getCurrentUrl();
        Assert.assertTrue(expectedURL.contains(actualUrl));
        //Sayfayı kapatır.
        Driver.quitDriver();
    }
    // US- 21 Bir kullanıcı olarak Dashboard sayfamdan güvenli bir şekilde çıkış yapabilmek istiyorum. TC-05
    @Test
    public void logoutButtonVisibilityTest () {
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı giriş bilgilerini girer ve login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı avatar/isim alanındaki dahbord menüye  a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord menü deki "Çıkış" butonunun görünür olduğunu doğrular.
        Assert.assertTrue(userPages.signOutButonu.isDisplayed());
        // Sıgnout olur ve sayfayı kapatır
        userPages.signOutButonu.click();
        Driver.quitDriver();
    }
    // US-19 TC-02 Negative Password Change Test (shorter than 8 characters)
    @Test
    public void negativePasswordChangeTestShorterThan8Characters (){ // NEGATIVE TEST
        extentTest = extentReports.createTest("Negative Password Change Test (shorter than 8 characters)",
                "Kullanıcı yeni şifre olarak 8 karakterden kısa bir şifre ile yeni şifre oluşturamamalı. ");
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Kullanici SmartcardLink anasayfasina gider");
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        extentTest.info("Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar");
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Kullanıcı geçerli bilgiler ile login olur.");
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        extentTest.info("Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.");
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        extentTest.info("Dashbord daki Şifre Değişim butonuna tıklar.");
        //Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.");
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecersiz New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("Sma.12");
        extentTest.info("Şifre değişim formunda New Password textbox a gecersiz New Password girer.");
        //Şifre değişim formunda Confirm Password gecersiz Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("Sma.12");
        extentTest.info("Şifre değişim formunda Confirm Password gecersiz Confirm Password girer.");
        //Save butonuna tıklar.
        userPages.parolaDegiştirmeFormuSaveButonu.click();
        extentTest.info("Save butonuna tıklar");
        //Başarılı bir şekilde ilgili uyarı mesajının geldiğini doğrular.
        WebDriverWait wait = new WebDriverWait(Driver.driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userPages.parolaDeğişimMesajı));
        String expectedParolaDegişimMesajı = "The new password must be at least 8 characters.";
        String actualParolaDegişimMesajı = userPages.parolaDeğişimMesajı.getText();
        Assert.assertTrue(actualParolaDegişimMesajı.contains(expectedParolaDegişimMesajı));
        extentTest.pass("Başarılı bir şekilde ilgili uyarı mesajının geldiğini doğrular ve şifre değişimi yapamaz.");
        userPages.parolaDeğişimFormuKapatmaXbutonu.click();
        ReusableMethods.bekle(6);
        // wait.until(ExpectedConditions.elementToBeClickable(userPages.avatarDropdownMenuButonu));
        // bu komut çalışmadı ?

        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        extentTest.info("Sıgn out olur ve sayfayı kapatır.");

    }
    // US-19 TC-09 Nice to Have - Negative Password Change Test (case sensitivity)
    @Test
    public void NicetoHaveNegativePasswordChangeTestCaseSensitivity (){
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecersiz New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("SMARTCARD.1202");
        //Şifre değişim formunda Confirm Password gecersiz Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("smartcard.1202");
        //Save butonuna tıkladığında ilgili uyarı mesajın geldiğini doğrular
        userPages.parolaDegiştirmeFormuSaveButonu.click();
        //Başarılı bir şekilde şifre değişim işlemini yapamadığını doğrular.
        WebDriverWait wait = new WebDriverWait(Driver.driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userPages.parolaDeğişimMesajı));
        String expectedParolaDegişimMesajı = "The new password and confirm password must match.";
        String actualParolaDegişimMesajı = userPages.parolaDeğişimMesajı.getText();
        Assert.assertTrue(actualParolaDegişimMesajı.contains(expectedParolaDegişimMesajı));
        userPages.parolaDeğişimFormuKapatmaXbutonu.click();
        ReusableMethods.bekle(6);
        // wait.until(ExpectedConditions.elementToBeClickable(userPages.avatarDropdownMenuButonu));
        // bu komut çalışmadı ?

        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();

    }
    // US-19 TC-10 Negative Password Change Test (password mismatch )
    @Test
    public void NegativePasswordChangeTestPasswordMismatch (){
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecersiz New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("Smart.card1202");
        //Şifre değişim formunda Confirm Password gecersiz Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("Smart.card1302");
        //Save butonuna tıkladığında ilgili uyarı mesajın geldiğini doğrular
        userPages.parolaDegiştirmeFormuSaveButonu.click();
        //Başarılı bir şekilde şifre değişim işlemini yapamadığını doğrular.
        WebDriverWait wait = new WebDriverWait(Driver.driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userPages.parolaDeğişimMesajı));
        String expectedParolaDegişimMesajı = "The new password and confirm password must match.";
        String actualParolaDegişimMesajı = userPages.parolaDeğişimMesajı.getText();
        Assert.assertTrue(actualParolaDegişimMesajı.contains(expectedParolaDegişimMesajı));
        userPages.parolaDeğişimFormuKapatmaXbutonu.click();
        ReusableMethods.bekle(6);
        // wait.until(ExpectedConditions.elementToBeClickable(userPages.avatarDropdownMenuButonu));
        // bu komut çalışmadı ?

        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();
    }
    // US-19 TC-11 Discard Button Funcionality Test
    @Test
    public void DiscardButtonFuncionalityTest () {
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecerli New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("Smartcard.12");
        //Şifre değişim formunda Confirm Password gecerli Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("Smartcard.12");
        //Başarılı bir şekilde Discard butona erişebilir olduğunu doğrular ve discard butonuna tıklar, şifre değişim işlemini iptal eder.
        Assert.assertTrue(userPages.parolaDegiştirmeFormuDiscardButonu.isEnabled());
        userPages.parolaDegiştirmeFormuDiscardButonu.click();
        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();
    }
    // US-19 TC-012 Negative Password Change Test (empty manditory field validation)
    @Test
    public void NegativePasswordChangeTestEmptyManditoryFieldValidation (){

        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox ı boş bırakır.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys("");
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox ı boş bırakır.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("");
        //Şifre değişim formunda Confirm Password textbox ı boş bırakır
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("");
        //Save butonuna tıklar ve hata mesajının geldiğini doğrular.
        userPages.parolaDegiştirmeFormuSaveButonu.click();
        WebDriverWait wait = new WebDriverWait(Driver.driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userPages.parolaDeğişimBaşlığı));
        String expectedParolaDegişimBaşlığı = "Error";
        String actualParolaDegişimBaşlığı = userPages.parolaDeğişimBaşlığı.getText();
        Assert.assertTrue(actualParolaDegişimBaşlığı.contains(expectedParolaDegişimBaşlığı));
        // Parola değişim formunu kapatır.
        userPages.parolaDeğişimFormuKapatmaXbutonu.click();
        ReusableMethods.bekle(6);
        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();
    }
    // US-19 TC-014 Password Visibility Toggle Fuctionality by Using the bi-eye-fill Test
    @Test
    public void PasswordVisibilityToggleFuctionalitybyUsingtheBieyefillTest (){
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecerli New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("Smartcard.12");
        //Şifre değişim formunda Confirm Password gecerli Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("Smartcard.12");
        //Bi-eye-fill ikonunlarına tıklamadan önce bi-eye-fill ikonunlarının kapalı olduğunu doğrular.
        for (int i = 0; i <userPages.biEyeFillHide.size() ; i++) {
            Assert.assertTrue(userPages.biEyeFillHide.get(i).isDisplayed());
        }
        //Bi-eye-fill ikonuna tıkladıktan sonra, be-eye-fill ikonun değiştiğini doğrular.
        for (int i = 0; i <userPages.biEyeFillHide.size() ; i++) {
            userPages.biEyeFillHide.get(i).click();
        }
        for (int i = 0; i <userPages.biEyeFillShow.size() ; i++) {
            Assert.assertTrue(userPages.biEyeFillShow.get(i).isDisplayed());
        }
        //Parola değişim formunu kapatır.
        userPages.parolaDeğişimFormuKapatmaXbutonu.click();
        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();
    }
    // US-19 TC-015 Negative Password Change (wrong current password)
    @Test
    public void NegativePasswordChangeWrongCurrentPassword (){
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox a geçersiz şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys("Smart.2025");
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecerli New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("Smartcard.12");
        //Şifre değişim formunda Confirm Password gecerli Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("Smartcard.12");
        //Save butonuna tıkladığında ilgili onay mesajın geldiğini doğrular
        userPages.parolaDegiştirmeFormuSaveButonu.click();
        //Başarılı bir şekilde şifre değişimi yaptığını doğrular.
        WebDriverWait wait = new WebDriverWait(Driver.driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userPages.parolaDeğişimMesajı));
        String expectedParolaDegişimMesajı = "Current password is invalid.";
        String actualParolaDegişimMesajı = userPages.parolaDeğişimMesajı.getText();
        Assert.assertTrue(actualParolaDegişimMesajı.contains(expectedParolaDegişimMesajı));
        ReusableMethods.bekle(6);
        userPages.parolaDeğişimFormuKapatmaXbutonu.click();
        // wait.until(ExpectedConditions.elementToBeClickable(userPages.avatarDropdownMenuButonu));
        // bu komut çalışmadı ?
        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();
    }
    // US-19 TC-01 Happy Path -Pozitive Password Change Test
    @Test
    public  void  veryHappyPathPozitivePasswordChangeTest (){
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı Sıgn ın linkine tıklar ve sign ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Kullanıcı geçerli bilgiler ile login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        //Kullanıcı kendi sayfasına erişim sağlar ve avatar/isim alanındaki dahbord a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord daki "Şifre Değişim" butonuna tıklar.
        userPages.changePasswordButonu.click();
        //Şifre değişim formunda Current Password textbox a geçerli şifreyi girer.
        userPages.parolaDegistirmeFormuCurrentPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        //Şifre değişim formunda New Password textbox a gecerli New Password girer.
        userPages.parolaDegistirmeFormuNewPasswordTextBox.sendKeys("Smartcard.12");
        //Şifre değişim formunda Confirm Password gecerli Confirm Password girer.
        userPages.parolaDegistirmeFormuConfirmPasswordTextBox.sendKeys("Smartcard.12");
        //Save butonuna tıkladığında ilgili onay mesajın geldiğini doğrular
        userPages.parolaDegiştirmeFormuSaveButonu.click();
        //Başarılı bir şekilde şifre değişimi yaptığını doğrular.
        WebDriverWait wait = new WebDriverWait(Driver.driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userPages.parolaDeğişimMesajı));
        String expectedParolaDegişimMesajı = "Password updated successfully.";
        String actualParolaDegişimMesajı = userPages.parolaDeğişimMesajı.getText();
        Assert.assertTrue(actualParolaDegişimMesajı.contains(expectedParolaDegişimMesajı));
        ReusableMethods.bekle(6);
        // wait.until(ExpectedConditions.elementToBeClickable(userPages.avatarDropdownMenuButonu));
        // bu komut çalışmadı ?

        //Sıgn out olur
        userPages.avatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();
        //ve sayfayı kapatır.
        Driver.quitDriver();
    }
}

