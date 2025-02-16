package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class FaigUS8US9US10 {

    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup(){
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();
    }

    // ========== US 08 ==========
    // As a visitor, I would like to be able to participate in the site's email newsletter.

    // US08 - Test Case 01
    // Pozitive Subscription test to receive the latest weekly news and updates.

    @Test
    public void US08TC01receiveNewsletterTest(){

        //Ziyaretci URL ile siteye erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Ziyaretci Subscribe linkini görüntüler

        JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",anasayfaPages.homepageSubscribeEnterEmailBox);
        ReusableMethods.bekle(1);

        //"Enter your Email" kutusuna gecerli mailini girebilmeli  ve Subscribe butonuna tıklaya bilmeli
        anasayfaPages.homepageSubscribeEnterEmailBox.sendKeys("faig@gmail.com");
        anasayfaPages.homepageSubscribeButton.click();

        //Başarılı bir şekilde emailin  abone olduğunu doğrulanmalı

        Assert.assertTrue(anasayfaPages.homepageSubscribeSuccessAlert.isDisplayed());

        // sayfayi kapatir

        Driver.quitDriver();

    }


}
