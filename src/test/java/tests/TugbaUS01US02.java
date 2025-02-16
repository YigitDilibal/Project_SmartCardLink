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
}
