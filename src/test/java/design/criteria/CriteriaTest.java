package design.criteria;

import design.home.furniture.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CriteriaTest {
    @Test
    public void test(){
        List<Furniture> furnitureList =new ArrayList<>();

        furnitureList.add(new Furniture("木质","水纹","桌子"));
        furnitureList.add(new Furniture("木质","水纹","椅子"));
        furnitureList.add(new Furniture("木质","花纹","桌子"));
        furnitureList.add(new Furniture("木质","花纹","椅子"));
        furnitureList.add(new Furniture("铁质","水纹","椅子"));
        furnitureList.add(new Furniture("铁质","花纹","桌子"));


        Criteria type =new CriteriaTypeImpl();
        System.out.println("搜索木质的家具");
        for(Furniture furniture: type.furnitureList(furnitureList,"木质")){
            System.out.println("家具："+furniture.getType()+furniture.getTexture()+furniture.getName());
        }

        System.out.println("搜索花纹家具");
        Criteria texture = new CriteriaTextureImpl();
        for(Furniture furniture: texture.furnitureList(furnitureList,"花纹")){
            System.out.println("家具："+furniture.getType()+furniture.getTexture()+furniture.getName());
        }
        System.out.println("搜索桌子");
        Criteria name = new CriteriaNameImpl();
        for(Furniture furniture: name.furnitureList(furnitureList,"桌子")){
            System.out.println("家具："+furniture.getType()+furniture.getTexture()+furniture.getName());
        }

    }
}
