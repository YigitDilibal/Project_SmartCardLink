package tests;

import org.openqa.selenium.Alert;
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

import java.time.Duration;

public class SumeyraUS19US21US22 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();
    UserPages userPages = new UserPages();

    @Test
    public void gecerliLoginTesti () {
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
        Assert.assertTrue(anasayfaPages.signInLoginButonu.isDisplayed());
        Driver.quitDriver();
    }
        @Test
        public void gecersizMailileLoginTesti () {
            //Yönetici URL ile siteye erişir
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
            anasayfaPages.homepageSıgnInButonu.click();
            //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçersiz mail girer.
            anasayfaPages.signInEmailKutusu.sendKeys("computer@gmail.com");
            //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            //Login tusuna basar.
            anasayfaPages.signInLoginButonu.click();
            // Başarılı bir şekilde login olamadığını test edin.
            Assert.assertTrue(anasayfaPages.signInLoginButonu.isDisplayed());
           //sayfayı kapatır.
            Driver.quitDriver();
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
    public  void rememberMeCheckboxTesti (){
        //Yönetici URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkini görüntüler ve sayfasına erişim sağlar.
        ReusableMethods.bekle(2);
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve mail kutusuna geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsumeyramail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        //Remember me check box ına tıklar.
        anasayfaPages.signInRemembermeBox.click();
        //Login tusuna basar
        anasayfaPages.signInLoginButonu.click();
        //Kendi sayfasına erişim saglar ve Sıgn out olur.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        //SıgnIn sayfasına geri gider. Email ve Password kutucugunun otomatik dolduğunu doğrular ve login olur.
        anasayfaPages.signInLoginButonu.click();
        String expectedMailKutusuText = "sumeyra.sadmin@smartcardlink.com";
        String actualMailKutusuText = anasayfaPages.signInEmailKutusu.getText();
        Assert.assertEquals(expectedMailKutusuText,actualMailKutusuText);
        //sayfayı kapatır.
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
    public void notAnAdminUserSıgnınTest (){
        //Yönetici URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın sayfasına erişim sağlar.
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusuna geçersiz mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        //Sıgn ın sayfasında password kutusununa gecersiz password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        //Login tusuna basar ve yönetici sayfasına ulaşamaz.
        anasayfaPages.signInLoginButonu.click();
        Assert.assertTrue(userPages.dahbordPanelEnguiriesButonu.isDisplayed());
        //Sayfayı kapatır.
        Driver.quitDriver();
    }
    @Test
    public void loginPageLoadTest (){
        //Yönetici URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın sayfasına erişim sağlar.
        ReusableMethods.bekle(2);
        anasayfaPages.homepageSıgnInButonu.click();
        //Yönetici Sign in Formunu görüntüler.
        Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
        //Yönetici email text box ını görünütler.
        Assert.assertTrue(anasayfaPages.signInEmailKutusu.isDisplayed());
        //Yönetici password text box ını görüntüler.
        Assert.assertTrue(anasayfaPages.signInPasswordKutusu.isDisplayed());
        //Yönetici remember me checkbox ını görüntüler.
        Assert.assertTrue(anasayfaPages.signInRemembermeBox.isDisplayed());
        //Sayfayı kapatır
        Driver.quitDriver();
    }
    @Test
    public void pozitifLogoutTesti() {
        //Kullanıcı URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Kullanıcı giriş bilgilerini girer ve login olur.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("usersumeyramail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        //Kullanıcı avatar/isim alanındaki dahbord menüye  a tıklar.
        userPages.avatarDropdownMenuButonu.click();
        //Dashbord menü deki "Çıkış" butonuna tıklar.
        userPages.signOutButonu.click();
        //Sıgn ın sayfasına yönlendirilir
        Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
        //Sayfayı kapatır.
        Driver.quitDriver();
    }
}

