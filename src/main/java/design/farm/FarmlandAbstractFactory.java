package design.farm;

public interface FarmlandAbstractFactory
{
    public abstract FarmLand createFarmland();

    static FarmlandAbstractFactory getFactory(Class type) {
        if(Farm.class.isAssignableFrom(type)) {
            return new FarmFactory();
        }
        if(Field.class.isAssignableFrom(type)) {
            return new FieldFactory();
        }
        return null;
    }
}