package design.home.item;

import design.home.furniture.Furniture;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    private  List<String> itemList;

    public ItemFactory(){
        itemList =new ArrayList<>();
    }

    public void addItem(String name){
        itemList.add(name);
    }

    public  AbstractItem getItem(String name){
        for(String each:itemList){
            if(name.equalsIgnoreCase(each)){
                return new RealItem(name);
            }
        }
        return new NullItem();
    }
}
