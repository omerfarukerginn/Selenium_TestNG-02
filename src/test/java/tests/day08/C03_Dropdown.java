package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    //● Bir class oluşturun: DropDown


    @Test
    public void dropdownTesti(){
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select=new Select(dropdownElementi);

        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());

        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText());

        //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText());

        //    4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionList=select.getOptions();

        for (WebElement each: optionList
             ) {
            System.out.println(each.getText());
        }

        //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

        int actualSize =optionList.size();
        int expectdedSize= 4;

        Assert.assertEquals(actualSize,expectdedSize,"Opsiyon sayisi beklentileri karsilamiyor.");

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }


}
