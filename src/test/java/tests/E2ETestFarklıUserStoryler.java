package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import utilities.TestBaseRapor;

public class E2ETestFarklıUserStoryler extends TestBaseRapor {
    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup(){
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();
    }

    @Test (priority =1)
    public void US37TC07KaydolanKullanicininPaneldeGorunmesiTesti(){
        // Raporlama: Test başlatıldı
        extentTest = extentReports.createTest("US37TC07KaydolanKullanicininPaneldeGorunmesiTesti",
                "Kaydolunan kullanıcının panelde görüntülenme testi");

        Faker faker = new Faker();

        //Davet edilen kullanıcı kayıt olur.

        Driver.getDriver().get(ConfigReader.getProperty("yigitDavetBaglantisi"));

        userPages.newVcardSayfasiFirstNameKutusu.sendKeys(faker.name().firstName());
        userPages.newVcardSayfasiLastNameKutusu.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        userPages.affiliationsSayfasiSendInviteBolumuEmailKutusu.sendKeys(email);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.kayitSayfasiConfirmPassword.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.kayitSayfasiTermsAndConditions.click();
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Davet edilen kullanıcı siteye kayıt olur.");

        // giris yapar

        anasayfaPages.signInEmailKutusu.sendKeys(email);
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Davet edilen kullanıcı siteye giris yapar");

        // abonelik satin alir ve odeme yapar

        userPages.avatarDropdownMenuButonu.click();
        userPages.userDropdownMenuManageSubscription.click();
        userPages.userSubscriptionUpgradeButton.click();
        userPages.manageSubscriptionUnlimitedSekmesi.click();
        extentTest.info("Davet edilen kullanıcı  abonelik satin alir");

        JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",userPages.unlimitedPlanSwitchPlanButonu);
        ReusableMethods.bekle(1);

        userPages.unlimitedPlanSwitchPlanButonu.click();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",userPages.userSubscriptionSelectPaymentDdwButton);
        ReusableMethods.bekle(1);
        userPages.userSubscriptionSelectPaymentDdwButton.click();
        userPages.userSubscriptionDropdownStripeButton.click();
        userPages.paySwitchPlanButton.click();

        userPages.subscriptionCardNumberInput.sendKeys(ConfigReader.getProperty("validCardNumber"));
        userPages.cardExpirationDateInput.sendKeys(ConfigReader.getProperty("cardExpirationDate"));
        userPages.cardCvcInput.sendKeys(ConfigReader.getProperty("cardCvc"));
        userPages.cardHolderNameInput.sendKeys(faker.name().fullName());
        userPages.userSubscriptionPayButton.click();
        extentTest.info("Davet edilen kullanıcı odeme yapar");

        userPages.backToSubscriptionButton.click();

        // çıkış yapar.-- Davet eden kullanıcı login sayfasına gider.
        extentTest.info("Davet edilen kullanıcı çıkış yapar");
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();

        //Kullanıcı giriş bilgilerini girer ve logine basar.

        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userYigitMail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("userYigitSifre"));
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Kullanıcı giriş bilgilerini girer ve logine basar.");


        //Dashboard'da "Affiliations" sekmesine tıklar.

        userPages.solPanelAffiliationsButonu.click();
        extentTest.info("Dashboard'da \"Affiliations\" sekmesine tıklar.");

        //Panelde davet edilen kullanıcının listelendiğini kontrol eder.
        String xPath= "//*[.='"+email+"']";
        WebElement referredUser = Driver.getDriver().findElement(By.xpath(xPath));

        Assert.assertTrue(referredUser.isDisplayed());
        extentTest.pass("Kullanıcı Panelde davet edilen kullanıcının listelendiğini başarılı bir şekilde görüntüler.");
        //sign out olur ve sayfaları kapatır.
        adminPages.avatarDropdownMenuButonu.click();
        adminPages.signOutButonu.click();
        extentTest.info("Sign out olur ve sayfaları kapatır.");

    }

    @Test (priority =2)
    public void US29NewPlanOluşturmaveSilmeTest(){
        // Raporlama: Test başlatıldı
        extentTest = extentReports.createTest("US29NewPlanOluşturmaveSilmeTest",
                "Yeni plan oluşturulup, tabloda doğrulanıp, sonrasında silinerek 'No data available' mesajının gösterildiği test");

        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Siteye erişildi: " + ConfigReader.getProperty("url"));

        // Sign In sayfasına erişim
        anasayfaPages.homepageSıgnInButonu.click();
        extentTest.info("Homepage Sign In butonuna tıklandı.");
        ReusableMethods.bekle(1);

        // Email ve password girilir, login yapılır
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        extentTest.info("Admin email girildi: " + ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Password girildi.");
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Login butonuna tıklandı.");

        // Admin Plans sayfasına geçiş
        adminPages.adminPlansSidebarButonu.click();
        extentTest.info("Admin Plans Sidebar butonuna tıklandı.");
        adminPages.adminPlansSayfasiBaslikYazisi.isDisplayed();
        extentTest.info("Admin Plans sayfa başlığı görüntülendi.");
        adminPages.adminPlansNewPlanButonu.click();
        extentTest.info("New Plan butonuna tıklandı.");
        adminPages.adminPlansNewPlanYazisi.isDisplayed();
        extentTest.info("New Plan sayfa başlığı görüntülendi.");

        // Benzersiz plan ismi oluşturulur ve girilir
        String uniquePlanName = "Burak_" + System.currentTimeMillis();
        adminPages.adminPlansNewPlanNameInputAlani.sendKeys(uniquePlanName);
        extentTest.info("Benzersiz plan adı girildi: " + uniquePlanName);

        // Frequency, Currency, Price, Kart numarası, Trial Days ve Template seçimi yapılır
        adminPages.adminPlansFrequencyDropdownButonu.click();
        extentTest.info("Frequency dropdown açıldı.");
        adminPages.adminPlansFrequencySearchInputAlani.sendKeys("Year");
        extentTest.info("Frequency olarak 'Year' yazıldı.");
        adminPages.adminPlansCurrencyDropdownButonu.click();
        extentTest.info("Currency dropdown açıldı.");
        adminPages.adminPlansCurrencyInputAlani.sendKeys("USD", Keys.ENTER);
        extentTest.info("Currency olarak 'USD' seçildi.");
        adminPages.adminPlansPriceInputAlani.sendKeys("100");
        extentTest.info("Price olarak '100' girildi.");
        adminPages.adminPlansKartNumarasiInputAlani.sendKeys("1234567890");
        extentTest.info("Kart numarası olarak '1234567890' girildi.");
        adminPages.adminPlansTrialDaysInputAlani.sendKeys("30");
        extentTest.info("Trial Days olarak '30' girildi.");
        adminPages.adminPlansTemplateSecmeAlani.click();
        extentTest.info("Template seçme alanına tıklandı.");

        // Save butonunun görünür olması için scroll yapılır
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", adminPages.adminPlansSaveButonu);
        extentTest.info("Save butonu görünür hale getirildi.");
        ReusableMethods.bekle(1);

        // Feature checkbox seçilir ve plan kaydedilir
        adminPages.adminPlansFeatureSecmeAlani.click();
        extentTest.info("Feature checkbox seçildi.");
        adminPages.adminPlansSaveButonu.click();
        extentTest.info("Plan kaydedildi.");

        // Oluşturulan planın tabloda göründüğü kontrol edilir
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[starts-with(normalize-space(text()), 'Burak_')]")).isDisplayed(),
                "Tabloda 'Burak_...' metni içeren hücre bulunamadı!");
        extentTest.pass("Tabloda oluşturulan plan adı görüntülendi.");

        // Fiyat kontrolü: "$100.00" metnini içeren <td>
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//td[normalize-space(text())='$100.00']")).isDisplayed(),
                "Tabloda '$100.00' fiyatı bulunamadı!");
        extentTest.pass("Tabloda fiyat olarak '$100.00' görüntülendi.");

        // Süre kontrolü: "Monthly" metnini içeren <span>
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='Monthly']")).isDisplayed(),
                "Tabloda 'Monthly' süresi bulunamadı!");
        extentTest.pass("Tabloda süre olarak 'Monthly' görüntülendi.");

        // Planı silme adımları
        ReusableMethods.bekle(2);
        adminPages.adminPlansDeleteButonu.click();
        extentTest.info("Delete butonuna tıklandı.");
        adminPages.adminPlansDeletePopupTitle.isDisplayed();
        extentTest.info("Delete popup başlığı görüntülendi.");
        adminPages.adminPlansDeletePopupYesButonu.click();
        extentTest.info("Delete popup'ta 'Yes, Delete!' butonuna tıklandı.");
        adminPages.adminPlansDeletePopupOkButonu.click();
        extentTest.info("Delete popup'ta 'Ok' butonuna tıklandı.");

        // Arama alanına silinen plan adını yazarak aratılır
        adminPages.adminPlansTabloSearchInputAlani.clear();
        adminPages.adminPlansTabloSearchInputAlani.sendKeys(uniquePlanName);
        extentTest.info("Silinen plan adı arama alanına girildi: " + uniquePlanName);

        // "No data available" mesajı kontrol edilir
        Assert.assertTrue(adminPages.adminPlansNoDataAvailableYazisi.isDisplayed(),
                "No data available yazısı görünmüyor!");
        extentTest.pass("Silinen plan için 'No data available' mesajı görüntülendi.");
    }

    @Test(priority = 3)
    public void accountCreationTest (){
        extentTest = extentReports.createTest("accountCreationTest",
                "Yönetici yeni bir account oluşturabilmeli.");

        //Yönetici anasayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        extentTest.info("Yönetici anasayfaya gider");

        //Yönetici giriş bilgilerini girer ve login olur
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminburakumail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Yönetici giriş bilgilerini girer ve login olur");

        Faker faker = new Faker();

        //yönetici login olur
        adminPages.dashboardSolPanelUsersButonu.click();
        extentTest.info("Yönetici users butonuna tıklar");

        //Yönetici yeni kullanıcı ekleme butonuna tıklar
        adminPages.usersSekmesiAddUserButonu.click();
        extentTest.info("Yönetici yeni kullanıcı ekleme butonuna tıklar");

        //Yönetici yeni kullanıcı bilgilerini girer
        adminPages.addUserFirstName.sendKeys(faker.name().firstName());
        adminPages.addUserLastName.sendKeys(faker.name().lastName());
        adminPages.addUserEmail.sendKeys(faker.internet().emailAddress());
        adminPages.addUserPassword.sendKeys(ConfigReader.getProperty("password"));
        adminPages.addUserConfirmPassword.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Yönetici yeni kullanıcı bilgilerini girer");

        //Save butonuna tıklar
        adminPages.addUserSaveButton.click();
        extentTest.info("Save butonuna tıklar");

        //Ekranda işlemin başarılı olduguna dair mesaj göruntulenir
        adminPages.addUserSuccessMessage.isDisplayed();
        extentTest.pass("Ekranda işlemin başarılı olduguna dair mesaj göruntulenir");

        //Yönetici çıkış yapar
        extentTest.info("Yönetici çıkış yapar ve sayfayı kapatır.");
    }

}
