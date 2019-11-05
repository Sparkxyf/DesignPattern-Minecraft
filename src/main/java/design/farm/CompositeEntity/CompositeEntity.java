package design.farm.CompositeEntity;

public class CompositeEntity {
    private PetFamily petFamily = new PetFamily();

    public void setPetsName(String data1, String data2){
        petFamily.setData(data1, data2);
    }

    public String[] getPetsName(){
        return petFamily.getData();
    }
}

