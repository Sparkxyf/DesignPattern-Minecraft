package design.prototype;

import design.farm.*;
import org.junit.Test;

public class PrototypeTest {
    @Test
    public void test(){
        Field field1 = (Field) FarmlandAbstractFactory.getFactory(Field.class).createFarmland();
        System.out.println("原型创建成功");
        Field field2 = field1.Clone();
        System.out.println("原型复制成功");
        System.out.println("field1==field2？"+(field1==field2));
    }

}
