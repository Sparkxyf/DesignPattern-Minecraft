package design.transfer;

import design.home.furniture.Furniture;
import design.home.furniture.FurnitureData;
import org.junit.Test;

public class TransferObjectTest {
    @Test
    public void test(){
        FurnitureData furnitureData =new FurnitureData();
        furnitureData.addFurniture(new Furniture("木质","水纹","桌子"));
        furnitureData.addFurniture(new Furniture("木质","水纹","椅子"));
        furnitureData.addFurniture(new Furniture("铁质","水纹","椅子"));

        System.out.println("初始化");

        for(Furniture furniture: furnitureData.getFurnitureList()){
            System.out.println("家具："+furniture.getType()+furniture.getTexture()+furniture.getName());
        }
        System.out.println("测试传输对象");
        furnitureData.deleteFurniture(0);
        for(Furniture furniture: furnitureData.getFurnitureList()){
            System.out.println("家具："+furniture.getType()+furniture.getTexture()+furniture.getName());
        }
    }
}
