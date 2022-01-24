package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown  {

    WebDriver driver;
    WebElement dropdownElementi;
    Select select;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void dropdownTesti01(){
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        select =new Select(dropdownElementi);

        List<WebElement> optionList=select.getOptions();

        int actualOptionSayisi = optionList.size();
        int expectedOptionSayisi=45;

        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi,"Belirtilen sayi ile uygunluk saglanamadi");

    }

    @Test
    public void dropdownTesti02() throws InterruptedException {
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");

        //    2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //    3. Bulunan sonuc sayisini yazdirin
        String sonucSayisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        System.out.println(sonucSayisi);

        //    4. Sonucun Java kelimesini icerdigini test edin

        String actualSonuc=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String istenenKelime="Java";

        Assert.assertTrue(actualSonuc.contains(istenenKelime));

        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }

}
