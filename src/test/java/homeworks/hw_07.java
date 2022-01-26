package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class hw_07 {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla


    @Test (priority = 0)
    public void test01(){
        // https://www.n11.com/ SAYFASINA GiDİN.

        driver.navigate().to("https://www.n11.com/");
    }


    @Test (priority = 1)
    public void test02(){
        // https://www.gittigidiyor.com/ SAYFASINA GiDiN

        driver.navigate().to("https://www.gittigidiyor.com/");
    }


    @Test (priority = 3)
    public void test03(){
        // https://getir.com/ SAYFASINA GiDiN

        driver.navigate().to("https://getir.com/");
    }


    @Test (priority = 7)
    public void test04(){
        // https://www.sahibinden.com/ SAYFASINA GiDiN

        driver.navigate().to("https://www.sahibinden.com/");
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }


}
