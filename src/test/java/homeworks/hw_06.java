package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class hw_06 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    }


    @Test
    public void test01(){
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String textElementi=driver.findElement(By.tagName("h3")).getText();
        String istenenText="Opening a new window";

        Assert.assertEquals(istenenText, textElementi);

    }

    @Test
    public void test02(){
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String istenenTitle="The Internet";

        Assert.assertEquals(actualTitle,istenenTitle);
    }


    @Test
    public void test03() throws InterruptedException {
//● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        Thread.sleep(3000);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle= driver.getTitle();
        String istenenTitle="New Window";

        Assert.assertEquals(actualTitle,istenenTitle);

    }


    @Test
    public void test04(){
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newTextElement=driver.findElement(By.xpath("//div[@class='example']")).getText();
        String istenenNewText="New Window";

        Assert.assertEquals(newTextElement,istenenNewText);
    }


    @Test
    public void test05(){
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        String backTitle= driver.getTitle();
        String istenenBackTitle="The Internet";

        Assert.assertTrue(backTitle.equals(istenenBackTitle));
    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
