package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPages;
import pages.AnasayfaPages;
import pages.UserPages;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class TugbaUS01US02 {

    AnasayfaPages anasayfaPages = new AnasayfaPages();
    AdminPages adminPages = new AdminPages();
    UserPages userPages = new UserPages();

    @Test
    public void test01() {   //Sifre girerek kullanicinin sayfaya girisi

        driver.get("https://qa.smartcardlink.com/");

        driver.findElement(By.xpath("//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")).click();

        ReusableMethods.bekle(2);

        WebElement eMailKutusu = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        actions.click(eMailKutusu)
                .sendKeys("tugba@smartcardlink.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("S")
                .keyUp(Keys.SHIFT)
                .sendKeys("mart.1202")
                .perform();

        ReusableMethods.bekle(2);

        WebElement loginButonu = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        loginButonu.click();

        ReusableMethods.bekle(3);

        driver.get("https://qa.smartcardlink.com/");

        ReusableMethods.bekle(3);

        driver.findElement(By.xpath("//*[@*='btn btn-white fs-18 ms-3 d-lg-block d-none']")).click();
        ReusableMethods.bekle(3);

        String expectedLink = "https://qa.smartcardlink.com/admin/dashboard";
        String actualLink = driver.getCurrentUrl();


        Assert.assertEquals(expectedLink, actualLink);
        ReusableMethods.bekle(3);
    }

    @Test
    public void Test02() {

        driver.get("https://qa.smartcardlink.com/");

        driver.findElement(By.xpath("//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")).click();

        ReusableMethods.bekle(2);

        WebElement eMailKutusu = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        actions.click(eMailKutusu)
                .sendKeys("tugba@smartcardlink.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("S")
                .keyUp(Keys.SHIFT)
                .sendKeys("mart.1202")
                .perform();

        ReusableMethods.bekle(2);

        WebElement loginButonu = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        loginButonu.click();

        ReusableMethods.bekle(3);

        driver.get("https://qa.smartcardlink.com/");

        ReusableMethods.bekle(3);

        //WebElement getStartedButonu = driver.findElement(By.xpath("//input[@class='btn btn-orange']"));
        driver.findElement(By.xpath("//a[@class='btn btn-orange ']")).click();

        // Assertions.assertTrue(getStartedButonu.isDisplayed());
        ReusableMethods.bekle(2);
        //getStartedButonu.click();
        //ReusableMethods.bekle(2);

        String expectedUrl = "https://qa.smartcardlink.com/admin/dashboard";
        String actuallUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actuallUrl);

        ReusableMethods.bekle(2);

    }

    @Test
    public void Test03() {

        driver.get("https://qa.smartcardlink.com/");

        driver.findElement(By.xpath("//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")).click();

        ReusableMethods.bekle(2);

        WebElement eMailKutusu = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        actions.click(eMailKutusu)
                .sendKeys("tugba@smartcardlink.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("S")
                .keyUp(Keys.SHIFT)
                .sendKeys("mart.1202")
                .perform();

        ReusableMethods.bekle(2);

        WebElement loginButonu = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        loginButonu.click();

        ReusableMethods.bekle(3);

        driver.get("https://qa.smartcardlink.com/");

        ReusableMethods.bekle(3);

        WebElement contact = driver.findElement(By.xpath("(//a[@class='nav-link mt-1'])[4]"));

        contact.click();

        String expectedLink = "https://qa.smartcardlink.com/#frontContactUsTab";
        String actualLink = driver.getCurrentUrl();

        Assert.assertEquals(expectedLink, actualLink);

        WebElement contactText = driver.findElement(By.xpath("//*[@class='heading text-success text-center margin-b-80px mb-5']"));

        String expectedText = "Contact Us";
        String actuallText = contactText.getText();

        Assert.assertEquals(expectedText, actuallText);

        ReusableMethods.bekle(3);


    }

    @Test
    public void Test04() {

        driver.get("https://qa.smartcardlink.com/");

        driver.findElement(By.xpath("//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")).click();

        ReusableMethods.bekle(2);

        WebElement eMailKutusu = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        actions.click(eMailKutusu)
                .sendKeys("tugba@smartcardlink.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("S")
                .keyUp(Keys.SHIFT)
                .sendKeys("mart.1202")
                .perform();

        ReusableMethods.bekle(2);

        WebElement loginButonu = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        loginButonu.click();

        ReusableMethods.bekle(3);

        driver.get("https://qa.smartcardlink.com/");

        ReusableMethods.bekle(3);

        WebElement pricing = driver.findElement(By.xpath("(//*[@class='nav-link mt-1'])[3]"));

        pricing.click();
        ReusableMethods.bekle(2);

        String expectedLink = "https://qa.smartcardlink.com/#frontPricingTab";
        String actualLink = driver.getCurrentUrl();

        Assert.assertEquals(expectedLink, actualLink);
        ReusableMethods.bekle(2);

        String expectedText = "Choose a plan that's right for you";

        String actualText = driver.findElement(By.xpath("(//h2[@class='text-dark text-center mb-60'])[2]")).getText();

        Assert.assertEquals(expectedText, actualText);
        ReusableMethods.bekle(2);

    }

    @Test
    public void Test05() {

        driver.get("https://qa.smartcardlink.com/");

        driver.findElement(By.xpath("//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")).click();

        ReusableMethods.bekle(2);

        WebElement eMailKutusu = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        actions.click(eMailKutusu)
                .sendKeys("tugba@smartcardlink.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("S")
                .keyUp(Keys.SHIFT)
                .sendKeys("mart.1202")
                .perform();

        ReusableMethods.bekle(2);

        WebElement loginButonu = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        loginButonu.click();

        ReusableMethods.bekle(3);

        driver.get("https://qa.smartcardlink.com/");

        ReusableMethods.bekle(3);

        WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link mt-1'])[2]"));

        about.click();
        ReusableMethods.bekle(2);

        String expectedLink = "https://qa.smartcardlink.com/#frontAboutTabUsTab";
        String actualLink = driver.getCurrentUrl();

        Assert.assertEquals(expectedLink, actualLink);
        ReusableMethods.bekle(2);

        String expectedText = "About SmartCard";

        String actualText = driver.findElement(By.id("frontAboutTabUsTab")).getText();

        Assert.assertEquals(expectedText, actualText);
        ReusableMethods.bekle(2);

    }

    //User story 02 kodlari

    @Test
    public void test06() {   //Sifre girerek kullanicinin sayfaya girisi

        driver.get("https://qa.smartcardlink.com/");

        WebElement signInButonu = driver.findElement(By.xpath("//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']"));

        Assert.assertTrue(signInButonu.isDisplayed());
        ReusableMethods.bekle(2);

        signInButonu.click();
        ReusableMethods.bekle(2);

        String expectedUrl = "https://qa.smartcardlink.com/login";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

        ReusableMethods.bekle(2);

        String actualText = driver.findElement(By.xpath("//*[@*='text-center mb-7']")).getText();
        String expectedText = "Sign In";

        Assert.assertTrue(actualText.contains(expectedText));

        ReusableMethods.bekle(2);
    }

    @Test
    public void test07() {   //Sifre girerek kullanicinin sayfaya girisi

        driver.get("https://qa.smartcardlink.com/");

        WebElement features = driver.findElement(By.xpath("(//*[@class='nav-link mt-1'])[1]"));

        Assert.assertTrue(features.isDisplayed());
        ReusableMethods.bekle(2);

        features.click();
        ReusableMethods.bekle(2);

        String expectedUrl = "https://qa.smartcardlink.com/#frontFeaturesTab";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

        ReusableMethods.bekle(2);

        String actualText = driver.findElement(By.xpath("(//h2[@class='text-dark text-center mb-60'])[1]")).getText();
        String expectedText = "Features";

        Assert.assertTrue(actualText.contains(expectedText));

        ReusableMethods.bekle(2);
    }

    @Test
    public void test08() {   //Sifre girerek kullanicinin sayfaya girisi

        driver.get("https://qa.smartcardlink.com/");

        WebElement logo = driver.findElement(By.xpath("//*[@class='img-fluid navbar-logo']"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);
        actions.doubleClick().perform();
        ReusableMethods.bekle(3);
        WebElement subscribe = driver.findElement(By.xpath("//*[@class='text-dark text-center mb-3']"));

        Assert.assertTrue(subscribe.isDisplayed());
        ReusableMethods.bekle(3);
    }

    @Test
    public void test09() {   //Sifre girerek kullanicinin sayfaya girisi

        driver.get("https://qa.smartcardlink.com/");

        WebElement smartCardLinks = driver.findElement(By.xpath("//*[@class='text-dark mb-1']"));

        Assert.assertTrue(smartCardLinks.isDisplayed());
        ReusableMethods.bekle(3);
    }

}
