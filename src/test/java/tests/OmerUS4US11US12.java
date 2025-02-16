package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AnasayfaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OmerUS4US11US12 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    String mainURL;
    String destinationURL;
    String actualURL;
    String expectedURL;

    @Test
    public void US4TC1FacebookTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        jse.executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.socialMediaIcons.getFirst());
        ReusableMethods.bekle(1); // Sayfanın en alta inmesi için biraz süre geçiyor.
                                        // Elementi bulamazsa diye eklenildi.
        mainURL = Driver.getDriver().getCurrentUrl();
        anasayfaPages.socialMediaIcons.getFirst().click();
        wait.until(driver -> Driver.getDriver().getWindowHandles().size() > 1);
        destinationURL = anasayfaPages.socialMediaIcons.getFirst().getDomAttribute("href");
        expectedURL = "https://www.facebook.com/";
        ReusableMethods.urlIleWindowGecisi(destinationURL);
        actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
/*
        **************BİR SONRAKİ PROJE İÇİN****************
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < anasayfaPages.socialMediaIcons.size(); i++) {
            anasayfaPages.socialMediaIcons.get(i).click();
            wait.until(driver -> Driver.getDriver().getWindowHandles().size() > 1);
            destinationWindow = anasayfaPages.socialMediaIcons.get(i).getAttribute("href");
            String expectedTitle = anasayfaPages.socialMediaIcons.get(i).getAttribute("title").toLowerCase();
            ReusableMethods.urlIleWindowGecisi(destinationWindow);
            String actualURL = Driver.getDriver().getCurrentUrl();
            try{
                softAssert.assertTrue(actualURL.contains(expectedTitle));
            }catch (Exception e){
                errorMessages.add(e.getMessage());
            }
            ReusableMethods.urlIleWindowGecisi(mainWindow);

        }
        softAssert.assertAll();

        if (!errorMessages.isEmpty()){
            Assert.fail("Test failed due to the following errors:\n" + String.join("\n", errorMessages));
        }*/

    }

    @Test
    public void US4TC2XTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        jse.executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.socialMediaIcons.get(1));
        ReusableMethods.bekle(1); // Sayfanın en alta inmesi için biraz süre geçiyor.
        // Elementi bulamazsa diye eklenildi.
        mainURL = Driver.getDriver().getCurrentUrl();
        anasayfaPages.socialMediaIcons.get(1).click();
        wait.until(driver -> Driver.getDriver().getWindowHandles().size() > 1);
        destinationURL = anasayfaPages.socialMediaIcons.get(1).getDomAttribute("href");
        expectedURL = "https://www.x.com/";
        ReusableMethods.urlIleWindowGecisi(destinationURL);
        actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void US4TC3InstagramTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        jse.executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.socialMediaIcons.get(2));
        ReusableMethods.bekle(1); // Sayfanın en alta inmesi için biraz süre geçiyor.
        // Elementi bulamazsa diye eklenildi.
        mainURL = Driver.getDriver().getCurrentUrl();
        anasayfaPages.socialMediaIcons.get(2).click();
        wait.until(driver -> Driver.getDriver().getWindowHandles().size() > 1);
        destinationURL = anasayfaPages.socialMediaIcons.get(2).getDomAttribute("href");
        expectedURL = "https://www.instagram.com/";
        ReusableMethods.urlIleWindowGecisi(destinationURL);
        actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void US4TC4LinkedinTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        jse.executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.socialMediaIcons.get(3));
        ReusableMethods.bekle(1); // Sayfanın en alta inmesi için biraz süre geçiyor.
        // Elementi bulamazsa diye eklenildi.
        mainURL = Driver.getDriver().getCurrentUrl();
        anasayfaPages.socialMediaIcons.get(3).click();
        wait.until(driver -> Driver.getDriver().getWindowHandles().size() > 1);
        destinationURL = anasayfaPages.socialMediaIcons.get(3).getDomAttribute("href");
        expectedURL = "https://www.linkedin.com/";
        ReusableMethods.urlIleWindowGecisi(destinationURL);
        actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void US4TC5PinterestTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        jse.executeScript("arguments[0].scrollIntoView(true);", anasayfaPages.socialMediaIcons.get(4));
        ReusableMethods.bekle(1); // Sayfanın en alta inmesi için biraz süre geçiyor.
        // Elementi bulamazsa diye eklenildi.
        mainURL = Driver.getDriver().getCurrentUrl();
        anasayfaPages.socialMediaIcons.get(4).click();
        wait.until(driver -> Driver.getDriver().getWindowHandles().size() > 1);
        destinationURL = anasayfaPages.socialMediaIcons.get(4).getDomAttribute("href");
        expectedURL = "https://www.pinterest.com/";
        ReusableMethods.urlIleWindowGecisi(destinationURL);
        actualURL = Driver.getDriver().getCurrentUrl(); // Normalde destinationURL ile de kontrol edilebilir. Fakat böylesi çift koruma olur.
        Assert.assertEquals(actualURL,expectedURL); // Remote olarak çalıştırılırsa hata vermez.
    }
}