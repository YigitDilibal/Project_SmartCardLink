package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class BurakKeceliUS15US29US40 {
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
        Driver.quitDriver();
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
        Driver.quitDriver();
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
        Driver.quitDriver();
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
        Driver.quitDriver();
    }

    @Test
    public void US29SeacrhNoDataAvailableTextTest(){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();
        adminPages.adminPlansSidebarButonu.click();
        adminPages.adminPlansTabloSearchInputAlani.sendKeys("Deneme");
        adminPages.adminPlansNoDataAvailableYazisi.isDisplayed();
        Driver.quitDriver();
    }

    @Test
    public void US29SearchYapmaTest(){
        //Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //Yönetici Sıgn ın linkine tıklar ve  Sıgn ın sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        //Sıgn ın sayfasında Email kutusunun oldugunu dogrular ve geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        //Sıgn ın sayfasında password kutusunun oldugunu dogrular ve password kutusununa gecerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        adminPages.adminPlansSidebarButonu.click();
        adminPages.adminPlansTabloSearchInputAlani.sendKeys("Burak");

        Assert.assertTrue(adminPages.adminPlansBurakCell.isDisplayed(), "Tabloda 'Burak' metni içeren hücre bulunamadı!");
        Driver.quitDriver();
    }

    @Test
    public void US29NewPlanOluşturmaveSilmeTest(){
        // Yönetici URL ile siteye erişir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        // Yönetici Sign In linkine tıklar ve Sign In sayfasına erişim sağlar
        anasayfaPages.homepageSıgnInButonu.click();
        // Sign In sayfasında Email kutusuna geçerli mail girer.
        anasayfaPages.signInEmailKutusu.sendKeys(ConfigReader.getProperty("adminBurakKmail"));
        // Sign In sayfasında Password kutusuna geçerli password girer.
        anasayfaPages.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("password"));
        anasayfaPages.signInLoginButonu.click();

        adminPages.adminPlansSidebarButonu.click();
        adminPages.adminPlansSayfasiBaslikYazisi.isDisplayed();
        adminPages.adminPlansNewPlanButonu.click();
        adminPages.adminPlansNewPlanYazisi.isDisplayed();

        // Benzersiz plan ismi oluştur
        String uniquePlanName = "Burak_" + System.currentTimeMillis();
        adminPages.adminPlansNewPlanNameInputAlani.sendKeys(uniquePlanName);

        adminPages.adminPlansFrequencyDropdownButonu.click();
        adminPages.adminPlansFrequencySearchInputAlani.sendKeys("Year");
        adminPages.adminPlansCurrencyDropdownButonu.click();
        adminPages.adminPlansCurrencyInputAlani.sendKeys("USD", Keys.ENTER);
        adminPages.adminPlansPriceInputAlani.sendKeys("100");
        adminPages.adminPlansKartNumarasiInputAlani.sendKeys("1234567890");
        adminPages.adminPlansTrialDaysInputAlani.sendKeys("30");
        adminPages.adminPlansTemplateSecmeAlani.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", adminPages.adminPlansSaveButonu);
        ReusableMethods.bekle(1);
        adminPages.adminPlansFeatureSecmeAlani.click();
        adminPages.adminPlansSaveButonu.click();

        // Oluşturulan planın tabloda göründüğünü kontrol et:
        // Plan adı kontrolü: "Burak_" ile başlayan element
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[starts-with(normalize-space(text()), 'Burak_')]")).isDisplayed(),
                "Tabloda 'Burak_...' metni içeren hücre bulunamadı!");
        // Fiyat kontrolü: "$100.00" metnini içeren <td>
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//td[normalize-space(text())='$100.00']")).isDisplayed(),
                "Tabloda '$100.00' fiyatı bulunamadı!");
        // Süre kontrolü: "Monthly" metnini içeren <span>
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='Monthly']")).isDisplayed(),
                "Tabloda 'Monthly' süresi bulunamadı!");

        // Planı silme adımları
        adminPages.adminPlansDeleteButonu.click();
        adminPages.adminPlansDeletePopupTitle.isDisplayed();
        adminPages.adminPlansDeletePopupYesButonu.click();
        adminPages.adminPlansDeletePopupOkButonu.click();

        // Arama alanına silinen plan adını yazarak aratın
        adminPages.adminPlansTabloSearchInputAlani.clear();
        adminPages.adminPlansTabloSearchInputAlani.sendKeys(uniquePlanName);

        // "No data available" mesajının göründüğünü doğrula
        Assert.assertTrue(adminPages.adminPlansNoDataAvailableYazisi.isDisplayed(),
                "No data available yazısı görünmüyor!");

        Driver.quitDriver();
    }










}
