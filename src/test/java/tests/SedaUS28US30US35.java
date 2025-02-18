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


            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminSedaMail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();


            // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağlandı

            adminPages.adminSekmesiSubscribedUserButonu.click(); // Abone kullanıcılar sekmesine erişildi

        }

        @Test // US30 TC01
        public void BagliKullanicilarSekmesiTesti () {

            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();


            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminSedaMail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();


            // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağland

            adminPages.adminSekmesiBagliKullanicilarButonu.click(); // Bağlı kullanıcılar sekmesine erişildi

        }

        @Test // US35 TC01
        public void AdminGüvenliCikisIslemiTesti () {

            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();


            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminSedaMail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();


            // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağland

            userPages.avatarDropdownMenuButonu.click();
            userPages.signOutButonu.click(); // Çıkış butonuna tıklanır
            Assert.assertTrue(anasayfaPages.signInFormu.isDisplayed());
            //Sayfayı kapatır.
            Driver.quitDriver();




        }


}

