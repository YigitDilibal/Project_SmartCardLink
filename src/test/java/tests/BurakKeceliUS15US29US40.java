package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class BurakKeceliUS15US29US40 extends TestBaseRapor {
    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup(){
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();
    }

    @Test
    public void US15DiscardButtonTest() {
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        userPages.virtualBackgroundsSideBarButonu.click();

        userPages.virtualBackgroundsIlkKartTemplateResmi.click();
        Assert.assertTrue(userPages.virtualBackgroundsAddVirtualBackgroundYazisi.isDisplayed(),
                "Add Virtual Background yazısı görünmüyor");

        userPages.virtualBackgroundsVcardNameDropdownButonu.click();
        userPages.virtualBackgroundsVcardNameSearchInputAlani.sendKeys("Burak_Test_Card2");

        Driver.getDriver().findElement(By.xpath("//li[text()='Burak_Test_Card2']")).click();
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsFirstnameInputAlani.click();
        userPages.virtualBackgroundsFirstnameInputAlani.sendKeys("Burak");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsLastnameInputAlani.click();
        userPages.virtualBackgroundsLastnameInputAlani.sendKeys("Keceli");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsEmailInputAlani.click();
        userPages.virtualBackgroundsEmailInputAlani.sendKeys("burakkeceli@outlook.com");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsOccupationInputAlani.clear();
        userPages.virtualBackgroundsOccupationInputAlani.sendKeys("Test engineer");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsLocationInputAlani.click();
        userPages.virtualBackgroundsLocationInputAlani.sendKeys("Test location");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsUlkeBayragiSeciliAlan.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//li[@data-country-code='tr']")).click();

        userPages.virtualBackgroundsTelefonNumarasiInputAlani.click();
        userPages.virtualBackgroundsTelefonNumarasiInputAlani.sendKeys("5554443322");

        userPages.virtualBackgroundsWebsiteInputAlani.clear();
        userPages.virtualBackgroundsWebsiteInputAlani.sendKeys("https://www.testsitesi.com.tr");

        userPages.virtualBackgroundsDiscardButonu.click();
        ReusableMethods.bekle(1);
    }

    @Test
    public void US15BackButtonTest() {
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        userPages.virtualBackgroundsSideBarButonu.click();

        userPages.virtualBackgroundsIlkKartTemplateResmi.click();
        Assert.assertTrue(userPages.virtualBackgroundsAddVirtualBackgroundYazisi.isDisplayed(),
                "Add Virtual Background yazısı görünmüyor");

        userPages.virtualBackgroundsVcardNameDropdownButonu.click();
        userPages.virtualBackgroundsVcardNameSearchInputAlani.sendKeys("Burak_Test_Card2");

        Driver.getDriver().findElement(By.xpath("//li[text()='Burak_Test_Card2']")).click();
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsFirstnameInputAlani.click();
        userPages.virtualBackgroundsFirstnameInputAlani.sendKeys("Burak");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsLastnameInputAlani.click();
        userPages.virtualBackgroundsLastnameInputAlani.sendKeys("Keceli");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsEmailInputAlani.click();
        userPages.virtualBackgroundsEmailInputAlani.sendKeys("burakkeceli@outlook.com");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsOccupationInputAlani.clear();
        userPages.virtualBackgroundsOccupationInputAlani.sendKeys("Test engineer");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsLocationInputAlani.click();
        userPages.virtualBackgroundsLocationInputAlani.sendKeys("Test location");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsUlkeBayragiSeciliAlan.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//li[@data-country-code='tr']")).click();

        userPages.virtualBackgroundsTelefonNumarasiInputAlani.click();
        userPages.virtualBackgroundsTelefonNumarasiInputAlani.sendKeys("5554443322");

        userPages.virtualBackgroundsWebsiteInputAlani.clear();
        userPages.virtualBackgroundsWebsiteInputAlani.sendKeys("https://www.testsitesi.com.tr");

        userPages.virtualBackgroundsBackButonu.click();
        ReusableMethods.bekle(1);
    }

    @Test
    public void US15ResimYüklenmeyinceVerilenUyarıTextTest() {
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        userPages.virtualBackgroundsSideBarButonu.click();

        userPages.virtualBackgroundsIlkKartTemplateResmi.click();
        Assert.assertTrue(userPages.virtualBackgroundsAddVirtualBackgroundYazisi.isDisplayed(),
                "Add Virtual Background yazısı görünmüyor");

        userPages.virtualBackgroundsVcardNameDropdownButonu.click();
        userPages.virtualBackgroundsVcardNameSearchInputAlani.sendKeys("Burak_Test_Card2");

        Driver.getDriver().findElement(By.xpath("//li[text()='Burak_Test_Card2']")).click();
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsFirstnameInputAlani.click();
        userPages.virtualBackgroundsFirstnameInputAlani.sendKeys("Burak");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsLastnameInputAlani.click();
        userPages.virtualBackgroundsLastnameInputAlani.sendKeys("Keceli");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsEmailInputAlani.click();
        userPages.virtualBackgroundsEmailInputAlani.sendKeys("burakkeceli@outlook.com");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsOccupationInputAlani.clear();
        userPages.virtualBackgroundsOccupationInputAlani.sendKeys("Test engineer");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsLocationInputAlani.click();
        userPages.virtualBackgroundsLocationInputAlani.sendKeys("Test location");
        ReusableMethods.bekle(1);
        userPages.virtualBackgroundsUlkeBayragiSeciliAlan.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//li[@data-country-code='tr']")).click();

        userPages.virtualBackgroundsTelefonNumarasiInputAlani.click();
        userPages.virtualBackgroundsTelefonNumarasiInputAlani.sendKeys("5554443322");

        userPages.virtualBackgroundsWebsiteInputAlani.clear();
        userPages.virtualBackgroundsWebsiteInputAlani.sendKeys("https://www.testsitesi.com.tr");

        userPages.virtualBackgroundsSaveButonu.click();
        String expectedMessage = "The ecard-logo field is required.";
        String actualMessage = userPages.virtualBackgroundsResimYuklenmeyinceVerilenUyariMesaji.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "Resim yüklenmedi uyarısı görünmüyor veya beklenen metin farklı.");

        ReusableMethods.bekle(2);
    }

    @Test
    public void US15VcardNameUyarıTextTest(){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("userBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        userPages.virtualBackgroundsSideBarButonu.click();

        userPages.virtualBackgroundsIlkKartTemplateResmi.click();
        Assert.assertTrue(userPages.virtualBackgroundsAddVirtualBackgroundYazisi.isDisplayed(),
                "Add Virtual Background yazısı görünmüyor");

        userPages.virtualBackgroundsVcardNameDropdownButonu.click();
        userPages.virtualBackgroundsVcardNameSearchInputAlani.sendKeys("Deneme");

        userPages.virtualBackgroundsVcardNameNotFoundInputText.isDisplayed();
    }

    @Test
    public void US29SeacrhNoDataAvailableTextTest(){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        ReusableMethods.bekle(1);
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        adminPages.adminPlansSidebarButonu.click();
        adminPages.adminPlansTabloSearchInputAlani.sendKeys("Deneme");
        adminPages.adminPlansNoDataAvailableYazisi.isDisplayed();
    }

    @Test
    public void US29SearchYapmaTest(){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        ReusableMethods.bekle(1);
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        adminPages.adminPlansSidebarButonu.click();
        adminPages.adminPlansTabloSearchInputAlani.sendKeys("Burak");

        Assert.assertTrue(adminPages.adminPlansBurakCell.isDisplayed(), "Tabloda 'Burak' metni içeren hücre bulunamadı!");
    }

    @Test
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


    @Test
    public void US29PageDeğiştirmeTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();

        adminPages.adminPlansSidebarButonu.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Next butonunun görünür ve tıklanabilir olmasını sağlamak için scroll ve explicit wait ekleyelim
        js.executeScript("arguments[0].scrollIntoView(true);", adminPages.adminPlansPageNextButonu);
        ReusableMethods.bekle(1);
        wait.until(ExpectedConditions.elementToBeClickable(adminPages.adminPlansPageNextButonu));
        js.executeScript("arguments[0].click();", adminPages.adminPlansPageNextButonu);
        ReusableMethods.bekle(1);

        // Back butonuna da aynı şekilde scroll ve explicit wait ile tıklayalım
        js.executeScript("arguments[0].scrollIntoView(true);", adminPages.adminPlansPageBackButonu);
        ReusableMethods.bekle(1);
        wait.until(ExpectedConditions.elementToBeClickable(adminPages.adminPlansPageBackButonu));
        js.executeScript("arguments[0].click();", adminPages.adminPlansPageBackButonu);
    }

    @Test
    public void US29ShowResultsTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();

        adminPages.adminPlansSidebarButonu.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", adminPages.adminPlansShowDropdownButonu);
        ReusableMethods.bekle(1);
        Select perPageSelect = new Select(adminPages.adminPlansShowDropdownButonu);
        perPageSelect.selectByIndex(1); // İkinci seçenek, 25 sonucu temsil ediyor

        // Tablodaki satırların tamamının yüklenmesi için scroll yap
        By rowsLocator = By.xpath("//tbody/tr");
        int previousCount = 0;
        List<WebElement> rows = Driver.getDriver().findElements(rowsLocator);
        while(rows.size() > previousCount) {
            previousCount = rows.size();
            js.executeScript("window.scrollBy(0,500);");
            ReusableMethods.bekle(1);
            rows = Driver.getDriver().findElements(rowsLocator);
        }
        int rowCount = rows.size();
        Assert.assertTrue(rowCount > 10 && rowCount < 26,
                "Tabloda görüntülenen satır sayısı " + rowCount + " beklenen aralıkta değil (11-25)");
    }

    @Test
    public void US29DurationSıralamaTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();

        adminPages.adminPlansSidebarButonu.click();

        // İlk tıklamada (A-Z sıralama): ilk hücrede "Monthly" bekleniyor
        adminPages.adminPlansTabloDurationSiralamaButonu.click();
        ReusableMethods.bekle(3);
        String ascendingValue = adminPages.adminPlansDurationSıralananElement.getText().trim();
        Assert.assertEquals(ascendingValue, "Monthly", "A-Z sıralamada ilk eleman 'Monthly' değil!");

        // İkinci tıklamada (Z-A sıralama): ilk hücrede "Unlimited" bekleniyor
        adminPages.adminPlansTabloDurationSiralamaButonu.click();
        ReusableMethods.bekle(3);
        String descendingValue = adminPages.adminPlansDurationSıralananElement.getText().trim();
        Assert.assertEquals(descendingValue, "Unlimited", "Z-A sıralamada ilk eleman 'Unlimited' değil!");
    }

    @Test
    public void US40DilDeğiştirmeTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();

        adminPages.avatarDropdownMenuButonu.click();
        adminPages.changeLanguageButonu.click();
        adminPages.changeLanguagePopupText.isDisplayed();
        adminPages.changeLanguageDropdownButonu.click();

        adminPages.changeLanguageSearchInput.sendKeys("Turkish" , Keys.ENTER);
        adminPages.changeLanguagePopupKaydetButonu.click();
        ReusableMethods.bekle(7);

        adminPages.avatarDropdownMenuButonu.click();
        adminPages.changeLanguageButonu.click();
        adminPages.changeLanguageDropdownButonu.click();

        adminPages.changeLanguageSearchInput.sendKeys("English" , Keys.ENTER);
        adminPages.changeLanguagePopupKaydetButonu.click();
        ReusableMethods.bekle(3);
    }

    @Test
    public void US40DilDeğiştirmeDiscardTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();

        adminPages.avatarDropdownMenuButonu.click();
        adminPages.changeLanguageButonu.click();
        adminPages.changeLanguagePopupText.isDisplayed();
        adminPages.changeLanguageDropdownButonu.click();

        adminPages.changeLanguageSearchInput.sendKeys("Turkish" , Keys.ENTER);
        adminPages.changeLanguagePopupIptalButonu.click();
        ReusableMethods.bekle(3);
    }

    @Test
    public void US40DilDeğiştirmeXButonTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        anasayfaPages.homepageSıgnInButonu.click();
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        anasayfaPages.signInLoginButonu.click();

        adminPages.avatarDropdownMenuButonu.click();
        adminPages.changeLanguageButonu.click();
        adminPages.changeLanguagePopupText.isDisplayed();
        adminPages.changeLanguageDropdownButonu.click();

        adminPages.changeLanguageSearchInput.sendKeys("Turkish" , Keys.ENTER);
        adminPages.changeLanguagePopupXButonu.click();
        ReusableMethods.bekle(3);
    }

    @Test
    public void US40DilDeğiştirmeNoResultFoundTest(){
        // Raporlama: Test başlatıldı
        extentTest = extentReports.createTest("US40DilDeğiştirmeNoResultFoundTest",
                "Geçersiz arama yapıldığında 'No results found' mesajının görüntülendiğini doğrular");

        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Siteye erişildi: " + ConfigReader.getProperty("url"));

        anasayfaPages.homepageSıgnInButonu.click();
        extentTest.info("Homepage Sign In butonuna tıklandı.");

        ReusableMethods.bekle(1);

        // Sign In sayfasında Email ve Password girilir, giriş yapılır
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        extentTest.info("Admin email girildi: " + ConfigReader.getProperty("adminBurakKmail"));

        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Password girildi.");

        anasayfaPages.signInLoginButonu.click();
        extentTest.info("Sign In butonuna tıklandı, giriş yapıldı.");

        // Avatar dropdown ve Change Language butonuna tıklanır
        adminPages.avatarDropdownMenuButonu.click();
        extentTest.info("Avatar dropdown menüsüne tıklandı.");

        adminPages.changeLanguageButonu.click();
        extentTest.info("Change Language butonuna tıklandı.");

        // Change Language popup metni görüntülendiğini doğrula
        adminPages.changeLanguagePopupText.isDisplayed();
        extentTest.info("Change Language popup metni görüntülendi.");

        // Change Language dropdown açılır
        adminPages.changeLanguageDropdownButonu.click();
        extentTest.info("Change Language dropdown butonuna tıklandı.");

        // Arama alanına 'Deneme' girilir ve Enter'a basılır
        adminPages.changeLanguageSearchInput.sendKeys("Deneme", Keys.ENTER);
        extentTest.info("'Deneme' metni arama alanına girildi ve Enter tuşuna basıldı.");

        // 'No results found' mesajının görüntülendiği doğrulanır
        adminPages.changeLanguageNoResultsFoundText.isDisplayed();
        extentTest.pass("'No results found' mesajı başarıyla görüntülendi.");

        ReusableMethods.bekle(3);
    }



}
