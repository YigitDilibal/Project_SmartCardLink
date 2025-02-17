package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

import static utilities.Driver.driver;

public class BurakUs18Us24Us25 {



    AnasayfaPages anasayfaPages = new AnasayfaPages();
    UserPages userPages = new UserPages();
    AdminPages adminPages = new AdminPages();
    JavascriptExecutor js = (JavascriptExecutor) driver;



    @BeforeMethod
    public void setUp(){



        //Kullanıcı anasayfaya gider ve
        Driver.getDriver().get(ConfigReader.getProperty("url"));
       // ReusableMethods.bekle(2);
        anasayfaPages.homepageSıgnInButonu.click();
      //  ReusableMethods.bekle(2);

        //Kullanıcı giriş bilgilerini girer ve login olur
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userburakumail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

    }




@Test
public void us18_UyelikSatinAlmaTesti() {





//Kullanıcı abonelik bölumune gider
    userPages.userAvatarDropdownMenuButonu.click();
    userPages.userDropdownMenuManageSubscription.click();

    //Kullanıcı abonelik yukseltme butonuna tıklar
    userPages.userSubscriptionUpgradeButton.click();
    ReusableMethods.bekle(3);

    //WebElement element = driver.findElement(By.xpath("//*[@data-id='2']"));

    js.executeScript("arguments[0].click();", userPages.userSilverSwitchPlanButton);




    //userPages.paySwitchPlanButton.click();




    //userPages.userSilverSwitchPlanButton.click();
    //ReusableMethods.bekle(2);
   // userPages.validClick.click();

    Actions actions = new Actions(driver);
    ReusableMethods.bekle(1);

    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
    ReusableMethods.bekle(1);
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    ReusableMethods.bekle(2);




    userPages.userSubscriptionDropdownStripeButton.click();
    userPages.paySwitchPlanButton.click();

   // userPages.userSubscriptionPayButton.click();
    userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("validCardNumber"));
    userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
    userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
    userPages.cardHolderNameInput.sendKeys(ConfigReader.getProperty("cardHolderName"));
    userPages.userSubscriptionPayButton.click();

    Assert.assertTrue(userPages.paymentSuccesfulMessage.isDisplayed(),"Payment Succesful mesajı görunmuyor");

    userPages.backToSubscriptionButton.click();











}





}






