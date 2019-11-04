package design.farm.Specification;

import design.farm.*;

public class HasProductThan extends CompositeSpecification{
    private Integer number;
    public HasProductThan(Integer number) {
        this.number = number;
    }
    @Override
    public boolean isSatisfiedBy(FarmLand item) {
        if(Farm.class.isAssignableFrom(item.getClass())) {
            Farm farmLand = (Farm) item;
            return farmLand.animals.size() >= number;
        }
        else if(Field.class.isAssignableFrom(item.getClass())) {
            Field farmLand = (Field) item;
            return farmLand.plants.size() >= number;
        }
        return false;
    }
}
