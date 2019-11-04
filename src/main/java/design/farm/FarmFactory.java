package design.farm;

public class FarmFactory implements FarmlandAbstractFactory {
    public FarmLand createFarmland()
    {
        return Farm.creator.create();
    }
}