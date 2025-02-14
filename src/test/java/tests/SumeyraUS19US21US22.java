package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class SumeyraUS19US21US22 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();

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
        //Login tusuna basar ve kendi sayfasına erişim saglar.git
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
}

