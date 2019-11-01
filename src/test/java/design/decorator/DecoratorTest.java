package design.decorator;

import design.home.decorate.*;
import org.junit.Test;

public class DecoratorTest {
    @Test
    public void test(){
        MyHomeInterface home = new OriginalHome();
        home.show();
        MyHomeInterface home2 =new SpringFestival(home);
        home.show();
        home2.show();
        home.show();
        home2.show();
        MyHomeInterface home1 =new Christmas(home);
        home.show();
        home1.show();
        home1 =new SpringFestival(home);
        home.show();
        home1.show();
    }
}
