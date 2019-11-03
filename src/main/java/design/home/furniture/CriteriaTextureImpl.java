package design.home.furniture;

import java.util.ArrayList;
import java.util.List;

public class CriteriaTextureImpl implements Criteria {

    @Override
    public List<Furniture> furnitureList(List<Furniture> furnitureList, String rule) {
        List<Furniture> furnitureTextureList = new ArrayList<>();

        for (Furniture furniture : furnitureList) {
            if (furniture.getTexture().equalsIgnoreCase(rule)) {
                furnitureTextureList.add(furniture);
            }
        }
        return furnitureTextureList;
    }
}
