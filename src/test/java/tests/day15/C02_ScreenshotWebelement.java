package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebelement extends TestBase {

    @Test
    public void nutellaTesti() throws InterruptedException, IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // nutella icin arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutellla icerdigini test edelim
        WebElement sonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucSayisiStr=sonucElementi.getText();
        String istenenSonuc="Nutella";

        Assert.assertTrue(sonucSayisiStr.contains(istenenSonuc));

        // testin calistiginin ispati icin sonuc yazisi web elementinin screenshot'ini alalım

        // tum sayfa screenshot icin 4 adim gerekli

        // 1- adim screenshot cekecegimiz webelementi locate edelim


        // 2- screenshot'u kaydedecegimiz bir file olusturalim

        File webelementSS=new File("target/screenShot/webelement.jpeg");


        // 3. adim

        File geciciResim=sonucElementi.getScreenshotAs(OutputType.FILE);

        // 4- gecici resmi kaydetmek istedigimiz asil dosyaya copy yapalim

        FileUtils.copyFile(geciciResim,webelementSS);


        Thread.sleep(5000);


    }
}
