package design.home.furniture;

import java.util.ArrayList;
import java.util.List;

public class CriteriaTypeImpl implements Criteria{

    @Override
    public List<Furniture> furnitureList(List<Furniture> furnitureList, String rule) {
        List<Furniture> furnitureTypeList = new ArrayList<>();

        for (Furniture furniture : furnitureList) {
            if (furniture.getType().equalsIgnoreCase(rule)) {
                furnitureTypeList.add(furniture);
            }
        }
        return furnitureTypeList;
    }
}
