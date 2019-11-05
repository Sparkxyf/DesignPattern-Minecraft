package design.farm.CompositeEntity;

public class PetFamily {
    PetDog petDog = new PetDog();
    PetCat petCat = new PetCat();

    public void setData(String data1, String data2){
        petDog.setData(data1);
        petCat.setData(data2);
    }

    public String[] getData(){
        return new String[] {petDog.getData(),petCat.getData()};
    }
}
