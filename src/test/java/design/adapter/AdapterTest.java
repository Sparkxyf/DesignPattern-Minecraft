package design.adapter;

import design.farm.Farm;
import design.farm.FarmLand;
import org.junit.Test;

public class AdapterTest {
    @Test
    public void test() {
        System.out.println("============Adapter Test==============");
        Farm farm1 = new Farm();
        Farm farm2 = new Farm();
        farm1.setBuyer("chicken");
        farm2.setBuyer("cow");
        System.out.println("farm1 can buy "+farm1.animalBuyer.buy());
        System.out.println("farm2 can buy "+farm2.animalBuyer.buy());
    }
}
