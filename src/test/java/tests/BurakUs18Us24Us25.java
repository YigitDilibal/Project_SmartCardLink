package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class BurakUs18Us24Us25 {



    AnasayfaPages anasayfaPages = new AnasayfaPages();
    UserPages userPages = new UserPages();
    AdminPages adminPages = new AdminPages();



    @BeforeMethod
    public void setUp(){



        //Kullanıcı anasayfaya gider ve
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        anasayfaPages.homepageSıgnInButonu.click();
        ReusableMethods.bekle(2);

        //Kullanıcı giriş bilgilerini girer ve login olur
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userburakumail"));
        ReusableMethods.bekle(2);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

    }




@Test
public void us18_UyelikSatinAlmaTesti() {





//Kullanıcı abonelik bölumune gider
    userPages.userAvatarDropdownMenuButonu.click();
    userPages.userDropdownMenuManageSubscription.click();

    //Kullanıcı Uprgade butonuna tıklar
    userPages.paySwitchPlanButton.click();
    userPages.userSilverSwitchPlanButton.click();
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    userPages.userSubscriptionDropdownStripeButton.click();
    userPages.userSubscriptionPayButton.click();
    userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("validCardNumber"));
    userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
    userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
    userPages.cardHolderNameInput.sendKeys(ConfigReader.getProperty("cardHolderName"));
    userPages.userSubscriptionPayButton.click();

    Assert.



    //Payment Successful





}





}






