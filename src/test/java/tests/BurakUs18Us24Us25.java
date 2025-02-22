package tests;

import com.github.javafaker.Faker;
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

import java.lang.reflect.Method;
import java.util.Set;

import static utilities.Driver.driver;
import static utilities.Driver.quitDriver;

public class BurakUs18Us24Us25 {



    AnasayfaPages anasayfaPages = new AnasayfaPages();
    UserPages userPages = new UserPages();
    AdminPages adminPages = new AdminPages();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);
    Faker faker = new Faker();




    @BeforeMethod
    public void setUp(Method method){

        String testName = method.getName();

        if (testName.toLowerCase().contains("user")) {


            //Kullanıcı anasayfaya gider ve
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();

            //Kullanıcı giriş bilgilerini girer ve login olur
            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userburakumail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();

        } else if (testName.toLowerCase().contains("dentist")) {
            Driver.getDriver().get(ConfigReader.getProperty("vcardUrl"));
        } else if (testName.toLowerCase().contains("approved")) {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();

            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("vCardSumeyra"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();





    } else {
            //Yönetici anasayfaya gider
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            anasayfaPages.homepageSıgnInButonu.click();

            //Yönetici giriş bilgilerini girer ve login olur
            anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminburakumail"));
            anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
            anasayfaPages.signInLoginButonu.click();


        }

    }

    @AfterMethod
    public void Quit(Method method) {

        String testName = method.getName();
        if (testName.toLowerCase().contains("dentist")) {
            driver.quit();

        } else {
            //Kullanıcı/Yönetici çıkış yapar
            userPages.userAvatarDropdownMenuButonu.click();
            userPages.signOutButonu.click();
            Driver.quitDriver();
        }
    }




@Test (priority =1)
public void US18_UserValidCreditCardTest() {


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
    Assert.assertTrue(userPages.paymentSuccesfulMessage.isDisplayed(), "Payment Succesful mesajı görunmuyor");

    //Kullanıcı bir önceki ekrana geri döner
    userPages.backToSubscriptionButton.click();

    //Kullanıcı çıkış yapar
}

@Test(priority =2)
    public void US18_UserInvalidCreditCardLoginTest(){

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

    //Kullanıcı öddemenin başarısız olduguna dair mesajı göruntuler
    Assert.assertTrue(userPages.paymentCancelledMessage.isDisplayed());
    userPages.paymentFailureBackButton.click();

    //Kullanıcı çıkış yapar

}

@Test(priority = 3)
    public void UserVerifySubscriptionPriceConsistencyTest(){

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
    String expectedPrice =userPages.subscriptionUnlimitedPlanPrice.getText().trim();

    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

    //Kullanıcı sayfadaki dropdown menuyu açar ve stripe butonuna tıklar
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    userPages.userSubscriptionDropdownStripeButton.click();

    //Kullanıcı pay switch plan butonuna tıklar
    userPages.paySwitchPlanButton.click();

    //Abonelik ekranındaki fiyat ile satın alma adımındaki fiyatların eşitligi kontrol edilir
    ReusableMethods.bekle(2);


   // System.out.println(expectedPrice);
    String actualPrice = userPages.purchaseUnlimitedPlanPrice.getText();
    System.out.println(actualPrice);
    Assert.assertEquals(actualPrice, expectedPrice,"Fiyatlar Eşleşmiyor!");

    //Kullanıcı önceki ekrana geri döner
    ReusableMethods.bekle(1);
    userPages.subscriptionPurchaseBackButton.click();
    userPages.paymentFailureBackButton.click();

}
@Test(priority = 4)
    public void testChartToggleLineToBar(){

    //Yönetici giriş yapar
    //Yönetici ekrandaki çubuk grafigi degiştirerek çizgi grafigine çevirir
    adminPages.chartToggleButton.click();
    adminPages.chartToggleButton.click();
    adminPages.chartToggleButton.click();

    String initialClass =adminPages.dashboardBarChart.getDomAttribute("data-icon");
    System.out.println(initialClass);
    Assert.assertTrue(initialClass.contains("line"));
    ReusableMethods.bekle(5);

    //Yönetici tekrardan grafigi degiştirerek degiştigini göruntuler
    adminPages.chartToggleButton.click();

    String updatedClass=adminPages.dashboardLineChart.getDomAttribute("data-icon");
    System.out.println(updatedClass);
    Assert.assertTrue(updatedClass.contains("bar"));

    //Yönetici iki grafigin degiştigini dogrular
    Assert.assertNotEquals(initialClass,updatedClass);

}
@Test(priority = 5)
    public void accountCreationTest (){

        //yönetici login olur
        adminPages.dashboardSolPanelUsersButonu.click();

        //Yönetici yeni kullanıcı ekleme butonuna tıklar
        adminPages.usersSekmesiAddUserButonu.click();

        //Yönetici yeni kullanıcı bilgilerini girer
        adminPages.addUserFirstName.sendKeys(faker.name().firstName());
        adminPages.addUserLastName.sendKeys(faker.name().lastName());
        adminPages.addUserEmail.sendKeys(faker.internet().emailAddress());
        adminPages.addUserPassword.sendKeys(ConfigReader.getProperty("password"));
        adminPages.addUserConfirmPassword.sendKeys(ConfigReader.getProperty("password"));

        //Save butonuna tıklar
        adminPages.addUserSaveButton.click();

        //Ekranda işlemin başarılı olduguna dair mesaj göruntulenir
        adminPages.addUserSuccessMessage.isDisplayed();

        //Yönetici çıkış yapar
}
@Test
    public void testMembershipActivationAndDeactivation(){

    //yönetici login olur ve kullanıcıların bulundugu sekmeye geçer
    adminPages.dashboardSolPanelUsersButonu.click();

    //Yönetici sistemdeki bir kullanıyı pasif hale getirir
    adminPages.userIsActiveButton.click();

    //Yönetici ekranda başarı mesajını göruntuler
    adminPages.userIsActiveSuccessMessage.isDisplayed();
    ReusableMethods.bekle(5);

    //Yönetici sistemdeki kullanıyı aktif hale getirir
    adminPages.userIsActiveButton.click();

    //Yönetici ekranda başarı mesajını göruntuler
    adminPages.userIsActiveSuccessMessage.isDisplayed();
    ReusableMethods.bekle(5);

    //Yönetici çıkış yapar
}

@Test
    public void editPersonTest(){

    //yönetici login olur ve kullanıcıların bulundugu sekmeye geçer
    adminPages.dashboardSolPanelUsersButonu.click();

    //Yönetici edit butonuna tıklar
    adminPages.userEditButton.click();

    //Yönetici çıkan ekranda var olan bilgileri editler
    adminPages.addUserFirstName.clear();
    adminPages.addUserFirstName.sendKeys(faker.name().firstName());
    adminPages.addUserLastName.clear();
    adminPages.addUserLastName.sendKeys(faker.name().lastName());
    adminPages.addUserEmail.clear();
    adminPages.addUserEmail.sendKeys(faker.internet().emailAddress());

    //Yönetici yapılan degişiklikleri kaydeder
    adminPages.addUserSaveButton.click();

    //Yönetici ekranda işlemin başarılı olduguna dair mesajı göruntuler
    Assert.assertTrue(adminPages.userEditSuccessMessage.isDisplayed());
    Assert.assertFalse(adminPages.userEditSuccessMessageInvinsible.isDisplayed());

    //Yönetici çıkış yapar

}
@Test
    public void Us24ChangePasswordTest(){

    //Yönetici login olur ve kullanıcıların bulundugu sekmeye geçer
    adminPages.dashboardSolPanelUsersButonu.click();

    //Yönetici şifre degiştirme butonuna tıklar
    adminPages.userChangePasswordButton.click();

    //Yönetici yeni şifreyi ve şifre tekrarını girer
    adminPages.changeNewPassword.sendKeys(ConfigReader.getProperty("password"));
    adminPages.changeConfirmPassword.sendKeys(ConfigReader.getProperty("password"));

    //Yönetici işlemi kaydeder
    adminPages.changePasswordSaveButton.click();

    //İşlemin başarılı ile gerçekleştigine dair mesaj göruntulenir
    Assert.assertTrue(adminPages.userIsActiveSuccessMessage.isDisplayed());

    ReusableMethods.bekle(5);

    //Yönetici çıkış yapar
}
@Test
    public void Us24TestDeleteAccount(){


    //Yönetici login olur ve kullanıcıların bulundugu sekmeye geçer
    adminPages.dashboardSolPanelUsersButonu.click();

    //Yönetici bir kullanıcıyı silmek için ilgili butona tıklar
    adminPages.deleteUserButton.click();


    //Yönetici iptal ile işlemin iptal edildigini dogrular
    adminPages.deleteUserCancelButton.click();

    //Yönetici bir kullanıcıyı silmek için ilgili butona tıklar
    adminPages.deleteUserButton.click();
    adminPages.deleteUserAcceptButton.click();

    Assert.assertTrue(adminPages.deleteUserConfirmMessage.isDisplayed());
    ReusableMethods.bekle(3);

}
@Test
    public void userManuallyPurchaseTest(){


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

    //Kullanıcı sayfadaki dropdown menuyu açar ve manually butonuna tıklar
    userPages.userSubscriptionSelectPaymentDdwButton.click();
    ReusableMethods.bekle(3);
    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.PAGE_DOWN).perform();


    ReusableMethods.bekle(2);

    //Kullanıcı cash Pay Butonuna tıklayarak ödemeyi tamamlar
    userPages.userSubscriptionCashPayButton.click();
    ReusableMethods.bekle(2);

    //Kullanıcı çıkış yapar

}
@Test
    public void whenUserIsOnPaymentStep_thenLinkAndGooglePayButtonsShouldBeVisible(){

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
    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

    ReusableMethods.bekle(2);
    userPages.userSubscriptionDropdownStripeButton.click();

    //Kullanıcı pay switch plan butonuna tıklar
    userPages.paySwitchPlanButton.click();

    //Sayfanın title ı alınır
    String actualTitle = driver.getTitle();

    //Main window adında bir string degere suanki windowhandle degeri atanır
    ReusableMethods.bekle(3);
    String mainWindow = driver.getWindowHandle();

    //Iframenin içine geçiş yapılır ve link b utonuna tıklanır
    driver.switchTo().frame(userPages.iframe);
    ReusableMethods.bekle(2);
    userPages.userSubscriptionLinkPayButton.click();

    ReusableMethods.bekle(3);


    Set<String> allWindows = driver.getWindowHandles();


    String newWindow ="";

    for (String window : allWindows) {
        if (!window.equals(mainWindow)) {
            newWindow = window;
            break;


        }
    }
    driver.switchTo().window(newWindow);
    String expectedTitle = "Link";

    driver.switchTo().window(mainWindow);

    Assert.assertNotEquals(actualTitle,expectedTitle);
    System.out.println(expectedTitle);
    System.out.println(actualTitle);

    userPages.userSubscriptionLinkCancelButton.click();

    //Kullanıcı geri döner
    userPages.subscriptionPurchaseBackButton.click();
    userPages.paymentFailureBackButton.click();

    //Kullanıcı çıkış yapar

}
@Test
    public void whenMembersBooksAppointmentThroughVCard_thenAppointmentShouldBeVisibleToDentist(){


    ReusableMethods.bekle(2);
    js.executeScript("arguments[0].scrollIntoView(true);", userPages.meriDentPickDate);

    ReusableMethods.bekle(2);
    userPages.meriDentPickDate.click();
        userPages.meriDentClickButton.click();
        userPages.meriDentSpesificDate.click();
        userPages.meriDentSpesificHour.click();
        userPages.meriDentMakeAppointmentButton.click();
        ReusableMethods.bekle(2);
        userPages.meriDentNewAppointmentName.sendKeys(faker.name().fullName());
        userPages.meriDentNewAppointmentEmail.sendKeys(faker.internet().emailAddress());
        userPages.meriDentNewAppointmentPhone.sendKeys(ConfigReader.getProperty("PhoneNumber"));
        userPages.meriDentNewAppointmentSaveButton.click();

        ReusableMethods.bekle(2);


}
@Test
    public void whenLabViewsAppointmentScreen_thenAppointmentIsDisplayedAndCanBeApproved(){

     userPages.meriDentAdminAppointmentButton.click();
     userPages.meriDentAdminAppointmentPendingButton.click();
     ReusableMethods.bekle(2);
     userPages.meriDentAdminAppointmentPendingApproveButton.click();
     ReusableMethods.bekle(5);





}

















}













