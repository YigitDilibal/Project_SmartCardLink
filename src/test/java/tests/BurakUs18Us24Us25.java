package tests;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.*;
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
    Actions actions = new Actions(driver);




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

    @AfterMethod
    public void Quit(){

        //Kullanıcı çıkış yapar
        userPages.userAvatarDropdownMenuButonu.click();
        userPages.signOutButonu.click();

    }




@Test (priority =1)
public void US18_ValidCreditCardLoginTest() {


    //Kullanıcı abonelik bölumune gider
    userPages.userAvatarDropdownMenuButonu.click();
    userPages.userDropdownMenuManageSubscription.click();
    //Kullanıcı abonelik yukseltme butonuna tıklar
    userPages.userSubscriptionUpgradeButton.click();
    ReusableMethods.bekle(3);
    //Kullanıcı silver aboneligini seçer
    js.executeScript("arguments[0].click();", userPages.userSilverSwitchPlanButton);
    ReusableMethods.bekle(1);
    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
    //Kullanıcı sayfadaki dropdown menuyu açar ve stripe butonuna tıklar
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    ReusableMethods.bekle(2);
    userPages.userSubscriptionDropdownStripeButton.click();
    //Kullanıcı pay switch plan butonuna tıklar
    userPages.paySwitchPlanButton.click();
    //Kullanıcı kredi karı bilgilerini girer ve Pay butonuna tıklar
    userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("validCardNumber"));
    userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
    userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
    userPages.cardHolderNameInput.sendKeys(ConfigReader.getProperty("cardHolderName"));
    userPages.userSubscriptionPayButton.click();
    //Ekranda işlemin başarılı olduguna dair mesajı görur
    Assert.assertTrue(userPages.paymentSuccesfulMessage.isDisplayed(),"Payment Succesful mesajı görunmuyor");
    //Kullanıcı bir önceki ekrana geri döner
    userPages.backToSubscriptionButton.click();
}

@Test(priority =2)
    public void US18_InvalidCreditCardLoginTest(){

    //Kullanıcı abonelik bölumune gider
    userPages.userAvatarDropdownMenuButonu.click();
    userPages.userDropdownMenuManageSubscription.click();
    //Kullanıcı abonelik yukseltme butonuna tıklar
    userPages.userSubscriptionUpgradeButton.click();
    ReusableMethods.bekle(3);
    //Kullanıcı gold aboneligini seçer
    js.executeScript("arguments[0].click();", userPages.userSubscriptionGoldPlanButton);
    ReusableMethods.bekle(2);
    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
    //Kullanıcı sayfadaki dropdown menuyu açar ve stripe butonuna tıklar
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    userPages.userSubscriptionDropdownStripeButton.click();
    //Kullanıcı pay switch plan butonuna tıklar
    userPages.paySwitchPlanButton.click();
    //Kullanıcı kredi kartı bilgilerini girer ve Pay butonuna tıklar
    userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("invalidCardNumber"));
    userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
    userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
    userPages.cardHolderNameInput.sendKeys(ConfigReader.getProperty("cardHolderName"));
    userPages.userSubscriptionPayButton.click();
    //Kullanıcı ekranda uygun hata mesajını görmelidir
    Assert.assertTrue(userPages.subscriptionInvalidCardErrorMessage.isDisplayed());
    //Kullanıcı bir önceki ekrana geri döner
    userPages.subscriptionPurchaseBackButton.click();
    //kullanıcı sayfadaki alerti kabul eder
    ReusableMethods.bekle(2);
  //  Alert alert = driver.switchTo().alert();// alert.accept();  // OK butonuna tıklar
    //Kullanıcı öddemenin başarısız olduguna dair mesajı göruntuler
    Assert.assertTrue(userPages.paymentCancelledMessage.isDisplayed());
    userPages.paymentFailureBackButton.click();


}

@Test(priority = 3)
    public void verifySubscriptionPriceConsistencyTest(){

    //Kullanıcı abonelik bölumune gider
    userPages.userAvatarDropdownMenuButonu.click();
    userPages.userDropdownMenuManageSubscription.click();
    //Kullanıcı abonelik yukseltme butonuna tıklar
    userPages.userSubscriptionUpgradeButton.click();
    ReusableMethods.bekle(3);
    //Kullanıcı unlimited butonuna tıklar ve unlimited aboneligini seçer
    userPages.userSubscriptionUnlimitedTab.click();
    //Kullanıcı gold aboneligini seçer
    js.executeScript("arguments[0].click();", userPages.userSubscriptionUnlimitedButton);
    ReusableMethods.bekle(2);
    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
    //Kullanıcı sayfadaki dropdown menuyu açar ve stripe butonuna tıklar
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    userPages.userSubscriptionDropdownStripeButton.click();
    //Kullanıcı pay switch plan butonuna tıklar
    userPages.paySwitchPlanButton.click();
    //Abonelik ekranındaki fiyat ile satın alma adımındaki fiyatların eşitligi kontrol edilir
    String expectedPrice =userPages.subscriptionUnlimitedPlanPrice.getText();
    String actualPrice = userPages.purchaseUnlimitedPlanPrice.getText();
    Assert.assertEquals(actualPrice, expectedPrice,"Fiyatlar Eşleşmiyor!");
    //Kullanıcı önceki ekrana geri döner
    userPages.subscriptionPurchaseBackButton.click();
    userPages.paymentFailureBackButton.click();

}
@Test(priority = 4)
    public void test(){




}




}






