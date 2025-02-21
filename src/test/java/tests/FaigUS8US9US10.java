package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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


    @Test
    public void US37TC07KayitVeSatinAlmaTesti(){

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

        // abonelik satin alir ve odeme yapar

        userPages.avatarDropdownMenuButonu.click();
        ReusableMethods.bekle(1);
        userPages.userDropdownMenuManageSubscription.click();
        ReusableMethods.bekle(1);
        userPages.userSubscriptionUpgradeButton.click();
        ReusableMethods.bekle(1);
        userPages.manageSubscriptionUnlimitedSekmesi.click();
        ReusableMethods.bekle(1);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",userPages.unlimitedPlanSwitchPlanButonu);
        ReusableMethods.bekle(1);

        userPages.unlimitedPlanSwitchPlanButonu.click();
        ReusableMethods.bekle(1);
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",userPages.userSubscriptionSelectPaymentDdwButton);
        userPages.userSubscriptionSelectPaymentDdwButton.click();
        ReusableMethods.bekle(1);
        userPages.userSubscriptionDropdownStripeButton.click();
        ReusableMethods.bekle(1);
        userPages.paySwitchPlanButton.click();
        ReusableMethods.bekle(1);

        userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("validCardNumber"));
        ReusableMethods.bekle(1);
        userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
        ReusableMethods.bekle(1);
        userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
        ReusableMethods.bekle(1);
        userPages.cardHolderNameInput.sendKeys(faker.name().fullName());
        ReusableMethods.bekle(1);
        userPages.userSubscriptionPayButton.click();
        ReusableMethods.bekle(1);

        userPages.backToSubscriptionButton.click();
        ReusableMethods.bekle(1);

        // çıkış yapar.--

        adminPages.avatarDropdownMenuButonu.click();
        ReusableMethods.bekle(1);
        adminPages.signOutButonu.click();
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }


}
