package design.nullobject;

import design.home.item.AbstractItem;
import design.home.item.ItemFactory;
import org.junit.Test;

public class NullObjectTest {
    @Test
    public void test(){

        ItemFactory itemFactory =new ItemFactory();
        itemFactory.addItem("桌子");
        itemFactory.addItem("椅子");
        AbstractItem item1 = itemFactory.getItem("桌子");
        AbstractItem item2 = itemFactory.getItem("椅子");
        AbstractItem item3 = itemFactory.getItem("板凳");

        System.out.println("家具模板");
        System.out.println(item1.getName());
        System.out.println(item2.getName());
        System.out.println(item3.getName());

    }
}
