package design.farm;

public class PlantFactory extends AbstractFactory {
    @Override
    public <T extends Animal> Animal createAnimal(Class<T> type) {
        return null;
    }

    @Override
    public <T extends Plant> Plant createPlant(Class<T> type) {
        return null;
    }
}
