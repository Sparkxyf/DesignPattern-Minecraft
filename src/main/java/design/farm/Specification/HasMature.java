package design.farm.Specification;

import design.farm.*;

public class HasMature extends CompositeSpecification{
    @Override
    public boolean isSatisfiedBy(FarmLand item) {
        if(Farm.class.isAssignableFrom(item.getClass())) {
            Farm farmLand = (Farm) item;
            for(Animal animal:farmLand.animals){
                if(animal.stringify().equals("成年鸡") || animal.stringify().equals("成年牛")){
                    return true;
                }
            }
        }
        else if(Field.class.isAssignableFrom(item.getClass())) {
            Field farmLand = (Field) item;
            for(Plant plant:farmLand.plants){
                if(plant.stringify().equals("成熟的小麦")||plant.stringify().equals("大茄子")){
                    return true;
                }
            }
        }
        return false;
    }
}
