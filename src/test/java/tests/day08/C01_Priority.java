package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test (priority = 9)
    public void youtubeTesti(){ // priority atanmasi durumunda kucukten buyuge dogru calisma sirasi izler.
        System.out.println("Youtube testi calisti");

    }

    @Test (priority = 8)
    public void amazonTesti(){ // priority atanmazsa default degeri 0'dir.
        System.out.println("Amazon testi calisti");

    }

    @Test (priority = 5)
    public void bestbuyTesti(){ // priority atanmadigi durumda ascii degerine gore test ismi baz alinarak kucukten buyuge calisma sirasi izler.
        System.out.println("Bestbuy testi calisti");

    }


}
