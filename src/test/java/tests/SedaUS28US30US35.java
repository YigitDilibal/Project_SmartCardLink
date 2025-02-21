package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SedaUS28US30US35 {

    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup() {
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();
    }

        @Test // US28 TC01
        public void AboneOlanKullanicilarSekmesiTesti () {


            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();


            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsedamail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();


            // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağlandı

            adminPages.adminSekmesiSubscribedUserButonu.click(); // Abone kullanıcılar sekmesine erişildi
            adminPages.aboneKullaniciAdi.click();
            adminPages.aboneKullaniciPlanAdi.click();
            adminPages.aboneKullaniciBaslangicTarihi.click();
            adminPages.aboneKullanicilarBitisTarihi.click(); // Tüm butonlara tıklanarak kontrol edildi

            adminPages.avatarDropdownMenuButonu.click();
            adminPages.signOutButonu.click(); // çıkış yapıldı

        }

        @Test // US30 TC01
        public void BagliKullanicilarSekmesiTesti () {

            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();


            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsedamail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();


            // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağland

            adminPages.adminSekmesiBagliKullanicilarButonu.click(); // Bağlı kullanıcılar sekmesine erişildi
            adminPages.bagliOlduguKullaniciAdi.click();
            adminPages.bagliKullaniciAdi.click();
            adminPages.bagliKullaniciUyelikTutari.click();
            adminPages.bagliKullaniciUyelikTarihi.click(); // Butonlar kontrol edildi

            adminPages.avatarDropdownMenuButonu.click();
            adminPages.signOutButonu.click(); // çıkış yapıldı





        }

        @Test // US35 TC01
        public void AdminGüvenliCikisIslemiTesti () {

            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();
            ReusableMethods.bekle(1);


            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsedamail"));
            ReusableMethods.bekle(1);
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            ReusableMethods.bekle(1);
            anasayfaPages.signInLoginButonu.click();
            ReusableMethods.bekle(1);


            // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağland

            adminPages.avatarDropdownMenuButonu.click();
            ReusableMethods.bekle(1);
            adminPages.signOutButonu.click();
            ReusableMethods.bekle(1);
            Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
            ReusableMethods.bekle(1);
            //Sayfayı kapatır.
            Driver.quitDriver();




        }


}

