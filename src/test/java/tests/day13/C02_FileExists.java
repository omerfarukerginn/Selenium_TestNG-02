package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home")); // C:\Users\omerf


        // masaustundeki klasorun Path'ini istesen
        // "C:\Users\omerf\Desktop\MyResume"

        // Yani dinamik olarak masaustumdeki Deneme klasorunun path'ini yazmak istersem

        String path = System.getProperty("user.home")+"\\Desktop\\MyResume\\resume.html";

        System.out.println(path);

        System.out.println("user.dir   : "+System.getProperty("user.dir"));

        // Masaustunde MyResume klasoru icerisinde resume.html isminde bir dosya oldugunu test edin
        // *********** masaustunde klasor ve icinde istenen dosya olmazsa CALISMAZ********
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MyResume\\resume.html";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        // projemizde pom.xml oldugunu test edin
        // C:\Users\omerf\IdeaProjects\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\omerf\IdeaProjects\com.TestNGBatch44

        String pomPath=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));



    }
}
