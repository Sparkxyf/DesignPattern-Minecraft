package design.home.furniture;

import java.util.ArrayList;
import java.util.List;

public class CriteriaNameImpl implements Criteria {

    @Override
    public List<Furniture> furnitureList(List<Furniture> furnitureList,String rule) {
        List<Furniture> furnitureNameList = new ArrayList<>();

        for (Furniture furniture : furnitureList) {
            if (furniture.getName().equalsIgnoreCase(rule)) {
                furnitureNameList.add(furniture);
            }
        }
        return furnitureNameList;
    }
}
