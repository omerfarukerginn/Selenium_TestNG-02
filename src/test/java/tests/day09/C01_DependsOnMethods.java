package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //● https://www.amazon.com/ adresine gidin.
    //	1. Test : Amazon ana sayfaya gittiginizi test edin
    @Test
    public void logoTest(){
        driver.get("https://www.amazon.com");
        WebElement logoElementi= driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }
    //	2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //	arama yapin ve aramanizin gerceklestigini Test edin
    @Test (dependsOnMethods = "logoTest")
    public void aramaTesti(){
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String actualTitle= driver.getTitle();
        String arananKelime="Nutella";

        Assert.assertTrue(actualTitle.contains(arananKelime));
    }
    //	3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
    @Test (dependsOnMethods = "aramaTesti")
    public void fiyatTesti(){
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement urunFiyatElementi=driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        String urunFiyatiString=urunFiyatElementi.getText();
        String arananFiyat="$14.99";

        Assert.assertTrue(urunFiyatiString.contains(arananFiyat));
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }

}
