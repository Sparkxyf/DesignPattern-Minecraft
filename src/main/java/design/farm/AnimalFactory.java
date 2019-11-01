package design.farm;

public class AnimalFactory extends AbstractFactory {
    @Override
    public <T extends Animal> Animal createAnimal(Class<T> type) {
        if(Animal.class.isAssignableFrom(type)) {
            try{
                return type.newInstance();
            }
            catch(IllegalAccessException | InstantiationException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public <T extends Plant> Plant createPlant(Class<T> type) {
        return null;
    }
}
