package tests;

import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;

public class SedaUS28US30US35 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();
    UserPages userPages = new UserPages();

    @Test

    public void BagliKullanicilarSekmesiTesti () {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminsedamail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        // Yukarıdaki adımlarla admin girişi yapılmış oldu ve dashboard sayfasına erişim sağlandı

        adminPages.adminSekmesiBagliKullanicilarButonu.click();


    }
}
