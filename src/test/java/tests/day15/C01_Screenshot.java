package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

    @Test
    public void nutellaTesti() throws InterruptedException, IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // nutella icin arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutellla icerdigini test edelim
        String sonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String istenenSonuc="Nutella";

        Assert.assertTrue(sonucElementi.contains(istenenSonuc));

        // testin calistiginin ispati icin tum sayfanin screenshot'ini alalım

        // tum sayfa screenshot icin 4 adim gerekli
        // 1- adim TakeScreenShot objesi olusturalim

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- kaydedecegimiz dosyayi olusturalim

        File tumSayfaSS = new File("target/screenShot/tumsayfa.png");

        // 3- bir dosya daha olusturup screenshot objesi ile screenshot'i alalim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici desmi kaydetmek istedigimiz asil dosyaya copy yapalim

        FileUtils.copyFile(geciciResim,tumSayfaSS);


        Thread.sleep(5000);


    }



}
