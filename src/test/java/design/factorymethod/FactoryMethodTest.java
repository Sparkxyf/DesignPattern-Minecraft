package design.factorymethod;

import design.farm.*;
import org.junit.Test;

public class FactoryMethodTest {
    @Test
    public void test(){
        FarmLand farm;
        FarmLand field;
        FarmlandAbstractFactory farmFactory = FarmlandAbstractFactory.getFactory(Farm.class);
        farm=farmFactory.createFarmland();
        System.out.println("牧场工厂生产了->牧场");
        System.out.println("牧场信息："+farm.stringify());

        FarmlandAbstractFactory filedFactory = FarmlandAbstractFactory.getFactory(Field.class);
        field=filedFactory.createFarmland();
        System.out.println("菜地工厂生产了->菜地");
        System.out.println("菜地信息："+field.stringify());
    }

}
