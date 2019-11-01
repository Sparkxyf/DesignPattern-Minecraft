package design.farm;

public class FieldFactory implements FarmlandAbstractFactory {
    public FarmLand createFarmland()
    {
        return Field.creator.create();
    }
}
