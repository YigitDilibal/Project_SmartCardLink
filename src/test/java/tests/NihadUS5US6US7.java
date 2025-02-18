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


public class NihadUS5US6US7 {
    AnasayfaPages anasayfaPages;
    AdminPages adminPages;
    UserPages userPages;

    @BeforeMethod
    public void setup() {
        anasayfaPages = new AnasayfaPages();
        adminPages = new AdminPages();
        userPages = new UserPages();

    }

    @Test

    public void ZiyaretciTermsConditionsErisim() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.TermsConditionsSayfasi);
        ReusableMethods.bekle(2);
        anasayfaPages.TermsConditionsSayfasi.click();
        ReusableMethods.bekle(2);
        ReusableMethods.urlIleWindowGecisi("https://qa.smartcardlink.com/terms-conditions");
        Assert.assertTrue(anasayfaPages.TitleTermsCondition.isDisplayed());


    }

    @Test

    public void ZiyaretciPrivacyPolicyErisim() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.PrivacyPolicySayfasi);
        ReusableMethods.bekle(2);
        anasayfaPages.PrivacyPolicySayfasi.click();
        ReusableMethods.bekle(2);
        ReusableMethods.urlIleWindowGecisi("https://qa.smartcardlink.com/privacy-policy");
        Assert.assertTrue(anasayfaPages.TitlePrivacyPolicySayfasi.isDisplayed());


    }

    @Test
    public void ZiyaretciFAQsayfasi() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.FAQSayfasi);
        ReusableMethods.bekle(2);
        anasayfaPages.FAQSayfasi.click();
        ReusableMethods.bekle(2);
        ReusableMethods.urlIleWindowGecisi("https://qa.smartcardlink.com/faq");

        Assert.assertTrue(anasayfaPages.TitleFAQSayfasi.isDisplayed());

    }

}
