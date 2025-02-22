package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.lang.reflect.Method;

import static utilities.Driver.driver;

public class MeriDentTest extends TestBaseRapor {
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


        } else {
            //Kullanıcı/Yönetici çıkış yapar
            userPages.userAvatarDropdownMenuButonu.click();
            userPages.signOutButonu.click();
        }
    }

    @Test
    public void whenMembersBooksAppointmentThroughVCard_thenAppointmentShouldBeVisibleToDentist(){
        extentTest = extentReports.createTest("whenMembersBooksAppointmentThroughVCard_thenAppointmentShouldBeVisibleToDentist",
                "Ziyaretçi Vacrd üzerinden randevu alma işlemini gerçeklerştirebilmeli");

        ReusableMethods.bekle(2);
        js.executeScript("arguments[0].scrollIntoView(true);", userPages.meriDentPickDate);
        extentTest.info("Ziyaretçi kendisine gelen link ile Vacrd ı görüntüler.");
        ReusableMethods.bekle(2);
        userPages.meriDentPickDate.click();
        ReusableMethods.bekle(2);
        userPages.meriDentClickButton.click();
        ReusableMethods.bekle(2);
        userPages.meriDentSpesificDate.click();
        extentTest.info("Ziyaretçi randevu alanından tercih ettiği tarihi seçer.");
        ReusableMethods.bekle(2);
        userPages.meriDentSpesificHour.click();
        extentTest.info("Ziyaretçi randevu alanından tercih ettiği saati seçer.");
        ReusableMethods.bekle(2);
        userPages.meriDentMakeAppointmentButton.click();
        ReusableMethods.bekle(2);
        userPages.meriDentNewAppointmentName.sendKeys(faker.name().fullName());
        ReusableMethods.bekle(2);
        extentTest.info("Ziyaretçi isim bilgisini girer.");
        userPages.meriDentNewAppointmentEmail.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(2);
        extentTest.info("Ziyaretçi email bilgisini girer.");
        userPages.meriDentNewAppointmentPhone.sendKeys(ConfigReader.getProperty("PhoneNumber"));
        ReusableMethods.bekle(2);
        extentTest.info("Ziyaretçi telefon numarası bilgisini girer.");
        userPages.meriDentNewAppointmentSaveButton.click();
        extentTest.pass("Ziyaretçi başarılı bir şekilde randevu alabildiğini doğrular");
        ReusableMethods.bekle(2);
        extentTest.info("Sayfayı Kapatır");


    }
    @Test
    public void whenLabViewsAppointmentScreen_thenAppointmentIsDisplayedAndCanBeApproved(){

        extentTest = extentReports.createTest("whenLabViewsAppointmentScreen_thenAppointmentIsDisplayedAndCanBeApproved",
                "Vcard sahibi olan kullanıcı randevu işlemini onaylayabilmeli");
        userPages.meriDentAdminAppointmentButton.click();
        extentTest.info("Kullanıcı randevuların görüntülendiği appointment butonuna tıklar");
        userPages.meriDentAdminAppointmentPendingButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Kullanıcı randevuların olduğu kısımda oluşturulan randevunun ayrıntılarını pending butonuna tıklayarak görüntüler.");
        userPages.meriDentAdminAppointmentPendingApproveButton.click();
        extentTest.pass("Kullanıcı sisteme düşen randevuyu başarılı bir şekilde onaylar.");
        ReusableMethods.bekle(5);





    }
}
