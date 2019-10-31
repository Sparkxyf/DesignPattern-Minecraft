package design.farm;


public abstract class AbstractFactory {
    public abstract <T extends Animal> Animal createAnimal(Class<T> type);

    public abstract <T extends Plant> Plant createPlant(Class<T> type);

    static AbstractFactory getFactory(Class type) {
        if(Animal.class.isAssignableFrom(type)) {
            return new AnimalFactory();
        }
        if(Plant.class.isAssignableFrom(type)) {
            return new PlantFactory();
        }
        return null;
    }
}
