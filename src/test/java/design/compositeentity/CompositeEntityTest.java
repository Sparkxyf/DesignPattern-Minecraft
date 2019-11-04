package design.compositeentity;

import design.farm.CompositeEntity.PetClient;
import design.farm.Farm;
import design.farm.FarmLand;
import design.farm.FarmlandAbstractFactory;
import design.farm.Field;
import org.junit.Test;

public class CompositeEntityTest {
    @Test
    public void test(){
        System.out.println("=====Composite Entity Test=====");
        PetClient petClient = new PetClient();
        petClient.printPetsName();
        petClient.setPetsName("数据结构", "离散数学");
        petClient.printPetsName();
    }
}
