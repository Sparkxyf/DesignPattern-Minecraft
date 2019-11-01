package design.abstractfactory;

import design.farm.*;
import org.junit.Test;

public class AbstractFactoryTest {
    @Test
    public void test(){
        Animal chicken;
        Animal cow;
        System.out.println("牧场：");
        AbstractFactory animalFactory = AbstractFactory.getFactory(Animal.class);
        chicken = animalFactory.createAnimal(Chicken.class);
        System.out.println("牧场生产了->鸡");
        System.out.println("鸡信息：这是一只"+chicken.stringify());
        cow = animalFactory.createAnimal(Cow.class);
        System.out.println("牧场生产了->牛");
        System.out.println("牛信息：这是一头"+cow.stringify());

        System.out.println("");
        Plant wheat;
        Plant eggplant;
        System.out.println("菜地：");
        AbstractFactory plantFactory = AbstractFactory.getFactory(Plant.class);
        wheat = plantFactory.createPlant(Wheat.class);
        System.out.println("菜地生产了->小麦");
        System.out.println("小麦信息：这是一株"+wheat.stringify());
        eggplant = plantFactory.createPlant(Eggplant.class);
        System.out.println("菜地生产了->茄子");
        System.out.println("茄子信息：这是一个"+eggplant.stringify());


    }

}
