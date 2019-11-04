package design.home.furniture;

import java.util.ArrayList;
import java.util.List;

public class FurnitureData {

    List<Furniture> furnitureList;

    public FurnitureData(){
        furnitureList =new ArrayList<>();
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public Furniture getFurniture(int index) {
        return furnitureList.get(index);
    }

    public void addFurniture(Furniture furniture){
        furnitureList.add(furniture);
    }

    public void updateFurniture(Furniture furniture,int index){
        furnitureList.set(index,furniture);
    }

    public void deleteFurniture(int index){
        furnitureList.remove(index);
    }


}
